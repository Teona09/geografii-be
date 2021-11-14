USE geografii_db;
CREATE TABLE IF NOT EXISTS user_role (
  user_id int NOT NULL,
  role_id int NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user_model(user_id),
  FOREIGN KEY (role_id) REFERENCES role_model(role_id),
  PRIMARY KEY (user_id, role_id)
)