---
title: Alfred介绍
date: 2016-06-09 21:43:07
tags: 工具
categories: 工具
---

![/images/Alfred-icon.jpg](/images/Alfred-icon.jpg)

> 以前只是听说alfred比mac自带的搜索工具spotlight要强大很多，下载下来发现其实也没体验到有多强大，最近这几天闲来无聊，把玩mac的时候尝试了下alfred的其他功能，不得不说太强大了，so powerful !
>
> Alfred is an award-winning app for Mac OS X which boosts your efficiency with hotkeys, keywords, text expansion and more. Search your Mac and the web, and be more productive with custom actions to control your Mac.


## 基础功能
- `打开应用程序`, 覆盖了spotlight的所有功能， and there is more
- `简单搜索`，直接在输入框里面输入你需要的关键词，回车即提交Google搜索
- `定位文件`，ctrl-space 呼出Alfred后，键入空格，输入你要查找文件名，即可定位文件，回车打开，command+回车打开文件所在文件夹
- `复杂操作文件`：通过find、open、in等关键词搜索文件。find是定位文件，open是定位并打开文件，in是在文件中进行全文检索，三种检索方式基本上可以找到任何你想找的文件
- `操作Shell`：输入`>`即可直接运行shell命令。比如`> cat *.py | grep print，可以直接打开终端并查找当前py文件中包含 print 的语句。`
- `控制itunes播放`，输入iTunes，会出现一个 iTunes mini play，打开可以通过 Alfred 控制音乐播放。用快捷键也能完成这个功能：shift+option+command+p
- 输入email，后面跟邮件地址，可以直接打开写邮件的界面
- `定义文字片段和粘贴板`，在 Alfred 的设置-Features 选中Clipboard，在Snippets里定义自己常用的文字片段，比如代码、地址等等等，之后以`option+command+l` (*这个快捷键是我自己定义的，原先的和其他的快捷键有冲突*)呼出界面，输入文字片段的关键字回车即可。*<u>这里可以保存很长时间的粘贴板的内容，赞！！！</u>*
- `自定义搜索`，这个稍微复杂些，打开设置窗口，点击Features-Custom Search，在右侧栏添加自定义搜索。举几个例子帮助大家理解下规则：
  - 搜索iOS App：
  ```
  Search URL：
  itunes://ax.search.itunes.apple.com/WebObjects/MZSearch.woa/wa/search?term={query}
  Title：iOS App 
  ```
  - 搜索Mac app:
  ```
  Search URL:
  macappstore://ax.search.itunes.apple.com/WebObjects/MZSearch.woa/wa/search?q={query}
  Title: mac app
  keywords: mac
  ```


## workflow 插件
> alfred给予了用户很大的自由度去对其进行扩展，这就是workflow插件机制，用户可以按照一定的开发规范，开发各自的任务插件，比如打电话、发短信、播放音乐，搜索天气等等...是不是非常的强大！
>
> With Alfred's Powerpack and workflows, you can extend Alfred and get things done in your own way. Replace repetitive tasks with workflows, and boost your productivity.

### 先看看我的workflow
![myalfredworkflow](/images/myalfred_workflow.png)

> 有非常多的这种workflow可以供我们下载使用：当然我们也可以去Google，一搜一大堆，或者直接安装一个叫`workflow search`的workflow,直接在alfred上搜，下面提供两个比较常用的搜索地址：
> https://www.alfredapp.com/workflows
> http://www.alfredworkflow.com

#### workflow search
这个插件可以随时直接在搜索框中搜索可用的workflow,并下载，关键字是：`wf`
![workflow_search](/images/workflow_search.png)
#### baidu weather
直接查看当前城市的天气状况，关键字：`tq`
![baidu_weather](/images/baidu_weather.png)
#### air quality
查看当前城市的空气质量, 关键字： `air`
![air_quality](/images/air_quality.png)
#### copy path
这个workflow 直接做成快捷键的方式，在finder里面选中文件后，直接快捷键：`ctrl-shift-c` 即可拷贝当前文件的绝对路径
![copy_path](/images/copy_path.png)
#### 有道翻译
直接在搜索框中翻译，自动转换中英文， 关键字： `yd`
![youdao](/images/youdao.png)
#### 知乎日报
直接查看知乎日报的热门文章列表， 关键字： `zh`
![zhihudaily](/images/zhihudaily.png)
#### 人民币金额大写
直接转换人民币金额的大写中文， 关键字： `cny`
![cny](/images/cny.png)
#### stackoverflow 搜索
直接搜索stackoverflow上的相关答案信息，关键字： `.so`
![stackoverflow](/images/stackoverflow_wf.png)
#### 电话呼叫
直接呼叫iphone上的联系人： 关键字: `call` 这个貌似不支持电话薄的查询，需要每次都输入电话号码，比较麻烦
![call](/images/call.png)
![calling](/images/calling.png)
#### evernote 搜索
搜索印象笔记中的内容，同时可以新建笔记，
关键字：en 搜索笔记，ennew 新建笔记
![evernote](/images/evernote.png)
#### 百度地图搜索
搜索百度地图，
关键字： setl: 设置当前城市， bmap 定位具体地点
![baidumap](/images/baidumap.png)

#### 结语
{% centerquote %}
alfred 的一般基本功能已经能满足日常大部分的使用了，而且比spotlight要好用的多，付费的powerpak－workflow进一步提升了这个工具的逼格，把玩过后，我只想说，不要太牛掰啊！
{% endcenterquote %}
