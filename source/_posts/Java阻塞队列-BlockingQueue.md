---
title: Java阻塞队列(BlockingQueue)
date: 2016-08-15 18:45:01
tags: [Java,数据结构]
categories: 数据结构
---

### 队列 Queue
> 队列是专门设计为存储需要优先处理的对象的集合, 队列中的集合操作方法有两种形式: ***1:抛出异常,2:返回特定值***

![](/images/14724800810004.jpg)


|    异常    | 特定值        |    解释   |
| ---------- | ---          |    ----   |
| add(e)     |  offer(e)    |    插入   |
| remove(e)  |  poll()      |    删除   |
| element()  |  peek        |    获取队列头部元素,但是不删除   |

