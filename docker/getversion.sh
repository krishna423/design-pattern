#!/usr/bin/env bash

. docker/utils.sh
PROJECT_DIR="$( pwd )"

if search $PROJECT_DIR/design-pattern/target/classes/META-INF/ build-info.properties;then
  version=$(cat $PROJECT_DIR/design-pattern/target/classes/META-INF/build-info.properties | grep build.version | cut -d'=' -f2)
else
  return 1
fi
