# Práctica Event Publisher

_La finalidad del presente proyecto es poner en practica los temas aprendidos durante el curso de Microservicios.
El proyecto se encuentra conformado por tres microservicios y un cliente que interactuan entre sí para poder tener comunicación asíncrona; gracias al uso de Queues._

_En cuanto a negocio, se trata de la reservación de un cliente en un sitio de servicio y la adquisición de productos._

## Comenzando 🚀
_1.- Clonar el repositorio de GitHub para tener acceso a los proyectos involucrados: https://github.com/humedina/PracticaEventPublisher.git_
_2.- Importar proyectos (Practica-Events-and-Queues, Product-Register-Events y Notifications-Send-Event)._
_2.1.- Abrir su IDE de preferencia (Se recomienda STS3)._
_2.2.- Dar click en File > Import > Maven > Existing Maven Projects > Next > Browse > {directorio_desacarga}/PracticaEventPublisher > Select All > Finish._

Ubica **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_Antes de iniciar, necesitas:_

```
* Tener RabbitMQ
* Tener instalado Java 8
* Tener instalado Maven
```

### Instalación 🔧

_Para la ejecución o instalación de los proyectos, será necesario seguir el siguiente listado de instrucciones:_

_El primer paso es iniciar el servicio de RabbitMQ y/o verificar que este disponible escuchando en el puerto 15672_

```
localhost:15672
```

_El segundo paso consiste en actualizar las dependencias Maven en cada uno de los proyectos._

_El tercer paso es compilar el primer proyecto y para esto es necesario ejecutar el siguiente comando en la ubicación en la que se encuentra el ficehro **pom.xml**_

```
mvn clean package
```
_Para el paso anterior se recomienda compilar el proyecto pero omitir los archivos Test, con el siguiente comando se puede realizar:_

```
mvn clean package -DskipTests
```

_Finalmente, en una terminal dentro de la ruta {tu_directorio}/PracticasEventPublisher/{directorio_del_proyecto}/target, ejecutar el comando siguiente:_

```
java -jar nombre_del_jar_generado.jar
```
_Al ejecutar ésta última instrucción para cada uno de los tres proyectos, se podrá comenzar con la pruebas necesaria._

_**Nota:** Se recomienda ejecutar los archivos Jar en el siguiente orden para poder ir teniendo orden; (Practica-Events-and-Queues, Product-Register-Events y Notifications-Send-Event), aunque no necesariamente tiene que ser así._

## Ejecutando las pruebas ⚙️

_Una ves que los proyectos se encuentran ejecutando, es necesario abrir una nueva ventana de su navegador de preferencia e ingresar a la siguiente URL; **http://localhost:8080/**, al ingresar la url, inmediatamente se deberá visualiazar el formulario o cliente que realizará las peticiones hacía el microservicio que se encargará de registrar clientes._

_El formulario deberá ser llenado con la información solicitada y posteriormente envíarla y confirmar._

_Será así como el primer servicio además de almacenar la información en BD se encargará de publicar un evento sobre si el cliente hará uso de algún producto ofrecido._

_El segundo servicio realizará una tarea similar pero para notificar en caso de que el producto haya sido almacenado y además escuchado por los escuchas._


### Analice las pruebas end-to-end 🔩

_Para validar la correcta ejecución de las pruebas, batará con ir al RabbitMQ y verificar el comportamiento de las **Queues**. Por otro lado se podrá visualizar en la BD la persistencia de la información. También la revisión de las trazas que se loggearon en consola, servirá para validar la funcionalidad._

## Construido con 🛠️

_Las herramientas / stack tecnológico empleado para la elaboración de la práctica, es:_

* [Java 8](https://www.java.com/es/)
* [Maven](https://maven.apache.org/)
* [RabbitMQ](https://www.rabbitmq.com/)

## Autores ✒️

* **Humberto Medina Hernández** - *Desarrollo* - [humedina](https://github.com/humedina)




---
😊
