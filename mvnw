#!/bin/sh
BASE_DIR="$(cd "$(dirname "$0")"; pwd -P)"
WRAPPER_JAR="$BASE_DIR/.mvn/wrapper/maven-wrapper.jar"
PROPERTIES="$BASE_DIR/.mvn/wrapper/maven-wrapper.properties"
DOWNLOAD_URL=$(grep -E "^wrapperUrl=" "$PROPERTIES" | cut -d'=' -f2-)
if [ ! -f "$WRAPPER_JAR" ]; then
  echo "Downloading Maven Wrapper JAR from: $DOWNLOAD_URL"
  mkdir -p "$(dirname "$WRAPPER_JAR")"
  if command -v curl >/dev/null 2>&1; then
    curl -fsSL "$DOWNLOAD_URL" -o "$WRAPPER_JAR"
  elif command -v wget >/dev/null 2>&1; then
    wget -q "$DOWNLOAD_URL" -O "$WRAPPER_JAR"
  else
    echo "Please install curl or wget."
    exit 1
  fi
fi
exec "${JAVA_HOME:-java}" -jar "$WRAPPER_JAR" "$@"
