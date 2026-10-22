package com.leiwei2094.iris.core.loadbalance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SelectFirstLoadBalance implements ILoadBalance {
    private static final Logger log = LoggerFactory.getLogger(SelectFirstLoadBalance.class);
    @Override
    public int select(Map<String, String> config, int amount) throws Exception {
        log.info("SelectFirstLoadBalance to select ...");
        return 0;
    }
}
