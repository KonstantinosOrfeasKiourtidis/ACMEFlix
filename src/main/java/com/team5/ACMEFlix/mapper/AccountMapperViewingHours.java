package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.transfer.resource.AccountResourceViewingHours;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapperViewingHours extends BaseMapper<Account, AccountResourceViewingHours>{
}
