DROP TABLE IF EXISTS userfile;
 
CREATE TABLE userfile (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  fname VARCHAR(250) NOT NULL,
  uname VARCHAR(250) NOT NULL,
  pword VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO userfile (fname, uname, pword) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');