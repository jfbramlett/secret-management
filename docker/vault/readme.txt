-- Check Status
docker exec <container id> vault status -address="http://127.0.0.1:8200"

-- Attach to shell
docker exec -i -t <container id> /bin/ash

once in shell:
export VAULT_TOKEN=abc123
export VAULT_ADDR=http://127.0.0.1:8200

then can execute vault cli

-- view keys
curl -H "X-Vault-Token: abc123" -X GET http://127.0.0.1:8200/v1/secret/?list=true


-- To Get IP of vault (need this to configure spring cloud server):
docker inspect <container id> | grep '"IPAddress"' | head -n 1
