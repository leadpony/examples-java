DROP DATABASE IF EXISTS testdb;
CREATE DATABASE testdb CHARACTER SET=utf8;

CREATE USER 'dbuser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL ON testdb.* to 'dbuser'@'localhost';  
