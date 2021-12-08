USE geografii_db;
CREATE TABLE IF NOT EXISTS level_question (
  level_id int NOT NULL,
  question_id int NOT NULL,
  FOREIGN KEY (level_id) REFERENCES level_model(level_id),
  FOREIGN KEY (question_id) REFERENCES question_model(question_id),
  PRIMARY KEY (level_id, question_id)
)