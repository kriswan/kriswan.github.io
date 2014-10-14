---
layout: post
title: "How to install nginx and phusion"
description: "安装和配置nginx 和 phusion"
category: 
tags: [nginx,phusion]
---
{% include JB/setup %}

## --nginx

有三种方式来安装nginx

###1： Installing nginx from Ubuntu Packages
sudo add-apt-repository ppa:nginx/stable
sudo apt-get update
sudo apt-get upgrade --show-upgraded

1.1: 安装： 
    
    sudo apt-get install nginx

1.2: 启动： 
    
    sudo /etc/init.d/nginx start

###2: Installing nginx from the Source Distribution
    sudo apt-get update
    sudo apt-get upgrade --show-upgraded
    sudo apt-get install libpcre3-dev build-essential libssl-dev
    cd /opt/
    sudo wget http://nginx.org/download/nginx-1.3.7.tar.gz
    tar -zxvf nginx*
    cd /opt/nginx*/
    sudo make
    sudo make install
    sudo adduser --system --no-create-home --disabled-login --disabled-password --group nginx 

###3: Create an Init Script to Manage nginx
    sudo wget -O init-deb.sh http://www.linode.com/docs/assets/1139-init-deb.sh
    sudo mv init-deb.sh /etc/init.d/nginx
    sudo chmod +x /etc/init.d/nginx
    sudo /usr/sbin/update-rc.d -f nginx defaults

#####修改/etc/init.d/nginx中的nginx的路径，改为你本机自身安装的路径(主要是nginx.pid的路径要正确)

#####这时候就可以执行如下命令启动和停止nignx了
    sudo /etc/init.d/nginx start|stop|reload|restart|force-reload
    

## --phusion passenger

`phusion passenger` 是一个用来专门部署rails应用的解决方案，提供包括应用服务器和web服务器在内的一整套解决方案

`我本人安装nginx并没有使用上面讲的三种方式，而是用的这种方式,好处是passenger和nginx打包一起安装了`

###on ubuntu install: [phusion](https://www.phusionpassenger.com/documentation/Users%20guide%20Nginx.html#install_on_debian_ubuntu)

    sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 561F9B9CAC40B2F7
    sudo apt-get install apt-transport-https ca-certificates
    sudo touch  /etc/apt/sources.list.d/passenger.list

    #add follow line to /etc/apt/sources.list.d/passenger.list: 
    # Ubuntu 14.04
    deb https://oss-binaries.phusionpassenger.com/apt/passenger trusty main

    sudo chown root: /etc/apt/sources.list.d/passenger.list
    sudo chmod 600 /etc/apt/sources.list.d/passenger.list
    sudo apt-get update

安装`nginx-extra`  在这个nginx的扩展包里面内嵌上了`passenger`模块

    sudo apt-get install nginx-extras passenger  
    
Edit `/etc/nginx/nginx.conf` and uncomment `passenger_root` and passenger_ruby

    sudo service nginx restart   #启动nginx
    sudo passenger-memory-stats  #查看passenger和nginx是否启动
