#!/usr/bin/env bash
. docker/utils.sh
mvn clean install -U
mvn deploy

if commandExecutor  ".
docker/getversion.sh";then
  search './target/' "design-pattern.jar"
else
  ret 1
fi
