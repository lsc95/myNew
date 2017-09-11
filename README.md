## myNew
### 介绍
这是一个简单的最新资讯网站，现有频道有：军事、教育、科技、健康、星座、娱乐、体育、财经。数据暂时是来源与数据库。后期将采用阿里云市场的api.
### 效果预览
![首页图](/images/main.png)
### 注意
功能暂时没有完全实现，并且存在较多bug。后期将会不断的进行改进。
### 进度
(1)项目基本搭建<br/>
(2)项目由servlet+jsp转成ssm<br />
(3)完成postgresql数据库的构建<br />
(4)从阿里云api获取数据，完成postgresql数据的填充<br />
TODO.....
### 期望
(1)freemarker完全替代jsp<br />
(2)使用freemarker完成网页静态化<br />
(3)使用定时任务，定时从阿里云api获取新闻数据<br />
(4)接入newsql(postgresql)，放弃mysql<br />
(5)引入Spring Data-JPA,简化postgresql数据库的操作(不能再使用mybatis,需要引入其他orm框架，这点实现有待考虑。)<br />
后期有idea，再追加！！！
