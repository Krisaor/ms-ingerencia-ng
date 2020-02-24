# ms-ingerencia-ng

Para ejecutar este microservicio, se necesita tener una base de datos MySQL, con usuario root y passwd mysql7752 (estos 
datos pueden modificarse en el archivo application.properties) y una base de datos llamada ingerencia. 

    create database ingerencia;

Una vez realizado este paso, simplemente ejecute el microservicio como una spring boot app y listo. El microservicio creará 
las tablas necesarias y hará los insert correspondiente. Puede ejecutar el task bootrun desde la carpeta root del proyecto.

    ./gradlew bootrun
