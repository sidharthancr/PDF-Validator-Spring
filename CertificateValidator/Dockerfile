FROM gradle:alpine as base-image
USER root
RUN mkdir -p /src/
WORKDIR /src
COPY . /src/
RUN ./mvn package

FROM openjdk:jre-alpine
RUN mkdir -p /usr/src/app/
WORKDIR /usr/src/app
RUN env
COPY --from=base-image src/build/libs/postclosing-loanheaderservice-0.1.0.jar /usr/src/app
EXPOSE 8145
ENTRYPOINT java -jar postclosing-loanheaderservice-0.1.0.jar