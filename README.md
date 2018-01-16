# How to run the app

## 1. Run The Vault
To start the vault execute:

    cd docker/vault

    ./start_vault.sh

Then add our config value to the vault:

    ./add_value.sh
    
Check the IP of the vault by executing:

    docker inspect <container id> | grep '"IPAddress"' | head -n 1
    
(the container id can be found by running docker ps)

Update the vault IP in docker/spring-config/config/application.yml.

## 2. Start the App
Start the Spring Boot app

## 3. Test the App
Open a browser and navigate to: 

    http://localhost:8090/sampleserver/v1/secret
    
You should see a response like:

    {secret: "vaultsecret"}
