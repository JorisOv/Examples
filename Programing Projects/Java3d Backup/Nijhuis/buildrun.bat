@echo off

REM THE BATCH FILE TAKES A PACKAGE AS ARGUMENT
REM FOR COMPILING AND STARTING opdracht1a TYPE buildrun opdracht1a
REM FOR COMPILING AND STARTING opdracht1b TYPE buildrun opdracht1b
REM
REM THE JAVA_HOME SHOULD BE SET IN DOS SHORT FILE NAMES.
REM THESE CAN BE FOUND BY USING DIR /X.

set JAVA_HOME=C:\progra~1\JDK1.3

if not exist .\classes mkdir classes

%JAVA_HOME%\bin\javac -d .\classes %1\*.java
%JAVA_HOME%\bin\java -cp .\classes %1.BodyWorld
