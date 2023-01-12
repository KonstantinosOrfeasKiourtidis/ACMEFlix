package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.transfer.resource.AccountResource2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper2 extends BaseMapper<Account, AccountResource2>{
}

