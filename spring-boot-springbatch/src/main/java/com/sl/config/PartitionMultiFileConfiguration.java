package com.sl.config;

import com.sl.base.BaseObjectReader;
import com.sl.entity.CreditBill;
import com.sl.listener.PartitionStepListener;
import com.sl.partitioner.MyMultiResourcePartitioner;
import com.sl.processor.PartitonMultiFileProcessor;
import com.sl.reader.PartitionMultiFileReader;
import com.sl.writer.PartitionMultiFileWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.MultiResourcePartitioner;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: PartitionFileConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/4 21:09
 */
@Configuration
@EnableBatchProcessing
public class PartitionMultiFileConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PartitonMultiFileProcessor partitonMultiFileProcessor;

    @Autowired
    private PartitionMultiFileWriter partitionMultiFileWriter;

    @Autowired
    private PartitionStepListener partitionStepListener;

    @Bean
    public Job partitionMultiFileJob() {
         return jobBuilderFactory.get("partitionMultiFileJob")
                 .start(partitionMasterMultiFileStep())
                 .build();
    }

    @Bean
    public Step partitionMasterMultiFileStep() {
        return stepBuilderFactory.get("partitionMasterMultiFileStep")
                .partitioner(partitionSlaveMultiFileStep().getName(),multiResourcePartitioner())
                .partitionHandler(multiFilePartitionHandler())
                .build();
    }

    @Bean
    public PartitionHandler multiFilePartitionHandler() {
        TaskExecutorPartitionHandler handler = new TaskExecutorPartitionHandler();
        handler.setGridSize(2);
        handler.setStep(partitionSlaveMultiFileStep());
        handler.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return handler;
    }

    @Bean
    public Step partitionSlaveMultiFileStep() {
        return stepBuilderFactory.get("partitionSlaveMultiFileStep")
                .listener(partitionStepListener)
                .<CreditBill,CreditBill>chunk(1)
                .reader(partitionMultiFileReader(null))
                .processor(partitonMultiFileProcessor)
                .writer(partitionMultiFileWriter)
                .build();
    }

    @Bean
    @StepScope
    public PartitionMultiFileReader partitionMultiFileReader(@Value("#{stepExecutionContext[fileName]}")String fileName) {
        return new PartitionMultiFileReader(CreditBill.class,fileName);
    }


    @Bean
    public MyMultiResourcePartitioner multiResourcePartitioner() {
        MyMultiResourcePartitioner multiResourcePartitioner = new MyMultiResourcePartitioner();
         multiResourcePartitioner.setKeyName("fileName");
         multiResourcePartitioner.setResources(getResource());
         return multiResourcePartitioner;
    }

    private Resource[] getResource() {
        String filePath = "D:\\aplus\\bill\\";
        File file = new File(filePath);
        List<Resource> resourceList = new ArrayList<>();
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    String resource = file.getPath() + "\\" + str;
                    FileSystemResource fileSystemResource = new FileSystemResource(resource);
                    resourceList.add(fileSystemResource);
                }
            }
        }
        Resource[] resources = new Resource[resourceList.size()];
        return resourceList.toArray(resources);
    }

}
