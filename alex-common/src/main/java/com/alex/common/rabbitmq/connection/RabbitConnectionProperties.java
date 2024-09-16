package com.alex.common.rabbitmq.connection;

import java.util.List;

import com.rabbitmq.client.Address;

import lombok.Data;

@Data
public class RabbitConnectionProperties {

  private List<String> addresses;

  private int port;

  private String username;

  private String password;

  private String virtualhost;

  private int heartbeat = 60;

  private int reTrySecords = 5;

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