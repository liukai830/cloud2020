package com.liuk.cloud.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink02 {
    String MY_INPUT = "default.message";
    @Input(MY_INPUT)
    SubscribableChannel myInput();
}
