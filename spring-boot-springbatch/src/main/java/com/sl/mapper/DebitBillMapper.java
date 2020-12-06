package com.sl.mapper;

import com.sl.entity.DebitBill;
import com.sl.entity.DebitBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DebitBillMapper {
    long countByExample(DebitBillExample example);

    int deleteByExample(DebitBillExample example);

    int insert(DebitBill record);

    int insertSelective(DebitBill record);

    List<DebitBill> selectByExample(DebitBillExample example);

    int updateByExampleSelective(@Param("record") DebitBill record, @Param("example") DebitBillExample example);

    int updateByExample(@Param("record") DebitBill record, @Param("example") DebitBillExample example);
}