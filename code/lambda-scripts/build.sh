multi-file-swagger api.yml > api.json

cd ../lambda-server/
mvn clean package -q

cd ../lambda-client/
mvn clean package -q