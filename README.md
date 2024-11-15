# CLON DE TWITTER

## Requisitos


1. Tener instalado java en la version 17.
2. Tener instalado maven 3.9.
3. Tener instalado postgreSQL
4. Crear una base de datos con nombre `twitter`

## Instalación

1. Clonar el repositorio
2. Configurar el archivo `application.properties` que esta en la ruta src/main/resources/application.properties
3. Dentro de `application.properties`, en `spring.datasource.username` colocar el username de su posgreSQl, lo mismo con la contraseña en `spring.datasource.password`
4. Ejecutar el archivo `TwitterCloneApplication`


*Se crearan todas las tablas de este proyecto en la base de datos*


## Estructura de la base de datos


![Mi Imagen](assets/twitter_bd.png)