# Proyecto 1 - El Ahorcado Univalle

Entregables:
- Mockups de interfaces gráficas.
- Diagrama de Clases.
- Código de Aplicación.
- Evidencia de Ejecución, mediante un video cuyo contenido explique el juego, las características importantes y las fases de construcción del software. Utilice un formato como el del Elevator Pitch https://www.youtube.com/watch?v=2b3xG_YjgvI.

## Abstract
El departamento de educación y aprendizaje de Univalle, requiere construir un software que permita 
aplicar en su proceso de enseñanza, que les permita a los estudiantes adquirir nuevo vocabulario, 
crear estrategias para adivinar cada palabra, hacer deducciones y divertirlos muchísimo.
El jefe del departamento ha descubierto un juego en una página de internet y ha decidido contactar al 
grupo de desarrollo de software de la clase FPOE para que reconstruya el juego, de tal manera que 
se pueda usar como aplicación de escritorio, dado que hay algunos sitios que no tienen conectividad.

La aplicación a desarrollar deberá contar con las mismas funcionalidades de la versión en la web, tales como:
- Jugar
- Instrucciones
- Para qué sirve

Debe incluir tambien:
1. Al iniciar el juego, deberá solicitar el nombre del jugador y deberá permitir seleccionar un listado de temáticas que determinarán las palabras que aparecerán en el momento del juego, por ejemplo: Animales, Colores, Frutas, etc.
2. El usuario deberá determinar el numero de palabras por ronda que desea adivinar, sin embargo, una vez se consuma una palabra el software deberá preguntarle al usuario si desea continuar. La ronda deberá terminar cuando el usuario así lo desee o cuando se hayan consumido la cantidad de palabras que se configuraron al inicio del juego. Si la ronda termina por el consumo del total de las palabras, el juego deberá preguntar si desea ejecutar otra ronda, de ser así, deberá volver a preguntar por la temática de palabras.
3. Una vez iniciado el juego, el software deberá informar por palabra a adivinar, la cantidad de intentos ejecutados, la cantidad de intentos totales, la cantidad de intentos restantes también deberá mostrar cuales letras se han utilizado. En la ronda solo deberá aparecer palabras de la temática configurada.
4. Al finalizar una ronda de palabras, el software deberá desplegar la siguiente estadística:
  - Cantidad de palabras adivinadas y su correspondiente porcentaje.
  - Cantidad de palabras no adivinadas y su correspondiente porcentaje.
5. Al finalizar el juego deberá aparecer la siguiente estadística:
  - Cantidad de rondas realizadas.
  - Numero de ronda en la que el porcentaje de acierto fue mayor y el porcentaje.
  - Numero de ronda en la que el porcentaje de acierto fue menor y el porcentaje.
  - La palabra que más acierto tuvo durante todo el juego.
