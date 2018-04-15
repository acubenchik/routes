FROM anapsix/alpine-java

ADD target/eureka-server-1.5.9.RELEASE.jar eureka.jar
ADD entrypoint.sh /entrypoint.sh

EXPOSE 8010

ENTRYPOINT ["/entrypoint.sh"]
