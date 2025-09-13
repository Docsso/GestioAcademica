@ECHO OFF
SETLOCAL

REM === Rutas base ===
SET "BASE_DIR=%~dp0"
SET "WRAPPER_DIR=%BASE_DIR%\.mvn\wrapper"
SET "WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar"
SET "WRAPPER_PROPERTIES=%WRAPPER_DIR%\maven-wrapper.properties"

REM === Fallback si no se puede leer del .properties ===
SET "WRAPPER_URL_FALLBACK=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.2/maven-wrapper-3.3.2.jar"
SET "WRAPPER_URL="

REM === Leer wrapperUrl del .properties (sin dependencias externas)
IF EXIST "%WRAPPER_PROPERTIES%" (
  FOR /F "usebackq eol=# tokens=1,2 delims==" %%A IN ("%WRAPPER_PROPERTIES%") DO (
    IF /I "%%~A"=="wrapperUrl" SET "WRAPPER_URL=%%~B"
  )
)
IF NOT DEFINED WRAPPER_URL SET "WRAPPER_URL=%WRAPPER_URL_FALLBACK%"

REM === Descargar el wrapper si falta (primero curl, luego PowerShell)
IF NOT EXIST "%WRAPPER_JAR%" (
  ECHO Descargando Maven Wrapper JAR desde: %WRAPPER_URL%
  IF EXIST "%SystemRoot%\System32\curl.exe" (
    "%SystemRoot%\System32\curl.exe" -L -o "%WRAPPER_JAR%" "%WRAPPER_URL%"
  ) ELSE (
    "%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -ExecutionPolicy Bypass -Command ^
      "Invoke-WebRequest -UseBasicParsing '%WRAPPER_URL%' -OutFile '%WRAPPER_JAR%'"
  )
  IF NOT EXIST "%WRAPPER_JAR%" (
    ECHO [ERROR] No se pudo descargar "%WRAPPER_JAR%".
    EXIT /B 1
  )
)

REM === Resolver java
SET "JAVA_EXE="
IF NOT "%JAVA_HOME%"=="" IF EXIST "%JAVA_HOME%\bin\java.exe" SET "JAVA_EXE=%JAVA_HOME%\bin\java.exe"
IF "%JAVA_EXE%"=="" FOR /F "usebackq delims=" %%J IN (`where java 2^>NUL`) DO (
  IF EXIST "%%~fJ" SET "JAVA_EXE=%%~fJ"
)
IF "%JAVA_EXE%"=="" (
  ECHO [ERROR] No se encontro java. Configura JAVA_HOME o agrega java al PATH.
  EXIT /B 1
)

REM === Evitar warning de multiModuleProjectDirectory
SET "MAVEN_PROJECTBASEDIR=%BASE_DIR%"

REM === Ejecutar el wrapper
"%JAVA_EXE%" -Dmaven.multiModuleProjectDirectory="%MAVEN_PROJECTBASEDIR%" -classpath "%WRAPPER_JAR%" org.apache.maven.wrapper.MavenWrapperMain %*
EXIT /B %ERRORLEVEL%
