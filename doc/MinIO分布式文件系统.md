# MinIO分布式文件系统

## 环境搭建

基础环境要求

- centOS 7 操作系统
- Docker

> 1.拉取Minio的docker镜像

```shell
docker pull minio/minio
```

![image-20230119093535810](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301190935868.png)

> 2.创建并运行容器

```shell
docker run  -d  \
--name minio-server \
-p 9000:9000  \
-p 9090:9090  \
-e "MINIO_ROOT_USER=minioadmin" \
-e "MINIO_ROOT_PASSWORD=minioadmin" \
-v /home/minio/data:/data \
-v /home/minio/conf:/etc/config.env \
minio/minio server /data \
--console-address ":9090"
```

![image-20230119095558844](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301190955878.png)

> 3.测试访问

访问 `ip:9090`测试进入minio的控制台面板

初始密码为上文指令中设置的

- 用户名 `minioadmin`
- 密码 `minioadmin`

![image-20230119095659553](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301190956580.png)

![image-20230119095836878](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301190958909.png)

## 使用

概念说明

- Bucket：存储桶，是minio存储的顶层目录，一般情况下一个Bucket桶存储一个项目中的文件，在Bucket中可以创建子级目录用于区分文件类型。

> 创建一个Bucket存储桶

![image-20230119100556866](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301191005895.png)

![image-20230119100733682](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301191007721.png)

![image-20230119100810740](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301191008771.png)

> 功能

![image-20230119100947126](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301191009157.png)

> 测试文件上传和查看

![image-20230119101044188](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301191010220.png)

**在Linux服务器目录下查看文件，前往挂载目录`/home/minio/data`下查看，可以看到创建的桶文件夹`test`，进入后可以看到刚刚上传的图片文件**

![image-20230119101141010](https://pic-go.oss-cn-shanghai.aliyuncs.com/typora-img/202301191011054.png)