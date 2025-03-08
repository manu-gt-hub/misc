
/*APARTADO A*/

SET SERVEROUTPUT ON FORMAT WORD_WRAPPED;
DECLARE  /*area de declaraciones*/
    SNIF  EMPLEADO.NIF%TYPE; /*Declaracion de variables shaciendo uso de TYPE para */
    CADENA EMPLEADO.NIF%TYPE;/*declararlas de acuerdo con el tipo de dato de la tabla pertinente*/
    COINCIDENCIA EMPLEADO.NIF%TYPE;
    IDEINFOR INFORME.IDE%TYPE;
    FECERROR INFORME.FECHA%TYPE;
    NOMBRE EMPLEADO.NOM%TYPE;
    APELLIDO EMPLEADO.APE%TYPE;
    CALLE EMPLEADO.DIR%TYPE;
    TEL EMPLEADO.TEL%TYPE;
    NUMERO NUMBER;
    CONT NUMBER(1):=0; /*declaracion y asignaciones*/
    CONNUM NUMBER(1):=0;
    CONLET NUMBER(1):=0;
    POS NUMBER(1);
    CAR VARCHAR(1);
    LET VARCHAR(1);
    
BEGIN  /*inicio del programa*/
   SNIF:='47465176F'; /*asignaciones*/
   NOMBRE:='daniel';
   APELLIDO:='ape7';
   CALLE:='calle4';
   TEL:='23145';

FOR POS IN 1..LENGTH(SNIF) LOOP  /*bucle for de 1 a longitud de la cadena SNIF*/

   CAR:=SUBSTR(SNIF,POS,1);  /*usamos SUBSTRING para ir recortando la cadena SNIF y compararla*/
   IF(CAR>='0' AND CAR<='9') THEN  /*caracter a caracter*/
      CONNUM:=CONNUM+1;
   END IF;
   CAR:=UPPER(CAR);   /*pasamos el caracter a mayusculas para compararlo*/
   IF(CAR>='A' AND CAR<='Z' AND (POS=8 OR POS=9)) THEN /*verificamos que el caracter sea letra y este*/
      CONLET:=CONLET+1;                                /*en la ultima posicion*/
      
   END IF;
END LOOP;

IF((CONNUM=7 OR CONNUM=8)  AND CONLET=1) THEN  /*si la verificacion fue correcta entramos en el if*/
    SNIF:=UPPER(SNIF);  /*ponemos en mayuscula todos los caracteres de la cadena SNIF*/
    SNIF:=LTRIM(SNIF,'0');  /*eliminamos todos los '0' que haya en SNIF empezando por la izquierda*/
    CADENA:=RTRIM(SNIF,CAR);  /*eliminamos la letra (CAR) de SNIF empezando por la derecha*/
    NUMERO:=TO_NUMBER(CADENA);  /*Convertimos el resto de la cadena SNIF  a numero*/
    NUMERO:=MOD(NUMERO,23);  /*hacemos el modulo 23 del numero que habiamos conseguido*/
    LET:=SUBSTR('TRWAGMYFEDXBNJZSQVHLCKE',NUMERO+1,1);  /*sacamos la letra pertinente de acuerdo con el modulo*/
    IF(LET=CAR) THEN   /*comparamos dicha letra con la que tenemos en el dni de SNIF*/
         SELECT COUNT(*) INTO (CONT) FROM EMPLEADO WHERE (NIF=SNIF);  /*seleccionamos el numero de coincidencias
                                                               de la tabla empleado con SNIF*/
         
         IF(CONT>=1) THEN   /*si hubo alguna coincidencia*/  
             DBMS_OUTPUT.PUT_LINE('YA EXISTE EL DNI');
             SELECT SYSDATE INTO FECERROR FROM DUAL;  /*seleccionamos la fecha actual*/
             SELECT S1INFORME.NEXTVAL INTO IDEINFOR FROM DUAL;  /*ejecutamos la secuencia para obetener +1 en IDE*/
             INSERT INTO INFORME (IDE,TIPO_ERR,DESC_ERR,FECHA) VALUES (IDEINFOR,'TIPO1','YA EXISTE EL DNI',FECERROR);
             /*hacemos insert en la tabla informe*/
         ELSE  /*si no hubieron coincidencias (el DNI es valido)*/
            NOMBRE:=UPPER(NOMBRE);  /*ponemos todos los campos a mayusculas*/
            APELLIDO:=UPPER(APELLIDO);
            CALLE:=UPPER(CALLE);
            TEL:=UPPER(TEL);
            INSERT INTO EMPLEADO (NIF,NOM,APE,DIR,TEL) VALUES (SNIF,NOMBRE,APELLIDO,CALLE,TEL);  
            /*hacemos el insert en la tabla empleado*/
            DBMS_OUTPUT.PUT_LINE('DNI VALIDO');  /*salida por pantalla*/
         END IF;
    ELSE
        DBMS_OUTPUT.PUT_LINE('LETRA INCORRECTA');
        SELECT SYSDATE INTO FECERROR FROM DUAL;
        SELECT S1INFORME.NEXTVAL INTO IDEINFOR FROM DUAL;
        INSERT INTO INFORME (IDE,TIPO_ERR,DESC_ERR,FECHA) VALUES (IDEINFOR,'TIPO2','LETRA INCORRECTA',FECERROR);
    END IF;
ELSE

       SELECT S1INFORME.NEXTVAL INTO IDEINFOR FROM DUAL;
       SELECT SYSDATE INTO FECERROR FROM DUAL;
       INSERT INTO INFORME (IDE,TIPO_ERR,DESC_ERR,FECHA) VALUES (IDEINFOR,'TIPO3','EL DNI DEBE TENER 7 U 8 NUMEROS Y 1 LETRA',FECERROR);
       DBMS_OUTPUT.PUT_LINE('EL DNI DEBE TENER ENTRE 7 Y 8 NUMEROS Y UNA LETRA AL FINAL');
END IF;
COMMIT;
END;
/