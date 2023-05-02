multi-file-swagger api.yml > api.json

cd ../lambda-client/
sudo mvn clean package -q

cd ../lambda-server/
sudo mvn clean package -q
