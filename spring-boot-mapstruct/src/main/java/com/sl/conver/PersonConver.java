package com.sl.conver;

import com.sl.dto.PersonDto;
import com.sl.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @package: com.sl.conver
 * @author: shuliangzhao
 * @description:
 * @date 2022/1/6 21:48
 */
@Mapper
public interface PersonConver {

    PersonConver INSTANCE = Mappers.getMapper(PersonConver.class);

    @Mapping(source = "idCard",target = "identityCard")
    PersonDto converDto(Person person);

}
