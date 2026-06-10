#!/usr/bin/env bash
set -euo pipefail

MAVEN_VERSION="${1:-3.9.16}"
ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
TOOLS_DIR="$ROOT_DIR/.tools"
MAVEN_DIR="$TOOLS_DIR/apache-maven-$MAVEN_VERSION"
MAVEN_TGZ="$TOOLS_DIR/apache-maven-$MAVEN_VERSION-bin.tar.gz"
MAVEN_URL="https://dlcdn.apache.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz"

mkdir -p "$TOOLS_DIR"

if [ ! -x "$MAVEN_DIR/bin/mvn" ]; then
  if [ ! -f "$MAVEN_TGZ" ]; then
    echo "Downloading Apache Maven $MAVEN_VERSION..."
    curl -fsSL "$MAVEN_URL" -o "$MAVEN_TGZ"
  fi

  echo "Extracting Apache Maven $MAVEN_VERSION..."
  tar -xzf "$MAVEN_TGZ" -C "$TOOLS_DIR"
fi

"$MAVEN_DIR/bin/mvn" -q test
