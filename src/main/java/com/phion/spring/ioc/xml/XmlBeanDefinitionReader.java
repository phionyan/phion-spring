package com.phion.spring.ioc.xml;

import com.phion.spring.ioc.AbstractBeanDefinitionReader;
import com.phion.spring.ioc.BeanDefinition;
import com.phion.spring.ioc.PropertyValue;
import com.phion.spring.ioc.PropertyValues;
import com.phion.spring.ioc.io.ResourceLoader;
import com.phion.spring.ioc.support.CollectionsUtils;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 负责解析xml资源中的bean信息
 *
 * @author yanful
 */
@Slf4j
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        try {
            InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
            doLoadBeanDefinitions(inputStream);
        } catch (IOException e) {
            log.error("error in get inputStream on location : {}", location);
            e.printStackTrace();
        }
    }

    /**
     * 从io流中读取bean信息
     * <p>
     * 这里我们采用dom4j读取
     *
     * @param inputStream 输入流
     */
    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {

        SAXReader reader = new SAXReader();
        Document doc = reader.read(inputStream);
        // 解析bean
        registerBeanDefinitions(doc);
        inputStream.close();
    }

    /**
     * 注册bean信息
     */
    private void registerBeanDefinitions(Document doc) throws Exception {

        Element root = doc.getRootElement();
        //校验标签头
        if (!"beans".equals(root.getName())) {
            log.error("error ! can`t read from this file! root name:{}", root.getName());
            throw new Exception("error ! can`t read from this file! root name:" + root.getName());
        }

        //找出所有的bean标签,将bean加入注册表
        parseBeanDefinitions(root);
    }

    /**
     * 解析xml文档中的bean定义信息
     * @param root xml文档节点
     */
    private void parseBeanDefinitions(Element root) {

        List<Element> elementList = root.elements("bean");

        for (Element bean : elementList) {
            parseBeanDefinition(bean);
        }
    }

    /**
     * 解析xml文档中的bean定义信息
     * @param bean bean信息文档节点
     */
    private void parseBeanDefinition(Element bean) {
        BeanDefinition beanDefinition = new BeanDefinition();
        //记录bean名称
        String beanName = bean.attributeValue("name");
        //类名注入
        beanDefinition.setBeanClassName(bean.attributeValue("class"));
        //属性信息注入
        PropertyValues propertyValues = getPropertyValues(bean);
        beanDefinition.setPropertyValues(propertyValues);
        //加入注册表
        getRegistry().put(beanName, beanDefinition);
    }

    /**
     * 获取属性信息
     * @param bean bean信息文档节点
     * @return 属性信息集合
     */
    private PropertyValues getPropertyValues(Element bean) {
        PropertyValues propertyValues = null;
        List<Element> propertyEleList = bean.elements();
        if (CollectionsUtils.isNotEmpty(propertyEleList)) {
            propertyValues = parsePropertyValues(propertyEleList);
        }
        return propertyValues;
    }

    /**
     * 解析属性信息
     * @param propertyEleList 属性元素集合
     * @return 属性集合
     */
    private PropertyValues parsePropertyValues(List<Element> propertyEleList) {
        //定义属性集
        PropertyValues propertyValues = new PropertyValues();
        //注入属性信息
        for (Element property : propertyEleList) {
            parsePropertyValue(propertyValues, property);
        }
        return propertyValues;
    }

    /**
     * 解析属性信息到属性集合
     * @param propertyValues 属性集合
     * @param property 属性节点
     */
    private void parsePropertyValue(PropertyValues propertyValues, Element property) {
        //读取属性信息
        String name = property.attributeValue("name");
        String value = property.attributeValue("value");
        //注入到属性集合
        PropertyValue pv = new PropertyValue(name, value);
        propertyValues.addPropertyValue(pv);
    }
}
