tiny-spring
=====

步骤：

## step-1：最基本的容器

* 单纯的map，有get和put bean的功能


## step-2：inject自动注入

* 抽出beanfactory接口作为规范，提供AbstractBeanFactory作为默认实现，
另外使用AutowireBeanFactory实现自动装配的核心方法


## step-3：实现属性注入

* 我们需要用一个对象来表示属性信息，所以有了PropertyValue，为了方便对属性集合进行管理，
将属性集合封装成了PropertyValues对象，而不是简单使用List等集合


## step-4：实现通过xml注入bean

目前支持的参数是，name、class
子标签是property，参数是name，value

* 这个功能，概括性来讲，就是从xml配置文件中读取bean数据，并注入到bean工厂，
抽象出一个获取bean数信息接口BeanDefinitionReader，并根据数据源采用不同的实现类去读取bean定义信息
这里使用dom4j实现了xml文件的解析，从而注入bean
另外这里抽象出一个Resource接口表示资源文件，并提供各种实现类，使得可以通过不同方式读取配置信息


## setp-5 : 实现注入bean时传递引用类型

* 当一个bean的propperty为另一个bean时，传入应用类型
默认为延迟加载，即bean直到被使用时才会被创建
提供手动预加载的功能


