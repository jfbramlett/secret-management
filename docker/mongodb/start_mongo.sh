#!/bin/sh

docker run --name vaultdb -p 27017:27017 -d mongo --auth