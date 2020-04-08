FROM daocloud.io/library/java:openjdk-8-jre-alpine
 # 安装核心程序
WORKDIR /usr/local/lib
ADD rip.jar /usr/local/lib/
CMD java -jar /usr/local/lib/rip.jar
EXPOSE 8080

docker run -d -p 8090:8090 -v /home/s2iData/rip-webdist/dist/:/home  daocloud.io/library/java:openjdk-8-jre-alpine java -jar /home/rip-backend.jar