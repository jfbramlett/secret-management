# How to run the app

# 1. Run The Vault
To start the vault execute:
    **_docker/vault/start_vault.sh_**

Then add our config value to the vault:
    **_docker/vault/add_value.sh_**
    
Check the IP of the vault by executing:
    **_docker inspect <container id> | grep '"IPAddress"' | head -n 1_**
    
(the container id can be found by running docker ps)

Update the vault IP in docker/spring-config/config/application.yml.

# 2. Start Spring Cloud Config Server
To start the spring cloud config server execute:
    **_docker/spring-config/start_spring-config.sh_**
    
# 3. Start the App
Start the Spring Boot app

# 4. Test the App
Open a browser and navigate to: 
    **_http://localhost:8090/sampleserver/v1/secret_**
    
You should see a response like:

**{
    secret: "vaultsecret"
}**