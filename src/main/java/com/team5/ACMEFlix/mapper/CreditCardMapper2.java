package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.CreditCard;
import com.team5.ACMEFlix.transfer.resource.CreditCardResource2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditCardMapper2 extends BaseMapper<CreditCard, CreditCardResource2>{

}