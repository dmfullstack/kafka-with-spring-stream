package com.mircic.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
@Configuration
@EnableBinding({Source.class, Sink.class})
public class KafkaConfig {

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "1"))
    public MessageSource<String> timerMessageSource() {
        return new MessageSource<String>() {
            @Override
            public Message<String> receive() {
                return MessageBuilder.withPayload(String.format("System time: %d", System.currentTimeMillis()))
                        .build();
            }
        };
    }

    @StreamListener(Sink.INPUT)
    public void receiveTimerMessage(String message) {
        log.info("Message received: {}", message);
    }
}