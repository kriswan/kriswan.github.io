---
title: Hexo-Tags
date: 2016-05-13 18:54:15
tags: hexo
categories: hexo
---
{% centerquote %} 
In this article, We'll talk a little bit hexo tag plugins, To help you munipulate you blog easily! 
{% endcenterquote %}

### add a quote
{% blockquote David Levithan, Wide Awake http://wanders.com.cn 万的个人网站 %}
Do not just seek happiness for yourself. Seek happiness for all. Through kindness. Through mercy.
{% endblockquote %}

### add a youtubu video 
{% youtube wgdBVIX9ifA %}

### include a code file
{% include_code [gulpfile] [lang:javascript] gulpfile.js %}

### adding a caption and a URL to a codeblock
{% codeblock _.compact http://underscorejs.org/#compact Underscore.js %}
_.compact([0, 1, false, 2, '', 3]);
=> [1, 2, 3]
{% endcodeblock %}

{% pullquote [qut] %}
you wanna quote something, you'd better place it here!
{% endpullquote %}

### add a iframe 
{% iframe http://baidu.com 100% 100% %}

{% raw %}
 If certain content is causing processing issues in your posts, wrap it with the raw tag to avoid rendering errors.
{% endraw %}

### mail to me
<mailto:kriswansf@gmail.com>