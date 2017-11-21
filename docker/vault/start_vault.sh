#!/bin/sh

docker run -p 8200:8200 -e 'VAULT_DEV_ROOT_TOKEN_ID=abc123' -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:8200' vault server -dev