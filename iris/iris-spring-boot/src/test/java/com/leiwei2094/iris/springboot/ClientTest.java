package com.leiwei2094.iris.springboot;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@TestPropertySource(value = "classpath:/application-client.properties")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class)
public class ClientTest {
    private static final Logger log = LoggerFactory.getLogger(ClientTest.class);

    @Autowired
    private Foo foo;

    @Ignore
    @Test
    public void test() throws Exception {
        log.info("==tom==");
        log.info(foo.hello("tom"));
        log.info("==leo==");
        log.info(foo.hello("leo"));
    }
}
