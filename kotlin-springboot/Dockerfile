FROM gradle:7.1-jdk11 as builder

WORKDIR /work
COPY . /work

RUN gradle build

### Use this command when config http proxy in gradle.properties file
# RUN gradle \
#     -Djdk.http.auth.tunneling.disabledSchemes="" \
#     -Djdk.http.auth.proxying.disabledSchemes="" \
#     build

FROM openjdk:11.0-jre-slim
LABEL maintainer="Artit Kiuwilai <first087@gmail.com>"

EXPOSE 8080
WORKDIR /app
CMD ["java", "-jar", "app.jar"]
COPY --from=builder /work/build/libs/app.jar /app/app.jar
