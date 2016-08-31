@echo off
cd %~dp0
cd..
echo %cd%
call mvn compile