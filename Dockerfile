FROM openjdk:11

EXPOSE 9090

RUN mkdir ./app

COPY ./currencyChecker-1.0.0.jar ./app

CMD java -jar ./app/currencyChecker-1.0.0.jar