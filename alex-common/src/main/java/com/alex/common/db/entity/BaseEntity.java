package com.alex.common.db.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class BaseEntity {

  public UUID id = UUID.randomUUID();

  public LocalDateTime createdAt;

  public LocalDateTime updatedAt;

}