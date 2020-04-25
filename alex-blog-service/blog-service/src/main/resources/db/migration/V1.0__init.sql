CREATE TABLE category
(
  id VARCHAR(6) PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  parentId VARCHAR(6),
  description VARCHAR(45),
  rank NUMERIC NOT NULL
);

CREATE UNIQUE INDEX category_id_name
ON category(id, name);
CREATE INDEX category_parentId
ON category(parentId, rank);