package com.mircic.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TestSource {
    String TOPIC = "test";

    @Output(TestSource.TOPIC)
    MessageChannel output();
}
