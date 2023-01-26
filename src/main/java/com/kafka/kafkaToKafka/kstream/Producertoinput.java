package com.kafka.kafkaToKafka.kstream;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;


public class Producertoinput {
    private KafkaProducer<String, String> producer;
    private Properties producerProperties;

    public void KafkaProducerExample() {
        this.producerProperties = new Properties();
        this.producerProperties.put("bootstrap.servers", "localhost:9092");
        this.producerProperties.put("key.serializer", StringSerializer.class);
        this.producerProperties.put("value.serializer", StringSerializer.class);
        this.producer = new KafkaProducer<>(producerProperties);

    }

    public void sendMessage(String topic, String key, String value) {
        producer.send(new ProducerRecord<>("input-topic", "Test message"));
    }
    public void close(){
        producer.flush();
        producer.close();
    }



}
