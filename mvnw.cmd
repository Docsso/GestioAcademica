@ECHO OFF
SETLOCAL

SET "BASE_DIR=%~dp0"
SET "WRAPPER_JAR=%BASE_DIR%\.mvn\wrapper\maven-wrapper.jar"
SET "WRAPPER_PROPERTIES=%BASE_DIR%\.mvn\wrapper\maven-wrapper.properties"

:: Leer la URL del wrapper
FOR /F "tokens=2* delims==" %%A IN ('findstr /R "^wrapperUrl=" "%WRAPPER_PROPERTIES%"') DO SET "WRAPPER_URL=%%B"

IF NOT EXIST "%WRAPPER_JAR%" (
  ECHO Descargando Maven Wrapper JAR desde: %WRAPPER_URL%
  "%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -ExecutionPolicy Bypass -Command ^
    "Invoke-WebRequest -UseBasicParsing '%WRAPPER_URL%' -OutFile '%WRAPPER_JAR%'"
  IF NOT EXIST "%WRAPPER_JAR%" (
    ECHO [ERROR] No se pudo descargar maven-wrapper.jar
    EXIT /B 1
  )
)

IF NOT "%JAVA_HOME%"=="" (
  SET "JAVA_EXE=%JAVA_HOME%\bin\java.exe"
) ELSE (
  SET "JAVA_EXE=java"
)

"%JAVA_EXE%" -cp "%WRAPPER_JAR%" org.apache.maven.wrapper.MavenWrapperMain %*
EXIT /B %ERRORLEVEL%
