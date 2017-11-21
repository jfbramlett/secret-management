#!/bin/sh

docker run -it -p 8888:8888 -v ./config:/config hyness/spring-cloud-config-server