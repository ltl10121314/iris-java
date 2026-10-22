package com.leiwei2094.iris.client.bytebuddy;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class GeneralInterceptor {
    private static final Logger log = LoggerFactory.getLogger(GeneralInterceptor.class);

    @RuntimeType
    public String intercept(@AllArguments Object[] allArguments, @Origin Method method) {
        String name = method.getDeclaringClass().getName();
        log.info("{}.{}", name, method.getName());
        return "";
    }
}
