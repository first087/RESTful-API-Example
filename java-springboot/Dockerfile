FROM openjdk:8u131-jdk-alpine as builder

WORKDIR /work
COPY . /work

RUN sh gradlew build

### Use this command when config http proxy in gradle.properties file
# RUN sh gradlew \
#     -Djdk.http.auth.tunneling.disabledSchemes="" \
#     -Djdk.http.auth.proxying.disabledSchemes="" \
#     build

FROM openjdk:8u131-jre-alpine
LABEL maintainer="Artit Kiuwilai <first087@gmail.com>"

WORKDIR /app
COPY --from=builder /work/build/libs/app.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
