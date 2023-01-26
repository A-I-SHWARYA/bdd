Feature: Kafka Streams
  As a developer, I want to be able to read data from an input topic and write it to an output topic using Kafka streams.

  Scenario: Kafka Streams data flow
    Given the input topic topic are configured
    Given the output topic are configured
    When the Kafka streams application starts
#    Then data should be read from the input topic and written to the output topic
