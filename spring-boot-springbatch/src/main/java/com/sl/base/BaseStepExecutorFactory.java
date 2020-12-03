package com.sl.base;

import com.sl.base.handler.ObjectProcessorHandler;
import com.sl.base.handler.ObjectWriterDbWriter;
import com.sl.base.handler.ReadObjectFromDbHandler;
import com.sl.base.handler.WriterObjectToDbHander;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author shuliangzhao
 * @Title: BaseStepExecutorFactory
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 21:27
 */
@Component
@StepScope
public class BaseStepExecutorFactory {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     *
     * @param definition
     * @param <T>
     * @return
     */
    public <T extends Object> BaseObjectReader<T> createDefaultBaseReader(BaseObjectReader.ReaderDefinition<T> definition) {
        ReadObjectFromDbHandler handler = new ReadObjectFromDbHandler() {
            @Override
            public String queryId() {
                return definition.getQueryId();
            }

            @Override
            public int pageSize() {
                return definition.getPageSize();
            }
        } ;
        BaseObjectReader baseObjectReader = new BaseObjectReader(handler, Optional.of(definition.getParameter()));
        baseObjectReader.setName(definition.getName());
        baseObjectReader.setSqlSessionFactory(sqlSessionFactory);
        return baseObjectReader;
    }

    /**
     *
     * @param handler
     * @param <I>
     * @param <O>
     * @return
     */
    public <I,O extends Object> BaseObjectProcessor createBaseProcess(ObjectProcessorHandler<I,O> handler) {
        BaseObjectProcessor processor = new BaseObjectProcessor(handler);
        return processor;
    }

    /**
     *
     * @param hander
     * @param <T>
     * @return
     */
    public <T extends Object> ObjectWriterDbWriter createObjectWriterDbWriter(WriterObjectToDbHander<T> hander) {
        ObjectWriterDbWriter<T> writer = new ObjectWriterDbWriter<>(hander);
        return writer;
    }
}
