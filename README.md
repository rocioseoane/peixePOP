<div id="top"></div>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/FlagshipDev/peixePOP">
    <img src="https://raw.githubusercontent.com/aandradeb/peixePOP/main/acuario-tiburon.jpg" alt="peixePOP"/>
  </a>

  <h3 align="center">PeixePOP - FlagshipDev Fork</h3>

  <p align="center">
    <br />
    <a href="https://github.com/FlagshipDev/peixePOP"><strong>Explore the docs »</strong></a>
    <br />
    <br />
  </p>
</div>



<!-- ABOUT THE PROJECT -->
## ¿Que es una API REST?

[![API-REST][product-screenshot]](https://github.com/FlagshipDev/peixePOP)

Las API son conjuntos de definiciones y protocolos que se utilizan para diseñar e integrar el software de las aplicaciones. Suele considerarse como el contrato entre el proveedor de información y el usuario, donde se establece el contenido que se necesita por parte del consumidor (la llamada) y el que requiere el productor (la respuesta).

Las características de la arquitectura REST brindan una serie de beneficios a las aplicaciones que utilizan este concepto.

Características:
* Separación entre cliente y servidor:
    Esto es importante para proteger el almacenamiento de datos, ya que no existe un tratamiento de las reglas comerciales, es decir, solo se intercambia informaciones sea para recuperar datos, o para insertar o eliminar nuevos registros.
* Más visibilidad, confiabilidad y escalabilidad:
    Debido a la separación cliente / servidor, hay mucha más facilidad durante el desarrollo de la aplicación. Esto se debe a que se puede escalar fácilmente, ya que no hay dificultad para vincular recursos.
* Multiplataforma:
    Las requisiciones HTTP realizadas en API Rest devuelven datos en formato JSON. Cabe mencionar que existen otros posibles formatos de retorno, como XML, sin embargo, JSON es el más utilizado. Por lo tanto, la mayoría de los sitios que trabajan con este modelo reciben este formato de datos.
    <b>Esta característica es fundamental para el desarrollo de aplicaciones multiplataforma<b>. Eso se debe a que, al recibir los datos en este formato, la camada front-end de la aplicación es capaz de realizar el tratamiento adecuado para mostrar los resultados según el tipo de dispositivo utilizado.


<p align="right"><a href="#top">Volver al inicio</a></p>



### Recursos utilizados

Esta sección enumera los frameworks/bibliotecas principales utilizados para el proyecto.

* Gestor de proyectos - [Maven](https://maven.apache.org)
* Lenguaje - [Java](https://www.java.com/es/)
* Framework - [Spring Boot](https://spring.io/projects/spring-boot)

<p align="right"><a href="#top">Volver al inicio</a></p>


<!-- GETTING STARTED -->
## Explicación sencilla del funcionamiento de la API-REST

Java Spring Boot es una de las herramientas principales del ecosistema de desarrollo web backend con Java. Con Spring Boot nos olvidamos de tener que desplegar 
artefactos Jar o War de manera independiente, porque nos provee con una serie de contenedores web servlet para que se despliegue nuestra aplicación automáticamente solo con
un "Run".

 <b>Jerarquía de archivos y clases</b>
 La jerarquía seguida para el correcto funcionamiento y orden de la aplicación es la siguiente:
<pre><code>+- App
     +- App.java
     |
     +- Cliente
     |   +- Cliente.java
     |   +- ClienteController.java
     |   +- ClienteNotFoundAdvice.java
     |   +- ClienteNotFoundException.java
     |   +- ClienteRepository.java
     |   +- ClienteService.java&gt;
</code></pre>
  
Tenemos un paquete principal "App", con la clase main de la aplicación. Es importante que todo el código esté jerárquicamente por debajo del paquete principal "App", sino, Spring no identificará los controladores y servicios.
El paquete Cliente mostrado anteriormente constituye el modelo a seguir para implementar nuevas tablas y controladores de estas de la API.

Ahora bien, ¿Que hacen todas esas clases?

  * Cliente.java - Es un modelo de la entidad. Es básicamente una clase que plasma de manera exacta los componentes de nuestra tabla de la base de datos.
  * ClienteRepository.java - Es un interfaz que extienda "JpaRepository", la cual nos incluye todas las queries SQL de un CRUD*.
  * ClienteController.java - Es el controlador que gestiona las peticiones HTTP a nuestra aplicación.
  * ClienteService.java - Es la clase donde generamos los métodos con las queries que no vienen por defecto en el repository. En muchos casos estará vacía, ya que no siempre es                            necesario implementar nuevos consultas SQL.
  * ClienteNotFoundAdvice.java y ClienteNotFoundException.java - Son las excepciones que saltan en caso de que la petición de un resultado no esperado. Ejemplo: Se pide un                                                                       cliente según un código inválido => Saltaría una excepción "Client {codigo} not found".
  

<p align="right"><a href="#top">Volver al inicio</a></p>

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right"><a href="#top">Volver al inicio</a></p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/FlagshipDev/peixePOP.svg?style=for-the-badge
[contributors-url]: https://github.com/FlagshipDev/peixePOP/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/FlagshipDev/peixePOP.svg?style=for-the-badge
[forks-url]: https://github.com/FlagshipDev/peixePOP/network/members
[stars-shield]: https://img.shields.io/github/stars/FlagshipDev/peixePOP.svg?style=for-the-badge
[stars-url]: https://github.com/FlagshipDev/peixePOP/stargazers
[issues-shield]: https://img.shields.io/github/issues/FlagshipDev/peixePOP.svg?style=for-the-badge
[issues-url]: https://github.com/FlagshipDev/peixePOP/issues
[license-shield]: https://img.shields.io/github/license/FlagshipDev/peixePOP.svg?style=for-the-badge
[license-url]: https://github.com/FlagshipDev/peixePOP/blob/master/LICENSE.txt
[product-screenshot]: https://www.astera.com/wp-content/uploads/2020/01/rest.png
