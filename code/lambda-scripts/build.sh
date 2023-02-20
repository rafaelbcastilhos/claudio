multi-file-swagger index.yml > index.json

cd ../lambda-server/
mvn clean package -q

cd ../lambda-client/
mvn clean package -q