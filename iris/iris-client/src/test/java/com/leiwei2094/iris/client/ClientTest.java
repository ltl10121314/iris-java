package com.leiwei2094.iris.client;

import com.leiwei2094.iris.core.IHelloService;
import com.leiwei2094.iris.registry.EtcdRegistry;
import com.leiwei2094.iris.registry.IRegistry;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Ignore
public class ClientTest {
    private static final Logger log = LoggerFactory.getLogger(ClientTest.class);

    @Test
    public void test() throws Exception {
        IRegistry registry = new EtcdRegistry("http://127.0.0.1:2379");
        RpcClient client = new RpcClient(registry);

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            try {
                IHelloService helloService = client.create(IHelloService.class);
                String s = helloService.hello("leo");
                log.info("===={}", s);

                String s2 = helloService.hello("tom");
                log.info("===={}", s2);

                String s3 = helloService.hello("jerry");
                log.info("===={}", s3);

                log.info("==== rpc invoke finished...");
                Thread.sleep(2 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 5, 3, TimeUnit.SECONDS);

        Thread.sleep(3000 * 1000);
    }

    @Test
    public void test2() throws Exception {
        IRegistry registry = new EtcdRegistry("http://127.0.0.1:2379");
        RpcClient client = new RpcClient(registry);

        com.leiwei2094.iris.core.IHelloService helloService =
            client.create(com.leiwei2094.iris.core.IHelloService.class);
        String s = helloService.hello("Hello");
        log.info(s);
    }
}
