package com.myit.server;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 
 * testNG测试基础类<br>
 * testNG资源文件加载
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ContextConfiguration(locations = { 
        "classpath:conf/spring/bean-cfg-ds.xml", 
        "classpath:conf/spring/myit_server-servlet.xml"
})

@TransactionConfiguration(defaultRollback = false)
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

}
