package com.ps.beans.set;

import com.ps.beans.ComplexBean;
import com.ps.beans.SimpleBean;
import com.ps.beans.SimpleBeanImpl;
import com.ps.beans.set.ComplexBeanImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.java2d.pipe.SpanShapeRenderer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
public class SIBeansTest {
    private Logger logger = LoggerFactory.getLogger(SIBeansTest.class);

    @Test
    public void testConfig() {
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/set/sample-config-01.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/set/sample-config-02.xml");

        logger.info(" --- All beans in context --- ");
        for(String beanName :  ctx.getBeanDefinitionNames()) {
            logger.info("Bean " + beanName + " of type " + ctx.getBean(beanName).getClass().getSimpleName());
        }

        //TODO 4. Retrieve beans of types ComplexBean and make sure their dependencies were correctly set.
        SimpleBean simpleBean0 = ctx.getBean("simpleBean0", SimpleBean.class);
        assertNotNull(simpleBean0);
        ComplexBeanImpl cmplx0 = ctx.getBean("complexBean1", ComplexBeanImpl.class);
        assertEquals(simpleBean0, cmplx0.getSimpleBean());
        ComplexBeanImpl cmplx1 = ctx.getBean("complexBean1", ComplexBeanImpl.class);
        assertEquals(simpleBean0, cmplx1.getSimpleBean());
    }
}
