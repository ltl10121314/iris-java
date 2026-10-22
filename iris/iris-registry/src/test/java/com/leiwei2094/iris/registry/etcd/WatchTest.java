package com.leiwei2094.iris.registry.etcd;

import com.coreos.jetcd.Client;
import com.coreos.jetcd.Watch;
import com.coreos.jetcd.data.ByteSequence;
import com.coreos.jetcd.options.WatchOption;
import com.coreos.jetcd.watch.WatchEvent;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Ignore
public class WatchTest {
    private static final Logger log = LoggerFactory.getLogger(WatchTest.class);

    @Test
    public void testWatchPrefix() throws Exception {

        Client client = Client.builder().endpoints("http://127.0.0.1:2379").build();
        Watch.Watcher watcher = client.getWatchClient().watch(ByteSequence.fromString("abc"),
            WatchOption.newBuilder().withPrefix(ByteSequence.fromString("abc")).build());

        while (true) {
            for (WatchEvent event : watcher.listen().getEvents()) {
                log.info(String.valueOf(event.getEventType()));
                log.info(event.getKeyValue().getKey().toStringUtf8());
                log.info(event.getKeyValue().getValue().toStringUtf8());
            }
        }
    }
}
