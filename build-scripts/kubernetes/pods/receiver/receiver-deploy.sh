#!/bin/bash

CONSUMER_DEPLOYMENT_NAME="rabbit-receiver"
CURRENT_DIR=$(pwd)

#Go to project root dir
cd ../../../../learn-rabbitmq-receiver || exit

echo "Building jar file"
#Build producer jar via maven
mvn clean package -DskipTests

echo "Creating docker image"
eval "$(minikube docker-env)"
# Create docker image
docker build -t $CONSUMER_DEPLOYMENT_NAME:0.1 .

cd "$CURRENT_DIR" || exit

echo "Deploying docker image to k8s"
# Create kubernetes deployment
kubectl apply -f ./deployment.yaml
