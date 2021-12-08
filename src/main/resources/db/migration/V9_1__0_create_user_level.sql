USE geografii_db;
CREATE TABLE IF NOT EXISTS user_level (
  user_id int NOT NULL,
  level_id int NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user_model(user_id),
  FOREIGN KEY (level_id) REFERENCES level_model(level_id),
  PRIMARY KEY (user_id, level_id)
)