# SimpleAIDLDemo
A Simple Demo for Learning Android AIDL

1. client  和  server  包名不需要保持一致 （否则二者不能同时安装）--> 差点被某些文章误导

2. cient 在连接 server 端时候，server app的包名一定要写对，否则无法隐式启动server的service 

3.server 端注册的service 如果允许让其他进程来访问，需要设置 android:export = true (service 包含intent-filter的时候，export 默认也为true)

4.client 和 server 工程包路径可以不相同，但是client端的aidl文件所在的包路径是要和server端aidl文件保持一致的！可以直接通过将server端aidl整个文件夹拷贝的方式给client端集成

5.client 绑定service时，setPackage 包名应该为aidl文件包名（当aidl文件的包名和项目包名不一致时需要注意的点！）
