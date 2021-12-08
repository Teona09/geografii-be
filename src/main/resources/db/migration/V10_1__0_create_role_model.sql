USE geografii_db;
CREATE TABLE IF NOT EXISTS role_model (
  role_id int NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (role_id)
);

INSERT INTO role_model (name) VALUES ('admin');
INSERT INTO role_model (name) VALUES ('basic');