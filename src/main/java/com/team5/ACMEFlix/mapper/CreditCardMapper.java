package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.CreditCard;
import com.team5.ACMEFlix.transfer.resource.CreditCardResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditCardMapper extends BaseMapper<CreditCard, CreditCardResource>{

}
