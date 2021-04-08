package com.sl.base;

import com.sl.base.handler.ReadObjectFromDbHandler;
import com.sl.base.parameter.MybatisParameter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

import java.util.Map;
import java.util.Optional;

/**
 * @author shuliangzhao
 * @Title: BaseObjectReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 20:46
 */
public class BaseObjectReader<T> extends MyBatisPagingItemReader<T> {

    private Map<String,Object> parameterValues;

    private Optional<MybatisParameter> parameterHandler;

    public BaseObjectReader(ReadObjectFromDbHandler handler,Optional<MybatisParameter> parameterHandler) {
        this.setQueryId(handler.queryId());
        this.setPageSize(handler.pageSize());
        this.parameterHandler = parameterHandler;
        MybatisParameter mybatisParameter = parameterHandler.get();
        Map<String, Object> parameters = mybatisParameter.parameters();
        setParameterValues(parameters);
    }

    public static class ReaderDefinition<T> {
       private Class<T> t;
       private String name;
       private String queryId;
       private int pageSize;

       private MybatisParameter parameter;

        public ReaderDefinition(Class<T> t, String name, String queryId, int pageSize, MybatisParameter parameter) {
            this.t = t;
            this.name = name;
            this.queryId = queryId;
            this.pageSize = pageSize;
            this.parameter = parameter;
        }
        public Class<T> getT() {
            return t;
        }

        public void setT(Class<T> t) {
            this.t = t;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getQueryId() {
            return queryId;
        }

        public void setQueryId(String queryId) {
            this.queryId = queryId;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public MybatisParameter getParameter() {
            return parameter;
        }

        public void setParameter(MybatisParameter parameter) {
            this.parameter = parameter;
        }
    }
}
