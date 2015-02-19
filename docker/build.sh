#! /bin/bash -e

rm -fr build
mkdir build
cp ../build/libs/restful-chat-service-0.1.0.jar build

docker build -t chat_srv .