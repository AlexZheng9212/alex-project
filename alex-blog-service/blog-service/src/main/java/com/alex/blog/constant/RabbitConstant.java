package com.alex.blog.constant;

public class RabbitConstant {
  public enum QueueName {
    TEST_QUEUE_NAME("test queue");

    QueueName(String queueName) {
      this.queueName = queueName;
    }

    private final String queueName;

    @Override
    public String toString() {
      return this.queueName;
    }
  }

  public enum QueueExchange {
    TEST_QUEUE_EXCHANGE("TEST_EXCHANGE");

    QueueExchange(String exchange) {
      this.exchange = exchange;
    }

    private final String exchange;

    @Override
    public String toString() {
      return this.exchange;
    }
  }
}