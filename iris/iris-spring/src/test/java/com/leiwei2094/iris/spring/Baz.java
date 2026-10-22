package com.leiwei2094.iris.spring;

import com.leiwei2094.iris.core.IHelloService;
import com.leiwei2094.iris.core.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Baz {
    private static final Logger log = LoggerFactory.getLogger(Baz.class);
    @Reference(interfaceClass = IHelloService.class)
    private IHelloService helloService;

    public void hello(String name) throws Exception {
        log.info(helloService.hello(name));
    }
}
