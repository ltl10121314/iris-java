package com.leiwei2094.iris.registry.etcd;

import com.coreos.jetcd.Client;
import com.coreos.jetcd.KV;
import com.coreos.jetcd.data.ByteSequence;
import com.coreos.jetcd.data.KeyValue;
import com.coreos.jetcd.kv.GetResponse;
import com.coreos.jetcd.options.GetOption;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Ignore
public class GetTest {
    private static final Logger log = LoggerFactory.getLogger(GetTest.class);

    @Test
    public void testGetWithPrefix() throws Exception {
        Client client = Client.builder().endpoints("http://localhost:2379").build();
        KV kvClient = client.getKVClient();

        String prefix = "test_key";
        ByteSequence key = ByteSequence.fromString(prefix);

        for (int i = 0; i < 5; i++) {
            ByteSequence testKey = ByteSequence.fromString("test_key_" + i);
            ByteSequence testVal = ByteSequence.fromString("test_val_" + i);

            kvClient.put(testKey, testVal).get();
        }

        ByteSequence dsfs = ByteSequence.fromString("dsfs");
        GetResponse response = kvClient.get(dsfs, GetOption.newBuilder().withPrefix(key).build()).get();

        for (KeyValue kv : response.getKvs()) {
            log.info("{} : {}", kv.getKey().toStringUtf8(), kv.getValue().toStringUtf8());
        }
    }
}
