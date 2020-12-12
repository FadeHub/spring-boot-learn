package com.sl.reader;

import com.sl.entity.CreditBill;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

/**
 * @author shuliangzhao
 * @Title: CommonJdbcCursorReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/10 20:33
 */
public class CommonJdbcCursorReader extends JdbcCursorItemReader {


    public CommonJdbcCursorReader(Class clz,String sql,DataSource dataSource) {
       setDataSource(dataSource);
       setSql(sql);
       BeanPropertyRowMapper beanPropertyRowMapper = new BeanPropertyRowMapper();
       beanPropertyRowMapper.setMappedClass(clz);
       setRowMapper(beanPropertyRowMapper);
        //自定义RowMapper
       /*setRowMapper((rs,i) -> {
            CreditBill creditBill = new CreditBill();
            creditBill.setAcctid(rs.getString("acctid"));
            creditBill.setAddress(rs.getString("address"));
            creditBill.setAmout(rs.getInt("amout"));
            creditBill.setDate(rs.getDate("date"));
            creditBill.setName(rs.getString("name"));
            return creditBill;
       });*/
       //setPreparedStatementSetter(preparedStatement -> preparedStatement.setString(1,"5"));
    }
}
