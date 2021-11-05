CREATE TABLE IF NOT EXISTS question_model (
  question_id int NOT NULL AUTO_INCREMENT,
  text varchar(250) NOT NULL,
  hint varchar(250) NOT NULL,
  points int NOT NULL,
  PRIMARY KEY (question_id)
)