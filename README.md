# fist
基于SpringBoot+GRPC的文件实时同步工具

## 快速开始
* 在application.yaml文件进行相关配置\(例如文件目录、账户密码、主机端口等\)
* mvn打包生成jar包，如fist.jar
* server端: java -jar fist.jar -m server
* client端: java -jar fist.jar -m client \[-i\] \(-i表示需要初始化，即将客户端整体往服务端同步一次\)

## 配置说明
* 命令行参数
```
-i,--initialize   whether need initialize
-m,--mode <arg>   run mode with server or client
```
* 配置文件
```
fist:
  server:
    # 服务端根目录、host、port
    root: xxxx
    host: xxxx
    port: xxxx
  client:
    # 客户端根目录
    root: xxxx
  ignores:
    # 后缀名忽略(比如文件以.iml结尾)
    suffixList:
      - .iml
      - .iws
      - .ipr
    # 前缀名忽略(比如文件或文件夹以.开头)
    prefixList:
      - .
    # 名称忽略(比如文件夹或文件名为target)
    nameList:
      - target
```
