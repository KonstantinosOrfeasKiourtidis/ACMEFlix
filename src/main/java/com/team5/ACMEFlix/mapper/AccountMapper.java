package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.transfer.resource.AccountResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountResource>{
}
