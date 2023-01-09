package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Address;
import com.team5.ACMEFlix.transfer.resource.AddressResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressResource>{

}
