package ru.titov.artemis.controller;

import jakarta.jms.JMSException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.titov.artemis.dto.RequestDto;
import ru.titov.artemis.producer.ArtemisProducer;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SendController {
    private static Logger logger = LoggerFactory.getLogger(SendController.class);
    ArtemisProducer artemisProducer;

    @PostMapping("send")
    public ResponseEntity<String> send(@RequestBody RequestDto requestDto) throws JMSException {
        logger.warn("Get request:");
        logger.warn(requestDto.toString());
        artemisProducer.send(requestDto);

        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }
}
