@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  amazon-qldb-double-entry-sample-java startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and AMAZON_QLDB_DOUBLE_ENTRY_SAMPLE_JAVA_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\amazon-qldb-double-entry-sample-java-1.0.jar;%APP_HOME%\lib\dagger-2.2.jar;%APP_HOME%\lib\slf4j-simple-1.7.26.jar;%APP_HOME%\lib\jackson-dataformat-ion-2.10.0.pr1.jar;%APP_HOME%\lib\commons-lang3-3.1.jar;%APP_HOME%\lib\amazon-qldb-driver-java-1.0.2.jar;%APP_HOME%\lib\aws-java-sdk-qldb-1.11.628.jar;%APP_HOME%\lib\aws-java-sdk-iam-1.11.628.jar;%APP_HOME%\lib\aws-java-sdk-s3-1.11.628.jar;%APP_HOME%\lib\aws-java-sdk-sts-1.11.628.jar;%APP_HOME%\lib\aws-java-sdk-qldbsession-1.11.649.jar;%APP_HOME%\lib\aws-java-sdk-kms-1.11.628.jar;%APP_HOME%\lib\aws-java-sdk-core-1.11.649.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\slf4j-api-1.7.26.jar;%APP_HOME%\lib\ion-hash-java-1.0.0.jar;%APP_HOME%\lib\ion-java-1.4.0.jar;%APP_HOME%\lib\jmespath-java-1.11.649.jar;%APP_HOME%\lib\jackson-databind-2.10.0.pr1.jar;%APP_HOME%\lib\jackson-annotations-2.10.0.pr1.jar;%APP_HOME%\lib\jackson-dataformat-cbor-2.6.7.jar;%APP_HOME%\lib\jackson-core-2.10.0.pr1.jar;%APP_HOME%\lib\httpclient-4.5.9.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\ion-java-1.0.2.jar;%APP_HOME%\lib\joda-time-2.8.1.jar;%APP_HOME%\lib\httpcore-4.4.11.jar;%APP_HOME%\lib\commons-codec-1.11.jar

@rem Execute amazon-qldb-double-entry-sample-java
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %AMAZON_QLDB_DOUBLE_ENTRY_SAMPLE_JAVA_OPTS%  -classpath "%CLASSPATH%" software.amazon.qldb.example.tasks.null %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable AMAZON_QLDB_DOUBLE_ENTRY_SAMPLE_JAVA_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%AMAZON_QLDB_DOUBLE_ENTRY_SAMPLE_JAVA_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
