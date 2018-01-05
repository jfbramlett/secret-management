-- Attach to docker to add the admin user

docker exec -it vaultdb mongo admin

-- Now in the admin add the admin user
db.createUser({ user: 'mongo', pwd: 'mongopwd', roles: [ { role: "userAdminAnyDatabase", db: "admin" }, {role: "readWriteAnyDatabase", db: "admin"}, {role: "dbAdminAnyDatabase", db: "admin"} ] });

-- switch users
db.auth("mongo", "mongopwd")

-- create our database
use vault-sample

-- create an admin user for this database
db.createUser({user: "vaultSampleAdmin", pwd: "password", roles: ["readWrite", "dbOwner"]})

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
export VAULT_ADDR=http://127.0.0.2:8200 (this needs to be the ip address for the vault)

-- mount database plugin
vault mount database

-- configure our mongodb plugin
-- use the use account that can administer our vault-sample database
vault write database/config/mongodb-vault-sample plugin_name=mongodb-database-plugin allowed_roles="vs-user" connection_url="mongodb://vaultSampleAdmin:password@172.17.0.3:27017/vault-sample"

-- now define our role
vault write database/roles/vs-user db_name=mongodb-vault-sample creation_statements='{ "db": "vault-sample", "roles": [{ "role": "readWrite" }] }' default_ttl="1h" max_ttl="24h"


-- generate a new account by hand
vault read database/creds/vs-user

