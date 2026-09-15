@echo off

echo Parando Tomcat...
call "D:\Programas\apache-tomcat-9.0.121\bin\shutdown.bat"

timeout /t 3 /nobreak >nul

echo Criando projeto com Maven...
call mvn clean package

echo Apagando versao antiga...
del /f /q "D:\Programas\apache-tomcat-9.0.121\webapps\AplicacaoWebService.war"
rmdir /s /q "D:\Programas\apache-tomcat-9.0.121\webapps\AplicacaoWebService"

echo Copiando nova versao...
copy /Y "target\AplicacaoWebService.war" "D:\Programas\apache-tomcat-9.0.121\webapps\"

echo Iniciando Tomcat...
call "D:\Programas\apache-tomcat-9.0.121\bin\startup.bat"

echo Deploy concluido!
pause