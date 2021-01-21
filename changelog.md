tiny-spring ,created by phion ！
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


## step-5 : 实现注入bean时传递引用类型

* 当一个bean的propperty为另一个bean时，传入应用类型
默认为延迟加载，即bean直到被使用时才会被创建
提供手动预加载的功能

## step-6 : 实现上下文

* 通过使用ApplicationContext，可以无限拓展spring的功能，BeanFactory作为一个DI模块，成为应用上下文的核心部分。
通过应用上下文，我们可以方便实现ioc，而不用注意DI和资源解析器的交互。


## step-7 ： 实现AOP功能

* AOP功能的本质是通过代理对象执行方法，从而增强方法达到切面的效果。
spring中动态代理的实现方式有两种，JDK动态代理和CGLIB动态代理
JDK动态代理是利用反射生成某个接口的实现类，从而代理原来的实现类，实现增强
CGLIB动态代理通过继承目标类，覆盖父类的方法，实现增强


