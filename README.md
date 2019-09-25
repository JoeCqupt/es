# es (easy-start)
java web 项目开发示例项目

## finished

* ssm框架
    * mybatis example的使用方法：每当数据库变更时候，需要运行如下插件命令，重新生成xxDO、xxExample、xxMapper类。
    
        ![](https://img2018.cnblogs.com/blog/1114580/201904/1114580-20190403202044838-1610004059.png)

* 统一错误码处理
* Validation使用
* profiles 多环境 
    
    * 打包请使用命令：mvn clean install -Dmaven.test.skip=true -Pdev (测试环境) 默认打包测试环境
    * mvn clean install -Dmaven.test.skip=true -Pgray (灰度环境)
    * mvn clean install -Dmaven.test.skip=true -Ponline (线上环境)

## todo

* travis-ci 关联findbugs、checkStyle、SourceMonitor
* test mock 的使用
* 分布式事务
* nginx config
* dubbo/Spring Cloud
* 缓存redis
* MQ(activeMQ/RocketMQ)
* 整合spring cloud 全家桶
* ci  发布脚本
* 网关
* 配置中心
* 注册中心
* 限流
* 压测
* 降级
* 故障演练
* 日志统一收集
* 调用链路追踪
* 数据库proxy
* 任务调度中心
* 发布系统
* 监控
* servicemesh
