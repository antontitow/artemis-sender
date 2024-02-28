package ru.titov.artemis.producer;

import jakarta.jms.JMSException;
import ru.titov.artemis.dto.RequestDto;

public interface ArtemisProducer {
    void send(RequestDto requestDto) throws JMSException;
}
