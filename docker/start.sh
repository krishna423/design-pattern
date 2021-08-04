#!/usr/bin/env bash
. /apps/$PROJECTNAME/bin/jvm.sh

exec java -Dspring.profiles.active=${ENV_VARIABLE} $JAVA_OPTS -jar /apps/$PROJECTNAME/lib/${PROJECTNAME}.jar
