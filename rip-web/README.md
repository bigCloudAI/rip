
###node vue��ĿԴ��ʹ�÷�����docker���뷢������
```
��1�����ر����Ӧ��nodejs�汾���񣬱���Ŀʹ��v12.16������https://github.com/nodejs/docker-node/tree/5351774b970cd32b80fc0c47a8abff5ba155fccc
���Ҷ�Ӧ��Dockerfile�����й���nodejs����nodejs-zjk:v12.16
��2�����롢������̬�ļ�
���룺docker run --rm -v /home/s2iDataGit/rip/rip-web:/home nodejs-zjk:v12.16 cnpm install
������̬�ļ���docker run --rm -v /home/s2iDataGit/rip/rip-web:/home nodejs-zjk:v12.16 npm run build
��3���ļ�ת��
docker run --name mvtarget --rm -v /home/s2iDataGit/rip/rip-web/dist:/dist -v /home/s2iData/rip-webdist/:/tmp busybox-zjk:latest cp -rf /dist /tmp
docker run --name mvtarget --rm -v /home/s2iDataGit/rip/rip-web/dist/:/dist -v /home/s2iData/rip-webdist/dist/rip:/tmp busybox-zjk:latest cp -rf /dist/index.html /tmp
��4����������
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
