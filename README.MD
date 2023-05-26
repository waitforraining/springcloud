# spingcloud大作业

## 关于项目 

本项目是基于 SpringCloud 生态实现的库存管理项目。 <br/>


## 项目结构

* 【nacos】服务注册中心
* 【api-gateway】服务网关
* 【order-server】订单服务，查询订单
* 【user-server】用户服务：查询用户
* 【chat-server】机器人服务

## 基础设施搭建方法

#### 版本:

JDK：`1.8`

nacos：2.2.2

### 运行方法：

#### 1、新建数据库

在navicat中运行order.sql和user.sql语句，并在user服务，order服务文件夹中修改数据库配置

#### 2、打开Nacos

1. 简介
    - Nacos 相当于注册中心+配置中心的组合 ===> Nacos=Eureka+Config+Bus
    - [官网](https://nacos.io/zh-cn/)

2. 安装
   [参考官网](https://nacos.io/zh-cn/docs/quick-start.html)

#### 3、依次打开gateway服务，user服务，order服务，chat服务

