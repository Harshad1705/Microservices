package com.harrySpringBoot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.harrySpringBoot.entity.Wikimedia;
import com.harrySpringBoot.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

    @Value("$spring.kafka.topic.name")
    String topicName;

    private final static Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @Autowired
    private WikimediaDataRepository wikimediaDataRepository;

    @KafkaListener(topics = "wikimedia_recent_change" , groupId = "myGroup")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Message received -> %s", eventMessage));
        
        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setWikiEventData(eventMessage);

        wikimediaDataRepository.save(wikimedia);

    }

}
