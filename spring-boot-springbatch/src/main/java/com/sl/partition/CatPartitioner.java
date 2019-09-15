package com.sl.partition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: CatPartitioner
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/15 20:00
 */
@Component
public class CatPartitioner implements Partitioner {

    private static final Logger log = LoggerFactory.getLogger(CatPartitioner.class);

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        log.info("partition  gridsize is " + gridSize);
        Map<String, ExecutionContext> result = new HashMap<>();
        int range = 10;
        int fromId = 1;
        int toId = range;
        for (int i = 1; i <= gridSize; i++) {
            ExecutionContext value = new ExecutionContext();

            log.info("\nStarting : Thread" + i);
            log.info("fromId : " + fromId);
            log.info("toId : " + toId);

            value.putInt("fromId", fromId);
            value.putInt("toId", toId);

            // give each thread a name, thread 1,2,3
            value.putString("name", "Thread" + i);

            result.put("partition" + i, value);

            fromId = toId + 1;
            toId += range;

        }
        return result;
    }
}
