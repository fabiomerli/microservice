#!/bin/bash

docker container stop $(docker container ls -a -q) 
docker container rm $(docker container ls -a -q)  
echo "Stopped and Removed all containers -> DONE"
docker image rm eureka
docker image rm forexmicroservice
docker image rm currencyconversionmicroservice
echo "Remove all Images -> DONE"
docker build -t fabiomerli/microservice:eureka_v_1.0.0 ./EurekaNamingService/
docker build -t fabiomerli/microservice:forexmicroservice_v_1.0.0 ./ForexControllerMicroService/
docker build -t fabiomerli/microservice:currencyconversionmicroservice_v_1.0.0 ./CurrencyConversionMicroService/
echo "Build all image -> DONE"

if [ -z $1 ]
  then
    echo "No argument supplied - DONE!"
elif [ $1 = "--tag" ];then
	docker push fabiomerli/microservice:eureka_v_1.0.0
	docker push fabiomerli/microservice:forexmicroservice_v_1.0.0
	docker push fabiomerli/microservice:currencyconversionmicroservice_v_1.0.0
fi

#docker run -d -p 8761:8761 --network=microservicenetwork --name eureka fabiomerli/microservice:eureka_v_1.0.0
#docker run -d -p 4000:80 --network=microservicenetwork --name forex fabiomerli/microservice:forexmicroservice_v_1.0.0
#docker run -d -p 3000:80 --network=microservicenetwork --name currency fabiomerli/microservice:currencyconversionmicroservice_v_1.0.0

