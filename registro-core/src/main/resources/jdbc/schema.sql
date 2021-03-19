/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  neira
 * Created: Mar 18, 2021
 */
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nombre varchar(50) DEFAULT NULL,
  apellido varchar(50) DEFAULT NULL,
  procesado boolean DEFAULT NULL,
  PRIMARY KEY (id)
);
