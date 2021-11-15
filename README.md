<h1 align="center">
  <a href="https://github.com/Zettlr/Zettlr">
    <img src="https://raw.githubusercontent.com/aandradeb/peixePOP/main/acuario-tiburon.jpg" alt="peixePOP"/>
  </a>
  <br/>
  peixePOP
</h1>

El repositorio se ha creado para poder desarrollar un trabajo de la asignatura Acceso a Datos.
Se puede clonar y examinar el código. Si los cambios se consideran oportunos, se hará merge con la rama principal.

Integrantes:
  - [Emilio Devesa](https://github.com/emilio-devesa)
  - [Yudaisy Ramos](https://github.com/YudaRamos)
  - [Rocío Seoane](https://github.com/rocioseoane)
  - [Gianny Uffo](https://github.com/uffogianny) 
  - [Paulo Vazquez](https://github.com/) 
  - [Angel Andrade](https://github.com/aandradeb) 
  - [Miguel Jaimes](https://github.com/mlinares1998)
  - [José Bayona](https://github.com/jguilmar)
  


------------


### Problema a resolver.
En la ciudad en la que reside nuestra empresa, se está construyendo un complejo multidisciplinario en la zona norte de la península, teniendo como eje central grandes acuarios. Será necesario la gestión de los datos del personal, de los clientes y de la distribución de animales(peces) y plantas en cuanto a la ubicación de sus respectivos estanques y sus salas.
A mayores, en uno de sus locales, se establecerá una tienda de peces y alimentación de animales acuáticos, artículos de acuariofilia y mantenimiento de los mismos.
Tras varias horas charlando acerca de los problemas que pueden surgir, y dado el manejo del inventario de especies y el gran volumen de ventas que se preveé, se nos ha encargado la implementación de un software de gestión de personal, inventario, ventas y finanzas en las cajas de los mismos; suponiendo esto, un gran reto para nosotros.
     


------------


### Definición.
Se va a desarrollar un software para la gestión del inventario de las especies, de la tienda, de clientes y de los trabajadores del acuario `PeixePop`.
1. Gestión de inventario de especies: 
    - Salas: Constan de un código, nombre y tipo según su exhibición o su localización.
    - Estanques: Constan de un código, nombre, tipo según su localización y una sala asignada.
    - Tiburones: Consta de un código, nombre, tamaño, y un estanque asignado.
    - Plantas: Consta de un código, medio de vida específico, nombre, un estanque y sala asignados según su medio de vida. 
 
2. Gestión de trabajadores:
    La tienda dispone de varios dependientes identificados por un código de trabajador. Todos los trabajadores tienen un salario que se establece según los criterios de la empresa. Además de contar con un nombre, dirección y teléfono.    

3. Gestión de tienda: En nuestra tienda contamos con varios tipos de artículos: animales y plantas acuáticas, alimentos, peceras y accesorios. Cada artículo dispone de un contador de stock y cuando se realiza una venta, el dependiente comprueba el stock: si hay stock suficiente del artículo solicitado, se continúa con el proceso de venta pero, en el caso de que no haya stock se ofrece crear un pedido. Para realizar los pedidos, se necesita registrar al cliente en el sistema. 
    Además debe estar registrado si solicitan factura de la compra. Los pedidos y las facturas se identifican con un código y contienen los datos del cliente, los artículos solicitados, la cantidad, el precio unitario y el importe total.

4. Gestión de clientes: Los clientes quedarán registrados por su código de cliente, nombre, dirección y teléfono.



------------


### Almacenamiento persistente de datos:
Para el acceso a datos de nuestro acuario en un principio hicimos uso de `ficheros.txt`, ahora vamos a trabajar con [PHP](https://www.php.net) y [MySQL](https://www.mysql.com)  utilizando [Doker](https://www.docker.com). Lo básico para cualquier desarrollador en PHP es tener un ambiente de desarrollo local con las mismas versiones del servidor de producción.
Existen herramientas como `MAMP` o `XAMPP` para este trabajo pero dependen del sistema operativo utilizado, sólo permiten una versión de los servicios esto genera problemas de compatibilidad.

#### Doker al rescate
La forma más sencilla de crear ambientes de desarrollo es con Docker, donde utilizamos el archivo `docker-compose.yml` para configurar las características (versiones, puertos, variables de entorno, etc) de los servicios que necesitamos.

#### Requerimientos

* [Docker Desktop](https://www.docker.com/products/docker-desktop)

#### Configurar el ambiente de desarrollo

Puedes utilizar la configuración por defecto, pero en ocasiones es recomendable modificar la configuración para que sea igual al servidor de producción. La configuración se ubica en el archivo `.env` con las siguientes opciones:

* `PHP_VERSION` versión de PHP ([Versiones disponibles de PHP](https://github.com/docker-library/docs/blob/master/php/README.md#supported-tags-and-respective-dockerfile-links)).
* `PHP_PORT` puerto para servidor web.
* `MYSQL_VERSION` versión de MySQL([Versiones disponibles de MySQL](https://hub.docker.com/_/mysql)).
* `MYSQL_USER` nombre de usuario para conectarse a MySQL.
* `MYSQL_PASSWORD` clave de acceso para conectarse a MySQL.
* `MYSQL_DATABASE` nombre de la base de datos que se crea por defecto.

#### Instalar el ambiente de desarrollo
Los contenedores se crean con el comando:

```bash
docker-compose up -d
```
Los contenedores se manejan con los comandos:

```bash
docker-compose start    # Iniciar los contenedores
docker-compose stop     # Detener los contenedores
docker-compose down     # Detener y eliminar los contenedores
```


#### Docker-compose.yml
![doker_compose](https://raw.githubusercontent.com/aandradeb/peixePOP/main/doker-compose-yml.jpg)



#### PhpMyAdmin
![phpMyAdmin](https://raw.githubusercontent.com/aandradeb/peixePOP/main/phpMyAdmin.jpg)



#### Conexión con Docker
![Doker](https://raw.githubusercontent.com/aandradeb/peixePOP/main/doker.jpg)



### Modelo entidad-relación Base de Datos utilizada.
![mod_ent_rel](https://raw.githubusercontent.com/aandradeb/peixePOP/main/entidad-relacion.jpg)

     
