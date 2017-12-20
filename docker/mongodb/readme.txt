-- Attach to docker to add the admin user

docker exec -it vaultdb mongo admin

-- Now in the admin add the admin user
db.createUser({ user: 'mongo', pwd: 'mongopwd', roles: [ { role: "userAdminAnyDatabase", db: "admin" }, {role: "readWriteAnyDatabase", db: "admin"}, {role: "dbAdminAnyDatabase", db: "admin"} ] });

-- switch users
db.auth("mongo", "mongopwd")

-- create our database
use vault-sample

-- add a collection
db.albums.save({title:"2112", artist:"Rush", year: 1976})

-- find our ip address (container id is found by doing docker ps)
docker inspect <container id> | grep '"IPAddress"' | head -n 1

--
-- configure vault
--

-- connect to vault
docker exec -i -t <container id> /bin/ash

-- export the keys needed to config the vault (done in shell)
export VAULT_TOKEN=abc123
export VAULT_ADDR=http://127.0.0.1:8200

-- mount database plugin
vault mount database

-- configure our mongodb plugin
vault write database/config/mongodb plugin_name=mongodb-database-plugin allowed_roles="readonly" connection_url="mongodb://mongo:mongopwd@172.17.0.3:27017/admin"

-- now define our role
vault write database/roles/readonly db_name=mongodb creation_statements='{ "db": "admin", "roles": [{ "role": "readWrite" }, {"role": "read", "db": "vault-sample"}] }' default_ttl="1h" max_ttl="24h"
