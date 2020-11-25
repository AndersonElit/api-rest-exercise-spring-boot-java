CREATE PACKAGE procedimientos_empresas
IS
    PROCEDURE insertar_empresa(empresa IN VARCHAR2);
    PROCEDURE eliminar_empresa(id_emp IN NUMBER);
    PROCEDURE editar_empresa(id_emp IN NUMBER, nuevo_nombre IN VARCHAR2);
END;
/
CREATE PACKAGE BODY procedimientos_empresas
IS

    --insertar nueva empresa
    FUNCTION insertar_empresa (nombre_empresa VARCHAR2)
    RETURN VARCHAR2
    IS
        respuesta VARCHAR2(100);
    BEGIN
        INSERT INTO empresas (nombre) VALUES (nombre_empresa);
        respuesta := 'La empresa ' || nombre_empresa || ' se inserto con exito';
        RETURN respuesta;
    EXCEPTION
        --ORA-00001: restricción única (SYSTEM.SYS_C0011233) violada
        WHEN DUP_VAL_ON_INDEX THEN
            respuesta := 'La empresa ' || nombre_empresa || ' ya existe.';
            RETURN respuesta;
    END insertar_empresa;
    
    PROCEDURE insertar_empresa(empresa IN VARCHAR2)
    AS
        respuesta VARCHAR2(100);
    BEGIN
         respuesta := insertar_empresa(empresa);
         DBMS_OUTPUT.PUT_LINE(respuesta);
    END insertar_empresa;
    
    --eliminar empresa
    FUNCTION eliminar_empresa(id_emp NUMBER) RETURN VARCHAR2
    --eliminar empresa metodo 2(exceptios)
    IS
        integrity_err EXCEPTION;
        PRAGMA EXCEPTION_INIT (integrity_err, -2292);
        contar_e NUMBER;
        respuesta VARCHAR2(100);
    BEGIN
        --eliminar empresa
        SELECT COUNT(*) INTO contar_e FROM empresas WHERE id_empresa = id_emp;
        IF contar_e = 0 THEN
            respuesta := 'la empresa no existe';
            RETURN respuesta;
        ELSE
            DELETE FROM empresas WHERE id_empresa = id_emp;
            respuesta := 'La empresa se elimino de la tabla.';
            RETURN respuesta;
        END IF;
    EXCEPTION
        --ORA-02292: restricción de integridad (SYSTEM.SYS_C0011234) violada - registro secundario encontrado
        WHEN integrity_err THEN
            respuesta := 'no se pudo eliminar la empresa, hay usuario(s) asociados a esta.';
            RETURN respuesta;
    END eliminar_empresa;
    
    PROCEDURE eliminar_empresa(id_emp IN NUMBER)
    AS
        respuesta VARCHAR2(100);
    BEGIN
        respuesta := eliminar_empresa(id_emp);
        DBMS_OUTPUT.PUT_LINE(respuesta);
    END eliminar_empresa;
    
    --editar empresa
    FUNCTION editar_empresa(id_emp NUMBER, nuevo_nombre VARCHAR2) RETURN VARCHAR2
    IS
        respuesta VARCHAR2(250);
    BEGIN
        --actualizar nombre
        UPDATE empresas SET nombre =  nuevo_nombre WHERE id_empresa = id_emp;
        respuesta := 'la empresa fue actualizada';
        RETURN respuesta;
    EXCEPTION
        --ORA-00001: restricción única (SYSTEM.SYS_C0011233) violada
        WHEN DUP_VAL_ON_INDEX THEN
            respuesta := 'La empresa ' || nuevo_nombre || ' ya se encuentra en la tabla.';
            RETURN respuesta;
        WHEN NO_DATA_FOUND THEN
            respuesta := 'la empresa no existe.';
            RETURN respuesta;
    END editar_empresa;
    
    PROCEDURE editar_empresa(id_emp IN NUMBER, nuevo_nombre IN VARCHAR2)
    AS
        respuesta VARCHAR2(100);
    BEGIN
        respuesta := editar_empresa(id_emp, nuevo_nombre);
        DBMS_OUTPUT.PUT_LINE(respuesta);
    END editar_empresa;
    
END;