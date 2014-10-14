---
layout: post
title: "Proxool configuration for spring"
description: "proxool 配置介绍"
category: 
tags: [proxool]
---
{% include JB/setup %}

##proxool 介绍

Proxool是一种Java数据库连接池技术。sourceforge下的一个开源项目,这个项目提供一个健壮、易用的连接池，最为关键的是这个连接池提供监控的功能，方便易用，便于发现连接泄漏的情况。
目前是和DBCP以及C3P0一起，最为常见的三种JDBC连接池技术。
日前，Hibernate官方宣布由于Bug太多不再支持DBCP，而推荐使用 Proxool或C3P0。

####常用配置
    <something-else-entirely> 
            <proxool> 
                    <alias>timalias</alias> 
                    <!--数据源的别名--> 
                    <driver-url>jdbc:oracle:thin:@192.168.104.192:1521:tim</driver-url> 
                    <!--url连接串--> 
                    <driver-class>oracle.jdbc.driver.OracleDriver</driver-class> 
                    <!--驱动类--> 
                    <driver-properties> 
                            <property name="user" value="tim"/> 
                            <!--用户名--> 
                            <property name="password" value="tim_8968888"/> 
                            <!--密码--> 
                    </driver-properties> 
                    <!--最大连接数(默认5个),超过了这个连接数,再有请求时,就排在队列中等候,最大的等待请求数由maximum-new-connections决定 --> 
                    <maximum-connection-count>100</maximum-connection-count> 
                    <!--最小连接数(默认2个)--> 
                    <minimum-connection-count>10</minimum-connection-count> 
                    <!--proxool自动侦察各个连接状态的时间间隔(毫秒),侦察到空闲的连接就马上回收,超时的销毁 默认30秒--> 
                    <house-keeping-sleep-time>90000</house-keeping-sleep-time> 
                    <!--没有空闲连接可以分配而在队列中等候的最大请求数,超过这个请求数的用户连接就不会被接受--> 
                    <maximum-new-connections>10</maximum-new-connections> 
                    <!--最少保持的空闲连接数(默认2个)--> 
                    <prototype-count>5</prototype-count> 
                    <!--在使用之前测试--> 
                    <test-before-use>true</test-before-use> 
                    <!--用于保持连接的测试语句 --> 
                    <house-keeping-test-sql>select sysdate from dual</house-keeping-test-sql> 
            </proxool> 
    </something-else-entirely>

####proxool 常用spring配置示例：
    	<bean id="parentDataSource" class="com.qunar.flight.flagship.system.ProxoolDataSource">
    		<property name="maximumConnectionCount" value="30" />
    		<property name="minimumConnectionCount" value="3" />
    		<property name="simultaneousBuildThrottle" value="3" />
    		<property name="prototypeCount" value="3" />
    		<property name="houseKeepingSleepTime" value="40000" />
    		<property name="maximumActiveTime" value="1800000" />
    		<property name="maximumConnectionLifetime" value="18000000" />
    		<property name="fatalSqlExceptionsAsString" value="Fatal error" />
    		<property name="testBeforeUse" value="true" />
    		<property name="houseKeepingTestSql" value="select CURRENT_DATE" />
    	</bean>
    
    	<bean id="dataSourceScal" parent="parentDataSource">
    		<property name="alias" value="newScal" />
    		<property name="driverUrl" value="jdbc:mysql://192.168.28.23:3306/scal" />
    		<property name="driver" value="com.mysql.jdbc.Driver" />
    		<property name="user" value="f_flagshipmain_w" />
    		<property name="password" value="HTDaBeJ81Nv2" />
    	</bean>
    	
####proxool 配合hibernate配置：
        <bean id="sessionFactory"  class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
            <property name="hibernateProperties">
               <props>
               <prop key="hibernate.connection.provider_class">org.hibernate.connection.ProxoolConnectionProvider</prop>
               
                  <prop key="hibernate.dialect">org.hibernate.dialect.OracleDialect</prop>
                   <prop key="hibernate.cglib.use_reflection_optimizer">true</prop>
                  <prop key="hibernate.proxool.xml">proxool.xml</prop>
                   <prop key="hibernate.proxool.pool_alias">DBPool</prop>
               </props>
           </property>
           <property name="mappingResources"/>
          </bean>
    
