# SimpleAIDLDemo
A Simple Demo for Learning Android AIDL

1. client  和  server  包名不需要保持一致 （否则二者不能同时安装）--> 差点被某些文章误导

2. cient 在连接 server 端时候，server app的包名一定要写对，否则无法隐式启动server的service 

3.server 端注册的service 如果允许让其他进程来访问，需要设置 android:export = true (service 包含intent-filter的时候，export 默认也为true)

4.client 和 server 工程包路径可以不相同，但是client端的aidl文件所在的包路径是要和server端aidl文件保持一致的！可以直接通过将server端aidl整个文件夹拷贝的方式给client端集成

5.client 绑定service时，setPackage 包名应该为server端apk包名（build.gradle文件中applicationId后面声明的包名）(当AndroidManifest.xml文件中声明的包名和build.gradle中声明的包名不一致时, 最终apk包名会以build.gradle文件中声明的为准.反解开apk后, AndroidManifest.xml文件中的package也将会被替换, 和build.gradle文件中声明的保持一致)

