package com.alex.common.rabbitmq.connection;

import java.util.List;

import com.rabbitmq.client.Address;

import lombok.Getter;
import lombok.Setter;

public class RabbitConnectionProperties {

  @Setter
  @Getter
  private List<String> addresses;

  @Setter
  @Getter
  private int port;

  @Setter
  @Getter
  private String username;

  @Setter
  @Getter
  private String password;

  @Setter
  @Getter
  private String virtualhost;

  @Setter
  @Getter
  private int heartbeat = 60;

  @Setter
  @Getter
  private int reTrySecords = 5;

  @Setter
  @Getter
  private int prefetchCount = 100;

  public Address[] getHostAddresses() {
    if (addresses != null) {
      Address[] res = new Address[this.addresses.size()];
      for (int i = 0; i < addresses.size(); i++) {
        res[i] = new Address(addresses.get(i), this.port);
      }
      return res;
    }
    return null;
  }

}