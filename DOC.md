# Instituto Tecnológico de Costa Rica
#### Escuela de Ingeniería en Computación

#### Primer Proyecto Programado
#### Diseño de Software
##### Profesor: Diego Munguía
##### Estudiantes:
###### Diego Acuña Cerdas - 2018109507
###### Natán Fernández de Castro - 2017105774
###### Dylan González Quesada- 2017118729
###### Kenneth Rodriguez Murillo - 2018132752
###### Joel Vega Godinez - 2018163840


---

#### Diseño de Software
El proyecto consiste en diseñar y crear un servidor web capaz de comunicarse con diferentes navegadores a través del protocolo HTTP. Dicho protocolo es esencial para el desarrollo de software web. Además, con este proyecto los estudiantes podrán saber el funcionamiento básico de los servidores web, como lo son nginx o Apache. Además, se reforzará el conocimiento de los principios de diseño SOLID.

# Consideraciones para compilación y ejecución del Código
* Utilizar sistema operativo Linux
* El programa recibe 3 argumentos por parámetro <numeroPuerto> <raizArchivosDeRecurso> <rutaArchivoExtensionesMime>
* Comando para compilación
```sh
$ ./gradle clean build
```
* Comando para ejecución
```sh
$ ./gradlew run --args <numeroPuerto> <raizArchivosDeRecurso> <rutaArchivoExtensionesMime>
```
* Cuando se requiera finalizar la compilación presionar `CTRL + T`
* Si se compila y ejecuta en **IntelliJ IDEA** 
    * Presionar `ALT + SHIFT + F10`
    * Seleccionar `Edit Configurations`
    * En la sección de texto `Program arguments` ingresar los 3 parámetros para ejecución


## Diagramas
![Diagrama Clases HTTP Server SOLID](https://github.com/IC-6821/ic-6821-2020i-p1-los-solidos/blob/developer/Diagramas/Diagrama_de_Clases.png)

![Diagrama Secuencia 1 HTTP Server SOLID](https://github.com/IC-6821/ic-6821-2020i-p1-los-solidos/blob/developer/Diagramas/Secuencia1.png)

![Diagrama Secuencia 2 HTTP Server SOLID](https://github.com/IC-6821/ic-6821-2020i-p1-los-solidos/blob/developer/Diagramas/Diagrama_Secuencias_2.png)


