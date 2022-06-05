#!/bin/bash

PRODUCER_DEPLOYMENT_NAME="rabbit-producer"
IMAGE_VERSION=0.1
CURRENT_DIR=$(pwd)

#Go to project root dir
cd ../../../..

echo "Building jar file"
#Build producer jar via maven
mvn clean package -DskipTests

echo "Creating docker image"
eval "$(minikube docker-env)"
# Create docker image
docker build -t ${PRODUCER_DEPLOYMENT_NAME}:${IMAGE_VERSION} .

cd "$CURRENT_DIR" || exit

echo "Deploying docker image to k8s"
# Create kubernetes deployment
kubectl apply -f ./deployment.yaml

kubectl apply -f ./service.yaml
