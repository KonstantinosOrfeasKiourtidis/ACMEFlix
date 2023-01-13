package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Payment;
import com.team5.ACMEFlix.transfer.resource.PaymentResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends BaseMapper<Payment, PaymentResource>{
}