####参数说明
`fatal-sql-exception`: 它是一个逗号分割的信息片段.当一个SQL异常发生时,他的异常信息将与这个信息片段进行比较.如果在片段中存在,那么这个异常将被认为是个致命错误 (Fatal SQL Exception ).这种情况下,数据库连接将要被放弃.无论发生什么,这个异常将会被重掷以提供给消费者.用户最好自己配置一个不同的异常来抛出.
fatal-sql-exception-wrapper-class:正如上面所说,你最好配置一个不同的异常来重掷.利用这个属性,用户可以包装
SQLException,使他变成另外一个异常.这个异常或者继承SQLException或者继承字RuntimeException.proxool
自带了2个实现:'org.logicalcobwebs.proxool.FatalSQLException' 和'org.logicalcobwebs.proxool.FatalRuntimeException'.后者更合适.

`house-keeping-sleep-time`: house keeper 保留线程处于睡眠状态的最长时间,house keeper 的职责就是检查各个连接的状态,并判断是否需要销毁或者创建.

`house-keeping-test-sql`: 如果发现了空闲的数据库连接.house keeper 将会用这个语句来测试.这个语句最好非常快的被执行.如果没有定义,测试过程将会被忽略。

`injectable-connection-interface`: 允许proxool实现被代理的connection对象的方法.

`injectable-statement-interface`: 允许proxool实现被代理的Statement 对象方法.

`injectable-prepared-statement-interface`: 允许proxool实现被代理的PreparedStatement 对象方法.

`injectable-callable-statement-interface`: 允许proxool实现被代理的CallableStatement 对象方法.

`jmx`: 如果属性为true，就会注册一个消息Bean到jms服务，消息Bean对象名: "Proxool:type=Pool, name=<alias>". 默认值为false.

`jmx-agent-id`: 一个逗号分隔的JMX代理列表(如使用MBeanServerFactory.findMBeanServer(String agentId)注册的连接池。）这个属性是仅当"jmx"属性设置为"true"才有效。所有注册jmx服务器使用这个属性是不确定的

`jndi-name`: 数据源的名称

`maximum-active-time`: 如果housekeeper 检测到某个线程的活动时间大于这个数值.它将会杀掉这个线程.所以确认一下你的服务器的带宽.然后定一个合适的值.默认是5分钟.

`maximum-connection-count`: 最大的数据库连接数.

`maximum-connection-lifetime`: 一个线程的最大寿命.

`minimum-connection-count`: 最小的数据库连接数

`overload-without-refusal-lifetime`: 这可以帮助我们确定连接池的状态。如果我们已经拒绝了一个连接在这个设定值(毫秒),然后被认为是超载。默认为60秒。

`prototype-count`: 连接池中可用的连接数量.如果当前的连接池中的连接少于这个数值.新的连接将被建立(假设没有超过最大可用数).例如.我们有3个活动连接2个可用连接,而我们的prototype-count是4,那么数
据库连接池将试图建立另外2个连接.这和 minimum-connection-count不同. minimum-connection-count把活动的连接也计算在内.prototype-count 是spare connections 的数量.

`recently-started-threshold`: 这可以帮助我们确定连接池的状态,连接数少还是多或超载。只要至少有一个连接已开始在此值(毫秒)内,或者有一些多余的可用连接,那么我们假设连接池是开启的。默认为60秒

`simultaneous-build-throttle`: 这是我们可一次建立的最大连接数。那就是新增的连接请求,但还没有可供使用的连接。由于连接可以使用多线程,在有限的时间之间建立联系从而带来可用连接，但是我们需要通过一些方式确认一些线程并不是立即响应连接请求的，默认是10。

`statistics`: 连接池使用状况统计。参数“10s,1m,1d”

`statistics-log-level`: 日志统计跟踪类型。参数“ERROR”或 “INFO”

`test-before-use`: 如果为true，在每个连接被测试前都会服务这个连接，如果一个连接失败，那么将被丢弃，另一个连接将会被处理，如果所有连接都失败，一个新的连接将会被建立。否则将会抛出一个SQLException异常。

`test-after-use`: 如果为true，在每个连接被测试后都会服务这个连接，使其回到连接池中，如果连接失败，那么将被废弃。

`trace`: 如果为true,那么每个被执行的SQL语句将会在执行期被log记录(DEBUG LEVEL).你也可以注册一个ConnectionListener (参看ProxoolFacade)得到这些信息.