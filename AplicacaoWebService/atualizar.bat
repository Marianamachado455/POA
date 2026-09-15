@echo off

echo Parando Tomcat...
call D:\Programas\apache-tomcat-9.0.121\bin\shutdown.bat
timeout /t 2 /nobreak

echo Removendo versao antiga...
rmdir /S /Q D:\Programas\apache-tomcat-9.0.121\webapps\AplicacaoWebService
del /Q D:\Programas\apache-tomcat-9.0.121\webapps\AplicacaoWebService.war

echo Gerando projeto...
call mvn clean package

echo Copiando projeto...
copy /Y target\AplicacaoWebService.war D:\Programas\apache-tomcat-9.0.121\webapps\AplicacaoWebService.war

echo Iniciando Tomcat...
call D:\Programas\apache-tomcat-9.0.121\bin\startup.bat
echo.
echo Projeto atualizado!

pause