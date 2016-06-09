---
title: Hexo-Guide
date: 2016-05-13 18:54:15
tags: hexo
categories: hexo
---

![hexo_logo](/images/hexo_logo.png)


Welcome to [Hexo](https://hexo.io/)! This is your very first post. Check [documentatoin](https://hexo.io/docs/) for more info. If you get any problems when using Hexo, you can find the answer in [troubleshooting](https://hexo.io/docs/troubleshooting.html) or you can ask me on [GitHub](https://github.com/hexojs/hexo/issues).

## hexo 一些相关的命令
{% centerquote %} 这里会介绍一些hexo相关的命令 {% endcenterquote %}


### 一些博客链接

[搭建博客连接:http://ibruce.info/2013/11/22/hexo-your-blog/](http://ibruce.info/2013/11/22/hexo-your-blog/)

### Create a new post
新建一篇文章
``` bash
$ hexo new "My New Post"
```
More info: [Writing](https://hexo.io/docs/writing.html)

### Run server
本地服务器启动，可以在本地看到博客的情况，方便测试
``` bash
$ hexo server
```
More info: [Server](https://hexo.io/docs/server.html)

### Generate static files
生成hexo静态文件
``` bash
$ hexo generate
```
More info: [Server](https://hexo.io/docs/generating.html)

### Clean public folder files
清除public文件夹下的已经生成的静态文件
``` bash
$ hexo clean
```

### Deploy to remote sites
部署到github上的master分支上去
``` bash
$ hexo deploy
```
More info: [Deployment](https://hexo.io/docs/deployment.html)


## Hexo 的一些独特的标签 tag

![blank-tags](/images/tags.gif)

{% centerquote %}
 Now, We'll talk a little bit hexo tag plugins, To help you munipulate you blog easily!
{% endcenterquote %}

### 剧中引言 centerquote
{% raw %}
{% centerquote %} 引言放这里 {% endcenterquote %}
{% endraw %}

{% centerquote %} 引言放这里 {% endcenterquote %}

### 左对齐引言 blockquote
{% raw %}
{% blockquote David Levithan, Wide Awake http://wanders.com.cn 万的个人网站 %}
摘要引言放这里
{% endblockquote %}
{% endraw %}

引言：
{% blockquote David Levithan, Wide Awake http://wanders.com.cn 万的个人网站 %}
Do not just seek happiness for yourself. Seek happiness for all. Through kindness. Through mercy.
{% endblockquote %}

### 插入图片
- `![/images/IMG_6322.JPG](/images/IMG_6322.JPG)`  这个是标准的markdown的插入图片的语法
- {% raw %} {% asset_img water-flow.jpg water is comming ! %} {% endraw %} 这种标签标示的时候`water-flow.jpg`必须要在文章同级目录下的同名文件夹下

![/images/IMG_6322.JPG](/images/IMG_6322.JPG)

### 插入视频 add a youtubu video
{% raw %} {% youtube wgdBVIX9ifA %} {% endraw %}
这里是视频id=wgdBVIX9ifA:
{% youtube wgdBVIX9ifA %}

### 嵌入一段代码,代码是跟路径下的文件：gulpfile.js
{% raw %} {% include_code [gulpfile] [lang:javascript] gulpfile.js %} {% endraw %}
{% include_code [gulpfile] [lang:javascript] gulpfile.js %}

### 给代码片段加入一个URL codeblock
{% raw %}
  {% codeblock _.compact http://underscorejs.org/#compact Underscore.js %}
    code put here
  {% endcodeblock %}
{% endraw %}

{% codeblock _.compact http://underscorejs.org/#compact Underscore.js %}
_.compact([0, 1, false, 2, '', 3]);
=> [1, 2, 3]
{% endcodeblock %}

### 普通段落引言
{% pullquote [qut] %}
you wanna quote something, you'd better place it here!
{% endpullquote %}


### 嵌入一个网页 add a iframe
{% raw %} {% iframe http://baidu.com 100% 100% %} {% endraw %}

{% iframe http://baidu.com 100% 100% %}

### 原始文字 raw
{% raw %} {% raw %} what ever you put here {% endraw %} {% endraw %}
{% raw %}
 If certain content is causing processing issues in your posts, wrap it with the raw tag to avoid rendering errors.
{% endraw %}

### 邮件 mail to me
<mailto:kriswansf@gmail.com>
