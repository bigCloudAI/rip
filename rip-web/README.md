
###node vue项目源码使用服务器docker编译发布过程
```
（1）下载编译对应的nodejs版本镜像，本项目使用v12.16。参照https://github.com/nodejs/docker-node/tree/5351774b970cd32b80fc0c47a8abff5ba155fccc
查找对应的Dockerfile，自行构建nodejs镜像。nodejs-zjk:v12.16
（2）编译、发布静态文件
编译：docker run --rm -v /home/s2iDataGit/rip/rip-web:/home nodejs-zjk:v12.16 cnpm install
发布静态文件：docker run --rm -v /home/s2iDataGit/rip/rip-web:/home nodejs-zjk:v12.16 npm run build
（3）文件转移
docker run --name mvtarget --rm -v /home/s2iDataGit/rip/rip-web/dist:/dist -v /home/s2iData/rip-webdist/:/tmp busybox-zjk:latest cp -rf /dist /tmp
docker run --name mvtarget --rm -v /home/s2iDataGit/rip/rip-web/dist/:/dist -v /home/s2iData/rip-webdist/dist/rip:/tmp busybox-zjk:latest cp -rf /dist/index.html /tmp
（4）启动运行
docker rm ripweb&&docker run -d -p 84:8080 --name ripweb -v /home/s2iData/rip-webdist/dist:/usr/local/tomcat/webapps tomcat


```
# rip-web

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
