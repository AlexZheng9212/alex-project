CREATE TABLE blog_user
(
  id UUID PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  nick_name VARCHAR(30) NOT NULL,
  birthday TIMESTAMP NOT NULL,
  cover VARCHAR(100),
  pwd VARCHAR(64) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);
CREATE UNIQUE INDEX blog_user_id
ON blog_user(id);
CREATE UNIQUE INDEX blog_user_nickName
ON blog_user(nick_name);

CREATE TABLE blog_category
(
  id VARCHAR(6) PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  parent_id VARCHAR(6),
  description VARCHAR(45),
  rank NUMERIC NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);
CREATE UNIQUE INDEX blog_category_id
ON blog_category(id);
CREATE UNIQUE INDEX blog_category_name
ON blog_category(name);
CREATE INDEX blog_category_parentId
ON blog_category(parent_id);
CREATE INDEX blog_category_rank
ON blog_category(rank);


CREATE TABLE blog_article
(
  id UUID PRIMARY KEY,
  title
);