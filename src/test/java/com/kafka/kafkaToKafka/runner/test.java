package com.kafka.kafkaToKafka.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resource/cucumber/kafka.feature",glue = "com.kafka.kafkaToKafka.stepdef")
public class test {


}
