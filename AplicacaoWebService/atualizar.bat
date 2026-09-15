@echo off

echo Parando Tomcat...
call D:\Programas\apache-tomcat-9.0.121\bin\shutdown.bat

timeout /t 2 /nobreak

echo Removendo versao antiga...
rmdir /S /Q D:\Programas\apache-tomcat-9.0.121\webapps\ProjetoNovoWeb-1.0.0

echo Gerando projeto...
call mvn clean package

echo Copiando projeto...
copy /Y target\ProjetoNovoWeb-1.0.0.war D:\Programas\apache-tomcat-9.0.121\webapps\ProjetoNovoWeb-1.0.0.war

echo Iniciando Tomcat...
call D:\Programas\apache-tomcat-9.0.121\bin\startup.bat

echo.
echo Projeto atualizado!
pause