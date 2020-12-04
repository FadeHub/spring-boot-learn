package com.sl.mapper;

import com.sl.entity.CreditBill;
import com.sl.entity.CreditBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditBillMapper {
    long countByExample(CreditBillExample example);

    int deleteByExample(CreditBillExample example);

    int insert(CreditBill record);

    int insertSelective(CreditBill record);

    List<CreditBill> selectByExample(CreditBillExample example);

    int updateByExampleSelective(@Param("record") CreditBill record, @Param("example") CreditBillExample example);

    int updateByExample(@Param("record") CreditBill record, @Param("example") CreditBillExample example);
}