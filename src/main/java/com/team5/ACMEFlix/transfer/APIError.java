package com.team5.ACMEFlix.transfer;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class APIError {
    Integer status;
    String message;
    String  path;
}
