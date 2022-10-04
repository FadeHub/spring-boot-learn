package com.sl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sl.domain.TDmCust;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TDmCustMapperExt extends BaseMapper<TDmCust> {
    TDmCust selectByPrimaryKey(@Param("id") Long id);
}