package ru.titov.artemis.producer;

import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.titov.artemis.dto.RequestDto;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ArtemisProducerImpl implements ArtemisProducer {
    private static Logger logger = LoggerFactory.getLogger(ArtemisProducerImpl.class);
    JmsTemplate jmsTemplate;

    @Override
    public void send(RequestDto requestDto) throws JMSException {
        Queue tlQueue = jmsTemplate.getConnectionFactory().createConnection().createSession().createQueue(requestDto.queue());
        jmsTemplate.convertAndSend(tlQueue, requestDto.message());
        logger.warn("Send message into queue: {}", requestDto.queue());
    }
}
