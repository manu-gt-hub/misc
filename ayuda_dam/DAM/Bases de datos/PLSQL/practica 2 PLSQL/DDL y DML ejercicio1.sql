
/* *** DMSL EJERCICIO 1 *** */

/* *** APARTADO ELIMINACION DE TABLAS Y SECUENCIAS *** */

DROP TABLE ARTICULO CASCADE CONSTRAINTS;
DROP TABLE USUARIO CASCADE CONSTRAINTS;
DROP TABLE PROPUESTA CASCADE CONSTRAINTS;
DROP TABLE ARTPRO CASCADE CONSTRAINTS;
DROP TABLE PEDIDO CASCADE CONSTRAINTS;
DROP TABLE ARTPED CASCADE CONSTRAINTS;
DROP TABLE ERRORES CASCADE CONSTRAINTS;
DROP SEQUENCE S1;
DROP SEQUENCE SEC_ERROR;
DROP SEQUENCE SEC_PEDIDO;

/* *** APARTADO CREACION DE TABLAS Y SECUENCIAS *** */

CREATE TABLE ARTICULO (
  CODART VARCHAR2(5),
  NOMART VARCHAR2(20),
  PRECIO NUMBER(6,2),
  IVA NUMBER(6,2),
  CONSTRAINT PK_ARTICULO PRIMARY KEY (CODART));

CREATE TABLE USUARIO (
  USR VARCHAR2(10),
  PWD VARCHAR2(10),
  PUNTOS NUMBER(3),
  CONSTRAINT PK_USUARIO PRIMARY KEY (USR));

CREATE TABlE PROPUESTA (
  CODPRO VARCHAR2(11),
  USR VARCHAR2(10),
  PRECIO NUMBER(6,2),
  IVA NUMBER(6,2),
  TOTAL NUMBER(6,2),
  FECHA DATE,
  VALIDADA NUMBER(1),
  CONSTRAINT PK_PROPUESTA PRIMARY KEY (CODPRO),
  CONSTRAINT FK_PROPUESTA_USUARIO FOREIGN KEY (USR) REFERENCES USUARIO (USR));


CREATE TABLE ARTPRO (
  CODART VARCHAR2(5),
  CODPRO VARCHAR2(11),
  PROCESADO NUMBER(1),
  CONSTRAINT PK_ARTPRO PRIMARY KEY (CODART,CODPRO),
  CONSTRAINT FK_ARTPRO_ARTICULO FOREIGN KEY (CODART) REFERENCES ARTICULO (CODART),
  CONSTRAINT FK_ARTPRO_PROPUESTA FOREIGN KEY (CODPRO) REFERENCES PROPUESTA (CODPRO));


  
CREATE TABLE PEDIDO (
  CODPED NUMBER(4),
  USR VARCHAR2(10),
  PRECIO NUMBER(6,2),
  IVA NUMBER(6,2),
  TOTAL NUMBER(6,2),
  FECHA DATE,
  VALIDADA NUMBER(1),
  CONSTRAINT PK_PEDIDO PRIMARY KEY (CODPED),
  CONSTRAINT FK_PEDIDO_USUARIO FOREIGN KEY (USR) REFERENCES USUARIO (USR));
  
CREATE TABLE ARTPED (
  CODPED NUMBER(4),
  CODART VARCHAR2(5),
  CONSTRAINT PK_ARTPED PRIMARY KEY (CODPED,CODART),
  CONSTRAINT FK_ARTPED_PEDIDO FOREIGN KEY (CODPED) REFERENCES PEDIDO (CODPED),
  CONSTRAINT FK_ARTPED_ARTICULO FOREIGN KEY (CODART) REFERENCES ARTICULO (CODART));

CREATE TABLE ERRORES(
   CODERROR NUMBER(4),
   FECERROR DATE,
   USR VARCHAR2(10),
   CODPRO VARCHAR2(11),
   CANTART NUMBER(3),
   PRECIOTOT NUMBER(5,2),
   IVA NUMBER(3,2),
   FECPRO DATE,
   CODPED NUMBER(4),
   CANTARTPED NUMBER(3),
   PRECIOTOTART NUMBER(5,2),
   IVAART NUMBER(3,2),
   FECPED DATE,
   CONSTRAINT PK_ERRORES PRIMARY KEY (CODERROR),
   CONSTRAINT FK_ERRORES_USUARIO FOREIGN KEY (USR) REFERENCES USUARIO (USR),
   CONSTRAINT FK_ERRORES_PROPUESTA FOREIGN KEY (CODPRO) REFERENCES PROPUESTA (CODPRO),
   CONSTRAINT FK_ERRORES_PEDIDO FOREIGN KEY (CODPED) REFERENCES PEDIDO (CODPED)
);
CREATE SEQUENCE S1
   MINVALUE 1
   MAXVALUE 999
   START WITH 1
   INCREMENT BY 1;
   
