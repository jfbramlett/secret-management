Start the vault first

Check the vault ip using:

docker inspect <container id> | grep '"IPAddress"' | head -n 1

and update config/application.yml to set this value