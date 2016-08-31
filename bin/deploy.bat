@echo off
cd %~dp0
cd..
echo %cd%
call mvn tomcat7:deploy
cmd