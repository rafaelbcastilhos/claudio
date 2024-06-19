## Spring for Client and Server
### Build and push image to docker.io:
```
sudo mvn clean package dockerfile:push
```

Docker image:
- https://hub.docker.com/repository/docker/rafaelbcastilhos/ecs

In EC2 instance, you need to copy .jar file to virtual machine, using scp:
```
scp -i /path/to/your-key-pair.pem /path/to/your-file.jar ec2-user@your-ec2-instance-public-dns:/desired/path/on/ec2
```

After that, you need to access instance through ssh and run application using nohup:
```
nohup java -jar /path/to/your-file.jar > output.log 2>&1 &
```
