# boot-crm

#### 介绍
用于管理Maven+IDEA+SSM开发的BOOT客户管理系统。后台使用SSM框架，前台使用Bootstrap和jQuery以及JSP完成页面展示功能。此项目没有实现前后端异步交互更新。项目主要实现了两大功能模块：用户登录模块和客户管理模块，这两个模块的主要功能如下图所示：
![系统功能结构](https://images.gitee.com/uploads/images/2020/0407/154053_065cecb5_6533994.png "客户管理系统.png")

#### 软件架构
软件架构设计
项目结构可以划分为以下几个层次
- 持久对象层：该层由实体类组成
- 数据访问层：该层由DAO接口和MyBatis映射文件组成
- 业务逻辑层：该层由Service接口和实现类组成
- Web表现层：该层由SpringMVC中的Controller类和JSP页面组成

#### 项目开发以及运行环境
- 操作系统：Windows
- Web服务器：Tomcat
- Java开发包：JDK
- 开发工具：IDEA
- 项目构建工具：Maven
- 数据库：MySQL
- 浏览器：谷歌

#### 用户登录模块介绍
##### 用户登录过程中首先要验证用户和密码是否正确，如果正确，可以成功登录系统，系统自动跳转到页面；如果错误，则在登录页面给出错误提示信息
用户登录模块流程图：
![输入图片说明](https://images.gitee.com/uploads/images/2020/0410/180953_d7e275b9_6533994.png "用户登录流程图.png")
##### 模块中要添加登录验证，以防止让未登录的用户直接访问到客户管理页面
验证登录流程图：
![输入图片说明](https://images.gitee.com/uploads/images/2020/0410/205654_32cf9775_6533994.png "登录验证流程图.png") 

#### 客户管理模块
1. 查询客户
2. 添加客户
3. 修改客户
4. 删除客户

#### 客户信息表和数据字典表之间的关系
客户信息表部分列名：

![输入图片说明](https://images.gitee.com/uploads/images/2020/0417/161432_4ae82b00_6533994.png "客户表.png")

数据字典表部分列名：

![输入图片说明](https://images.gitee.com/uploads/images/2020/0417/161445_5a41cb58_6533994.png "数据字典表.png")

在检索客户信息时，可以用客户名、客户来源、客户所属行业、客户级别来作为检索信息。但是客户来源、客户所属行业、客户级别这三列在表中均是Int型，没有存储客户相关信息，而客户信息都存储在了数据字典中。可以通过客户信息表三列中的Int值关联数据字典的dict_id，需要进行联结操作。

![输入图片说明](https://images.gitee.com/uploads/images/2020/0417/164452_d884f08b_6533994.png "屏幕截图.png")

#### 前后端交互流程图
![输入图片说明](https://images.gitee.com/uploads/images/2020/0427/220647_11380187_6533994.png "屏幕截图.png")

#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
