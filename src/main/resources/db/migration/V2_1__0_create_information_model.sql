CREATE TABLE IF NOT EXISTS information_model (
  information_id int NOT NULL AUTO_INCREMENT,
  image_url varchar(250) NOT NULL,
  text varchar(250) NOT NULL,
  PRIMARY KEY (information_id)
)