CREATE SEQUENCE SEC_ERROR
   MINVALUE 1
   MAXVALUE 999
   START WITH 1
   INCREMENT BY 1;
   
CREATE SEQUENCE SEC_PEDIDO
   MINVALUE 1
   MAXVALUE 999
   START WITH 1
   INCREMENT BY 1;

-------------------------------------------------------------------------------------------------------------------

/*  *** APARTADO INSERTS  *** */


INSERT INTO ARTICULO (CODART,NOMART,PRECIO,IVA) VALUES ('00001','ART1',0001.01,0.01);
INSERT INTO ARTICULO (CODART,NOMART,PRECIO,IVA) VALUES ('00002','ART2',0002.02,0.02);
INSERT INTO ARTICULO (CODART,NOMART,PRECIO,IVA) VALUES ('00003','ART3',0003.03,0.03);
INSERT INTO ARTICULO (CODART,NOMART,PRECIO,IVA) VALUES ('00004','ART4',0004.04,0.04);
INSERT INTO ARTICULO (CODART,NOMART,PRECIO,IVA) VALUES ('00005','ART5',0005.05,0.05);
INSERT INTO ARTICULO (CODART,NOMART,PRECIO,IVA) VALUES ('00006','ART6',0006.06,0.06);
INSERT INTO ARTICULO (CODART,NOMART,PRECIO,IVA) VALUES ('00007','ART7',0007.07,0.07);
INSERT INTO ARTICULO (CODART,NOMART,PRECIO,IVA) VALUES ('00008','ART8',0008.08,0.08);
INSERT INTO ARTICULO (CODART,NOMART,PRECIO,IVA) VALUES ('00009','ART9',0009.09,0.09);
COMMIT;


INSERT INTO USUARIO (USR,PWD,PUNTOS) VALUES ('USU1','USU1',0);
INSERT INTO USUARIO (USR,PWD,PUNTOS) VALUES ('USU2','USU2',0);
INSERT INTO USUARIO (USR,PWD,PUNTOS) VALUES ('USU3','USU3',0);
INSERT INTO USUARIO (USR,PWD,PUNTOS) VALUES ('USU4','USU4',0);
INSERT INTO USUARIO (USR,PWD,PUNTOS) VALUES ('USU5','USU5',0);
COMMIT;


INSERT INTO PROPUESTA (CODPRO,USR,PRECIO,IVA,TOTAL,FECHA,VALIDADA) VALUES ('00125042013','USU1',0001.01,0.01,1.02,'25/04/2013',1);
INSERT INTO PROPUESTA (CODPRO,USR,PRECIO,IVA,TOTAL,FECHA,VALIDADA) VALUES ('00225042013','USU2',0006.06,0.06,6.12,'25/04/2013',0);
INSERT INTO PROPUESTA (CODPRO,USR,PRECIO,IVA,TOTAL,FECHA,VALIDADA) VALUES ('00325042013','USU2',0008.08,0.08,8.16,'25/04/2013',0);
INSERT INTO PROPUESTA (CODPRO,USR,PRECIO,IVA,TOTAL,FECHA,VALIDADA) VALUES ('00425042013','USU1',0011.01,0.11,11.12,'25/04/2013',0);
INSERT INTO PROPUESTA (CODPRO,USR,PRECIO,IVA,TOTAL,FECHA,VALIDADA) VALUES ('00525042013','USU3',0001.01,0.01,1.02,'25/04/2013',1);
INSERT INTO PROPUESTA (CODPRO,USR,PRECIO,IVA,TOTAL,FECHA,VALIDADA) VALUES ('00625042013','USU4',0002.02,0.02,2.04,'25/04/2013',1);
COMMIT;


INSERT INTO ARTPRO (CODART,CODPRO,PROCESADO) VALUES ('00001','00125042013',1);
INSERT INTO ARTPRO (CODART,CODPRO,PROCESADO) VALUES ('00001','00225042013',0);
INSERT INTO ARTPRO (CODART,CODPRO,PROCESADO) VALUES ('00002','00225042013',0);
INSERT INTO ARTPRO (CODART,CODPRO,PROCESADO) VALUES ('00003','00225042013',0);
INSERT INTO ARTPRO (CODART,CODPRO,PROCESADO) VALUES ('00001','00325042013',0);
INSERT INTO ARTPRO (CODART,CODPRO,PROCESADO) VALUES ('00007','00325042013',0);
INSERT INTO ARTPRO (CODART,CODPRO,PROCESADO) VALUES ('00003','00425042013',0);
INSERT INTO ARTPRO (CODART,CODPRO,PROCESADO) VALUES ('00008','00425042013',0);
INSERT INTO ARTPRO (CODART,CODPRO,PROCESADO) VALUES ('00001','00525042013',1);
INSERT INTO ARTPRO (CODART,CODPRO,PROCESADO) VALUES ('00002','00625042013',1);
COMMIT;

