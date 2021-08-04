#!/usr/bin/env bash
. docker/utils.sh
mvn clean install -U

if commandExecutor  ". docker/getversion.sh";then
  search './target/' "bank-oauth-service.jar"
else
  ret 1
fi
