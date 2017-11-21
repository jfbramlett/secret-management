#!/bin/sh

docker run -it -p 8888:8888 -v /Users/jbramlet/git/secret-management/docker/spring-config/config:/config hyness/spring-cloud-config-server