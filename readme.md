## 后端技术
技术名称|作用|官网
---|---|---
SpringCloud|微服务架构|[https://spring.io/projects/spring-cloud](https://spring.io/projects/spring-cloud)
SpringBoot|Spring 快速配置脚手架|[https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
Swagger|api文档生成工具|[https://swagger.io/tools/swagger-ui/](https://swagger.io/tools/swagger-ui/)
Apollo|配置中心|[https://ctripcorp.github.io/apollo/#/zh/README](https://ctripcorp.github.io/apollo/#/zh/README)
Mybatis|持久层框架|[https://mybatis.org/mybatis-3/zh/index.html](https://mybatis.org/mybatis-3/zh/index.html)
Docker|服务容器|[https://docs.docker.com](https://docs.docker.com)
### Docker
#### 概述
Docker 为什么出现？  
项目带上环境安装打包  
java -- jar(环境)-- 打包项目带上环境(带上环境) --(Docker镜像：商店)-- 下载发布的镜像-- 直接运行即可  
JRE --多个应用(端口冲突)  
隔离： Docker 核心思想,打包装箱,每个箱子是相互隔离  
Docker通过隔离机制可以将服务利用到机制  
本质：所有的技术都是应为出现了一些 问题需要我们去解决,才去学习  
虚拟机缺点  
资源占用多  
冗余步骤多  
启动速度慢  
Docker和虚拟技术的不同  
1.传统虚拟机寻觅出一条硬件,运行一个完成的操作系统,然后在这个系统上安装和运行软件  
2.容器内的应用直接运行在宿主机的内容,容器是没有自己的内核,也没有细腻我们的硬件,所以轻便了  
3.每个容器是相互隔离,每个容器内都有一个属于自己的文件系统,互不影响  
DevOps(开发、运维)  
更快速地开发和部署  
传统：一堆帮助文档,安装程序  
Docker: 打包镜像测试,一键运行  
更便捷的升级和扩容  
使用了Docker之后,我们部署应用和搭积木一样  
更简单的系统运维  
在容器之后,我们的开发,测试环境都是高度一阵子  
更高效的计算资源利用  
Docker是内核级别的虚拟化,可以在一个物理机上可以运行很多的容器  
####Docker 安装  
#####基本组成  
镜像(Image)：  
docker镜像就好比一个模板,可以通过这个模板来创建容器服务, tomcat镜像===>run==>tomcat容器  
容器(container):  
Docker利用容器技术,独立运行一个或者多个应用,用过镜像来创建启动,停止,运行  
目前就可以把这个容器理解为就是一个建议的linux系统  
仓库(repoitory)：  
仓库就是存放镜像的地方  
仓库分为共有仓库和私有仓库  
DockerHub (国外镜像)  

#####Ubuntu安装步骤：		
1.卸载旧的Docker：   
```shell
sudo apt-get remove docker docker-engine docker.io containerd runc
```
2.升级apt-get: 
```shell
apt-get update
```

3.升级软件: 
```shell
sudo apt-get install \
apt-transport-https \
ca-certificates \
curl \
gnupg \
lsb-release
```
4.配置阿里云镜像 
```shell
curl -fsSL http://mirrors.aliyun.com/docker-ce/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
```
5.设置稳定镜像  
```shell
echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
$(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```
6.安装docker引擎：
```shell
apt-get update
apt-get install docker-ce docker-ce-cli containerd.io
```
7.检验docker是否安装成功 ：
```shell
docker version
```
8.启动Docker: 
```shell
service docker start
```
9.测试安装是否成功：
#####CentOs：
1.卸载旧的Docker：
```shell
yum remove docker \
docker-client \
docker-client-latest \
docker-common \
docker-latest \
docker-latest-logrotate \
docker-logrotate \
docker-engine
```
2.安装yum-utils：
```shell
yum install -y yum-utils
```
3.配置源
默认源
```shell
sudo yum-config-manager \
--add-repo \
https://download.docker.com/linux/centos/docker-ce.repo
```
阿里源：
```shell
sudo yum-config-manager \
--add-repo \
http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
```
4.安装docker: 
```shell
sudo yum install docker-ce docker-ce-cli containerd.io
```
5.启动Docker：
```shell
systemctl start docker
```
6.测试docker: 
```shell
docker run hello-world
```

####Docker 命令
#####帮助命令：
```shell
docker version	#显示docker版本信息
docker info 	#显示docker的系统信息
docker help 	#docker帮助
```
#####镜像命令
```shell
docker images 	#查看本地docker镜像
docker search	#搜索
docker pull		#下载 镜像名：tag
docker rmi		#删除镜像  docker rmi -f ${docker image aq} 删除所有偶的
```
#####容器命令
说明：我们有了镜像才能创建容器, linux, 下载一个centOS	
```shell
docker run [可选参数] image 启动
#参数说明
--name="XXX" 	容器名字
-d 				后台方式运行
-it				使用交互方式运行,进入容器内查看内容
-p				指定容器端口(ip:主机端口:容器端口)
exit 			停止并退出容器(在执行中执行)
Ctrl+P+Q		不停止并退出容器
docker ps			列出正在运行的容器
-a				显示所有的容器(包括历史)
-n=?			显示最近创建的容器
-q				显示运行容器id
docker rm			删除指定容器(删除运行的容器 后面加上 -f)
docker rm -f ${docker ps -aq} 删除所有容器
docker ps -a -q |xargs docker rm -f	删除所有容器
docker start 		启动容器
docker stop			停止容器
docker restart 		重启容器
```
#####常用命令
```shell
docker logs 		#查看日志命令
docker top 			#查看进程
docker inspect		#查看镜像的元数据
docker exec -it 容器id /bin/bash #进入容器开启新的终端,可以操作
docker attch 容器id /bin/bash #进入容器正在执行的终端
docker cp 容器id:容器路径 主机路径  #复制文件到容器
docker stop $(docker ps -aq) #停止所有容器
docker stop $(docker ps -aqf ancestor=dfd0427ba95f) #停止指定镜像的容器
ancestor #后面的参数
image
image:tag
image:tag@digest
short-id
full-id
docker rm $(docker ps -aqf ancestor=dfd0427ba95f) #删除指定镜像的容器
docker rm $(docker ps -aqf ancestor=7b19f37e42a0)
```
#####操作命令  
Docker 镜像  
```shell
docker commit
```
####容器数据卷  
容器数据共享技术,将容器数据挂载再linux,实现容器的持久化和同步操作  
使用方法 -v 主机路径:容器目录：权限(ro:只读, rw：可读可写)  
具名挂载和匿名挂载  
```shell
docker volume ls #查看所有的卷
```

匿名挂载没有指定容器外路径
--volums-from 继承其他容器的数据卷
DockerFile
构建docker镜像的构建文件
```shell
docker build -f dockerfile[文件名] -t centos01 .
docker build -f dockerfile -t centos01 .
```
####DockerFile基础：  
1.每个关键字都必须是大写  
2.执行顺序从上到下  
3.#表示注释  
4.每一个指令都会创建提交一个新的镜像层,并提交  
dockerfile:构建文件,定义了一切步骤,源代码  
dockerimages:通过Dockerfile构建生成镜像最终发布运行的产品。  
dockercontainer:镜像运行起来的服务  
#####指令：  
```text
FROM：指定基础镜像
MAINTAINER:镜像作者 姓名+邮箱
RUN:镜像运行的命令
ADD:步骤(镜像)
WORKDIR:镜像的工作目录
VOLUME:挂载目录
EXPOSE:暴露端口
CMD:指定这个容器启动时要运行的命令,只有最后一个会生效,可被替代
ENTRYPONT:指定这个容器启动时要运行的命令,可追加命令
ONBUILD:当构建一个被继承DockerFile这个时候回运行ONBUILD指令
COPY:类似ADD,将我们的文件拷贝到镜像中
ENV:构建是设置的环境变量
```
#####提交阿里云
```shell
docker login --username=coolzhongliang@126.com registry.cn-hangzhou.aliyuncs.com
docker tag 18e039ec614e registry.cn-hangzhou.aliyuncs.com/zldoc/zhongliang:1.0.0
docker push registry.cn-hangzhou.aliyuncs.com/zldoc/zhongliang:1.0.0
```
####Docker 网络资源
```shell
docker network ls
docker network create --driver bridge --subnet 192.168.0.0/16 --gateway 192.168.0.1 mynet
```
### Docker compoes
1.定义多个容器  
2.批量容器编排  
重要概念  
1.服务service,容器,应用,(web,redis,mysql...)  
2.项目project,一键关联的容器  
安装  
1.下载：
```shell
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
```
2.授权：
```shell
sudo chmod +x /usr/local/bin/docker-compose
```
3.如果安装失败,创建软连接：
```shell
sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
```

