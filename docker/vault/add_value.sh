#!/bin/bash

curl -H "X-Vault-Token: abc123" -H "Content-Type: application/json" -X POST -d '{"secret.management.value" : "vaultsecret"}' http://localhost:8200/v1/secret/sample