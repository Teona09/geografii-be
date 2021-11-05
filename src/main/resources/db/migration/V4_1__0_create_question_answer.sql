CREATE TABLE IF NOT EXISTS question_answer (
  question_id int NOT NULL,
  answer_id int NOT NULL,
  FOREIGN KEY (question_id) REFERENCES question_model(question_id),
  FOREIGN KEY (answer_id) REFERENCES answer_model(answer_id),
  PRIMARY KEY (question_id, answer_id)
)