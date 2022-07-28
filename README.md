<h3>Aplicacion Cine Informatorio 2022</h3>
<hr>

<h5>Objetivo:</h5>
<ul>
<li>
Crear una API Rest que pueda realizar las operaciones de Creación,
Lectura, Actualización, y Eliminación de Recursos (Entidades) de
nuestra aplicación.
</li>
<li>
Poner en práctica y entender los conceptos de BD, Spring Data (JPA),
Rest (solo aspectos básicos de rutas, params y body para poder
interactuar con nuestra API Rest).
</li>
<li>
Aplicar los conceptos de cardinalidades con las anotaciones
@OneToOne, @OneToMany, @ManyToMany .
</li>
<li>
Realizar pruebas y comprobaciones haciendo uso de las herramientas
de POSTMAN y Cliente SQL (DBeaver, Workbench, otros).
</li>
</ul>

<br>
<h5>Escenario:</h5>
<p>En nuestra localidad se ha decidido realizar un evento de Cine
Independiente. Donde productores y directores de cine locales podrán
presentar sus obras que serán evaluadas por un jurado que elegirá a los
ganadores.
Nos han solicitado el desarrollo de una API REST para poder registrar la
información de los participantes y obras. Al certamen le interesa registrar las
obras, directores, categorías (definidas por el certamen) y actores.
</p>
<br>

<h5>Especificaciones:</h5>
<ul>
<li>De las obras/películas/documentales se desea registrar: Nombre (o
Título mejor dicho), descripción, duración (en minutos), director,
categoría (Documental, Animación, etc), Fecha de Alta (o Inscripción) y
actores.</li>
<li>De los directores: Nombre, Apellido, Fecha de Nacimiento, DNI, Fecha
de Alta (o Inscripción)</li>
<li>De categoria: Nombre</li>
<li>De Actores: Nombre, Apellido, Fecha de Nacimiento, DNI.</li>
<li>Las obras/películas/documentales sólo admite 1 director en la
inscripción del certamen.
</li>
<li>Las categorías las define el certamen. No pueden agregarse
obras/películas/documentales que no tengan una categoría existente.</li>
<li>Los actores pueden haber participado en más de 1
obras/películas/documentales inscriptas en el certamen actual.</li>
</ul>

<h5>Como lo arme:</h5>
<p>Para crear la api utilice Swagger, tambien aplique la separacion de los 
entitys en Dto, entity y converter. Ademas el controller se separo en
controller y service.</p>
<p>Para mayor comodidad se utilizo H2 como BD y lombok para crear los 
getter y setter de forma automatica, ademas se utilizo Maven</p>