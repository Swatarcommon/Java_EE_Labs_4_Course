FROM maven:3-jdk-11 AS builder
COPY . /lab_18
WORKDIR /lab_18
RUN mvn clean install

FROM tomcat:9.0.10-jre8
LABEL maintainer="swatarcommon@gmail.com"
COPY --from=builder /lab_18/target/laba18-1.0 /usr/local/tomcat/webapps/laba18_war
EXPOSE 8080
EXPOSE 3307
CMD ["catalina.sh", "run"]