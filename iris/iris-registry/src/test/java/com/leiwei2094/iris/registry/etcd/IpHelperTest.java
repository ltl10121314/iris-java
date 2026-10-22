package com.leiwei2094.iris.registry.etcd;

import com.leiwei2094.iris.core.IpHelper;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

@Ignore
public class IpHelperTest {
    private static final Logger log = LoggerFactory.getLogger(IpHelperTest.class);

    @Test
    public void test() throws Exception {
        String ip = IpHelper.getHostIp();
        log.info(ip);

        log.info("a{}b{}c{}", "foo", "bar", 100);
    }
}
