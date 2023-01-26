package com.kafka.kafkaToKafka.stepdef;

import static org.mockito.Mockito.verify;
import com.kafka.kafkaToKafka.kstream.KstreamToKstream;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.Duration;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {






    @Mock
    private KafkaTemplate kafkaTemplate;
    private KstreamToKstream kstream;
    private Properties config;
    private KafkaProducer<String, String> producer;

    @Given("the input topic topic are configured")
    public void theInputTopicisConfigured() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(props);

            producer.send(new ProducerRecord<>("input-topic","Test message"));



        }
    @Given("the output topic are configured")
    public void theOutputTopicisConfigured() {

        config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-streams-demo");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        kstream = new KstreamToKstream();
    }


    @When("the Kafka streams application starts")
    public void theKafkaStreamsApplicationStarts() {
        kstream.inputTopicToOutputTopic();


    }
    String message;
    @KafkaListener(topics = "output-topic")
    public void receivemsg(String receiveMsg){

        this.message=message+receiveMsg;
        System.out.println(receiveMsg);

    }


    @Then("data should be read from the input topic and written to the output topic")
    public void dataShouldBeReadFromTheInputTopicAndWrittenToTheOutputTopic() {
        assertEquals("Test message","");


    }
}
