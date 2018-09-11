## myNew
### 介绍
这是一个简单的最新资讯网站，现有频道有：军事、教育、科技、健康、星座、娱乐、体育、财经。数据来源于阿里云Api市场的新闻Api。
### 效果预览
![首页图](/images/main.png)
###  系统架构
本项目暂时采用SSM + MySql + Jsp的技术作支撑，后期有时间可能会将项目使用SpringBoot重构。
### 项目部署
项目的部署主要需要注意两点：
 * 找到sql文件(位于项目的DB文件夹下)，将sql导入到mysql数据库中
 * 需要购买[阿里云api](https://market.aliyun.com/products/57126001/cmapi011178.html?spm=5176.2020520132.101.5.54c37218jOImwX#sku=yuncode517800000)，这个api有免费的使用次数。如果使用其他新闻Api可能需要修改代码的处理逻辑
 * 上面两步搞定后需要对db.example.properties和api.example.properties重命名为db.properties和api.properties。
### 注意
 * 首页的轮播图是需要修改数据库中的数据，需要将数据库中的t_news表的字段**is_show_banner**由0改为1并且该条数据的**pic**必须有值且能访问。
### 项目进度
(1)项目基本搭建<br/>
(2)项目由servlet+jsp转成ssm<br />
(3)完成postgresql数据库的构建<br />
(4)从阿里云api获取数据，完成postgresql数据的填充<br />
(5)使用ssm完成新闻的展示，但是数据暂时只是本地。<br />
(6)数据可以从网络api中获取<br />
TODO......
### 项目期望
(1)freemarker完全替代jsp<br />
(2)使用freemarker完成网页静态化<br />
(3)使用定时任务，定时从阿里云api获取新闻数据<br />
(4)<del>接入newsql(postgresql)，放弃mysql</del>(**暂时放弃**)<br />
(5)<del>引入Spring Data-JPA,简化postgresql数据库的操作(不能再使用mybatis,需要引入其他orm框架，这点实现有待考虑。)</del>(**暂时放弃**)<br />
(6)在阿里云或者腾讯云部署上线，以后不用再看满天广告的新闻了。<br />
(7)今天试玩了一下spring boot，觉得非常有意思。看后期有没有机会重构。<br/>
TODO......
* * *
_以上均为很久以前的期望，后期考虑是否实现_
### 存在问题
(1)手机端适配存在问题<br />
(2)部分新闻内容夹杂着图片，影响列表新闻内容摘要的展示。