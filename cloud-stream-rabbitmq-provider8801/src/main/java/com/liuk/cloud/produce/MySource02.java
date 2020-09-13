package com.liuk.cloud.produce;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource02 {
    String MY_OUTPUT = "default.message";

    @Output(MY_OUTPUT)
    MessageChannel myOutput();
}
