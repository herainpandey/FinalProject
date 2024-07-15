FROM bellsoft/liberica-openjre-alpine:17.0.8

RUN apk add curl jq

#Create workspace
WORKDIR /home/selenium-docker

#Copy docker-resources
ADD target/docker-resources ./

ADD runner.sh                 runner.sh

ENTRYPOINT sh runner.sh
