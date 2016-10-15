package com.mircic.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Configuration
@EnableBinding(TestSource.class)
public class KafkaConfig {

    @Bean
    @InboundChannelAdapter(value = TestSource.TOPIC, poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "1"))
    public MessageSource<String> timerMessageSource() {
        return new MessageSource<String>() {
            @Override
            public Message<String> receive() {
                return MessageBuilder.withPayload(String.format("System time: %d", System.currentTimeMillis()))
                        .build();
            }
        };
    }
}
