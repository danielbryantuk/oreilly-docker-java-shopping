#!/bin/bash

cd shopfront
mvn clean install
cd ..
cd productcatalogue
mvn clean install
cd ..
cd stockmanager
mvn clean install
cd ..

