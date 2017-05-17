#!/usr/bin/env bash
cd /opt/JavaPro/trumpet
echo "mvn package..."
mvn clean compile package -DskipTests
echo "scp trumpet.jar..."
scp target/trumpet.jar root@helloxw.com:/opt
echo "connect helloxw.com..."
cd src/main/resources
./ssh-service.sh
echo "deploy complete..."