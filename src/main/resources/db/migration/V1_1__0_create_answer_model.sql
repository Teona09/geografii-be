CREATE TABLE IF NOT EXISTS answer_model (
  answer_id int NOT NULL AUTO_INCREMENT,
  text varchar(250) NOT NULL,
  is_correct_answer bool NOT NULL,
  PRIMARY KEY (answer_id)
)