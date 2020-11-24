tiny-spring
=====

步骤：

## step-1：最基本的容器

* 单纯的map，有get和put bean的功能


## step-2：inject自动注入

* 抽出beanfactory接口作为规范，提供AbstractBeanFactory作为默认实现，
另外使用AutowireBeanFactory实现自动装配的核心方法
