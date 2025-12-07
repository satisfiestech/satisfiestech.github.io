@echo off
REM Load environment variables from .env file and run Spring Boot

REM Read .env file and set environment variables
for /f "tokens=1,2 delims==" %%a in (.env) do (
    if not "%%a"=="" if not "%%a:~0,1%"=="#" (
        set %%a=%%b
    )
)

REM Run Spring Boot application
mvn spring-boot:run
