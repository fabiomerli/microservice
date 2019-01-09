#/bin/bash

docker container stop $(docker container ls -a -q) 
docker container rm $(docker container ls -a -q)  
echo "Stopped and Removed all containers -> DONE"
docker image rm eureka
docker image rm forexmicroservice
docker image rm currencyconversionmicroservice
echo "Remove all Images -> DONE"
docker build -t eureka ./EurekaNamingService/
docker build -t forexmicroservice ./ForexControllerMicroService/
docker build -t currencyconversionmicroservice ./CurrencyConversionMicroService/
echo "Build all image -> DONE"
#docker run -d -p 8761:8761 --network="microservicenetwork" --name eureka eureka
#docker run -d -p 4000:80 --network="microservicenetwork" --name forex forexmicroservice
#docker run -d -p 3000:80 --network="microservicenetwork" --name currency currencyconversionmicroservice

