#!/bin/bash
[ -z "$1" ] && echo "Please enter your DockerHub username, example: sh build_all_and_publish_dockerhub.sh username" && exit 1
echo "dockerhub\`s username: $1"

cd shopfront
mvn clean install
if docker build -t $1/djshopfront . ; then
  docker push danielbryantuk/djshopfront
fi
cd ..

cd productcatalogue
mvn clean install
if docker build -t $1/djproductcatalogue . ; then
  docker push danielbryantuk/djproductcatalogue
fi
cd ..

cd stockmanager
mvn clean install
if docker build -t $1/djstockmanager . ; then
  docker push danielbryantuk/djstockmanager
fi
cd ..
