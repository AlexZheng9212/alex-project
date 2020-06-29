package com.alex.common.db.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class BaseEntity {

  public UUID id;

  public LocalDateTime createdAt;

  public LocalDateTime updatedAt;

  public void setId(String id) {
    this.id = UUID.fromString(id);
  }

  public UUID getId() {
    return id;
  }

}