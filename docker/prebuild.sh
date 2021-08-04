#!/usr/bin/env bash
. docker/utils.sh
search './docker' 'Dockerfile' && search . 'pom.xml'
