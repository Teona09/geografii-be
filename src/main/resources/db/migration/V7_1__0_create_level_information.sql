CREATE TABLE IF NOT EXISTS level_information (
  level_id int NOT NULL,
  information_id int NOT NULL,
  FOREIGN KEY (level_id) REFERENCES level_model(level_id),
  FOREIGN KEY (information_id) REFERENCES information_model(information_id),
  PRIMARY KEY (level_id, information_id)
)