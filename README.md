#  Control Académico

Este proyecto es una aplicación de escritorio desarrollada en **Java**, utilizando **Maven** como gestor de dependencias y **MySQL** como base de datos.  
Su objetivo principal es gestionar la información académica de una institución, incluyendo estudiantes, clases, docentes y asistencias.


##  Características principales

- Registro, consulta, actualización y eliminación de **estudiantes**.  
- Gestión de **docentes** y **materias**.  
- Control de **asistencia** por clase y fecha.  
- Administración de **clases**, con relación entre estudiantes y docentes.  
- Conexión a **MySQL** mediante JDBC.


 Configuración de la conexión

El archivo `DBConnection.java` contiene los parámetros para conectarse a la base de datos:

```java
private static final String URL = "jdbc:mysql://localhost:3306/control_academico";
private static final String USER = "root";
private static final String PASSWORD = "yosmanmu2021";
