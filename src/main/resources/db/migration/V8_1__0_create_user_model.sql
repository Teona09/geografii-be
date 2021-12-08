USE geografii_db;
CREATE TABLE IF NOT EXISTS user_model (
  user_id int NOT NULL AUTO_INCREMENT,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  password TEXT NOT NULL,
  usable_points int NOT NULL,
  PRIMARY KEY (user_id)
)