#!/bin/bash

cd shopfront
mvn clean install
if docker build -t danielbryantuk/djshopfront . ; then
  docker push danielbryantuk/djshopfront
fi
cd ..

cd productcatalogue
mvn clean install
if docker build -t danielbryantuk/djproductcatalogue . ; then
  docker push danielbryantuk/djproductcatalogue
fi
cd ..

cd stockmanager
mvn clean install
if docker build -t danielbryantuk/djstockmanager . ; then
  docker push danielbryantuk/djstockmanager
fi
cd ..
