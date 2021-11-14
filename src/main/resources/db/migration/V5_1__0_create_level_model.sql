USE geografii_db;
CREATE TABLE IF NOT EXISTS level_model (
  level_id int NOT NULL AUTO_INCREMENT,
  region varchar(50) NOT NULL,
  maximum_points int NOT NULL,
  PRIMARY KEY (level_id)
)