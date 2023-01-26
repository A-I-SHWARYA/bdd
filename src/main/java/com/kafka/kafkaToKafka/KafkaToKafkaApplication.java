package com.kafka.kafkaToKafka;
import com.kafka.kafkaToKafka.kstream.KstreamToKstream;
import com.kafka.kafkaToKafka.kstream.Producertoinput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaToKafkaApplication {

	public static void main(String[] args) {
		KstreamToKstream kstream= new KstreamToKstream();
		Producertoinput pro= new Producertoinput();
		kstream.inputTopicToOutputTopic();
		SpringApplication.run(KafkaToKafkaApplication.class, args);

	}
}


