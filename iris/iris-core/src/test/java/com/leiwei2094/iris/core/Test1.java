package com.leiwei2094.iris.core;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Test1 {
    private static final Logger log = LoggerFactory.getLogger(Test1.class);

    @Test
    public void test_random() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            log.info(String.valueOf(random.nextInt(10)));
        }
    }
}
