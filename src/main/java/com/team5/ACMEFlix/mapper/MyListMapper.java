package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.MyList;
import com.team5.ACMEFlix.transfer.resource.MyListResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyListMapper extends BaseMapper<MyList, MyListResource>{
}
