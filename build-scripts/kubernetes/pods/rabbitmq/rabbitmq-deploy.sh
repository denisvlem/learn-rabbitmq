#!/bin/bash

eval "$(minikube docker-env)"

kubectl apply -f ./deployment.yaml
kubectl apply -f ./service.yaml
