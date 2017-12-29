#!/usr/bin/env bash
#线上的打包方式
mvn package -Dmaven.test.skip=true -Ponline
