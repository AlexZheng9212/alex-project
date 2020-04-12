package com.alex.common.db.postgres.model;

import java.util.Date;
import java.util.UUID;

public class BaseEntity {
    public UUID id;
    public Date createdAt;
    public Date updatedAt;
}