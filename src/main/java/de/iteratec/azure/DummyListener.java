package de.iteratec.azure;

import de.iteratec.azure.messages.DammyEvent;
import de.iteratec.azure.messages.DummyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
@ConditionalOnProperty(value = "spring.jms.servicebus.enabled", havingValue = "true")
public class DummyListener {

    private Logger log = LoggerFactory.getLogger(DummyListener.class);

    @JmsListener(destination = "partitioned", subscription = "dummy", containerFactory = "topicJmsListenerContainerFactory")
    public void onMessage(@Payload DammyEvent event) {
        log.info("recived: {}", event);
    }


    @JmsListener(destination = "partitioned", subscription = "dummy", containerFactory = "topicJmsListenerContainerFactory")
    public void onMessage(@Payload DummyEvent event) {
        log.info("recived: {}", event);
    }

}
