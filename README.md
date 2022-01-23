# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---
#Aspectos Generales
- Este programa hace uso de Java para implementar el Proyecto Scrabble que consiste en el aprendizaje y buen uso de conceptos y metodologías de diseño orientada a objetos en un análogo a la funcionalidad de Scratch.

- Estado : El proyecto está en proceso de actualización, donde cada entrega no entorpece el hilo de la anterior pero es un avance de esta.

# Uso
Para que usted pueda correr el repositorio es necesario clonarlo en su terminal con git: 

```sh
$ cd dir\
$ git clone git@github.com:CC3002-Metodologias/scrabble-mariajmellado.git
```

Una vez clonado el repositorio es necesario abrir [IntelliJ IDEA][df1] y confirmar que se tiene Gradle (Settings/Plugins -> Search: Gradle) habilitado.
Confirmado lo anterior, puede proceder a abrir el programa a través de IntelliJ IDEA: File-> New-> Project from Existing Sources 
una vez aquí buscamos la dirección de nuestro directorio con nombre `scrabble-mariajmellado`, seleccionamos el archivo `scrabble-mariajmellado/build.gradle.kts` y aceptamos el "Import Gradle Project".

# Parte N°1 del Proyecto Scrabble; Tipos Scrabble
Se implementan las clases que hacen referencia a los tipos de Scrabble;
1) TipoString 
2) TipoBoolean
3) TipoNumeroInt
4) TipoNumeroFloat
5) TipoNumeroBinario

Se crean las clases abstractas que cubren categorias como sigue:
- AbstractNumero: Extendida por 3), 4) y 5).
- AbstractTipo: Extendida por 1),2) y AbstractNumero.

Se crean las interfaces:
- INumero: Implementada por AbstractNumero.
- ITipo: Implementada por AbstractTipo.
- IRelacionBinarioInt: Implementada por 3) y 5).
- IRelacionFloatInt: Implementada por 3) y 4).
- IRelacionLogica: Implementada por 2) y 5).

# Funcionamiento
 La idea principal es funcionamiento fructífero de las transformaciones y de las operaciones entre tipos.
 
- En cuanto a las transformaciones, como todo tipo puede ser un TipoString, este es aplicable desde una clase madre AbstractTipos. En el caso del resto de las transformaciones o son aplicadas desde sus mismas clases puesto que es la única transformación que permiten y es con respecto a ellas mismas o bien, son abarcadas desde las interfaces INumero, IRelacionFloatInt o bien, IRelacionFloatBinary.
 
- En cuanto a las operaciones, como la correspondencia entre ellas no es simétrica, se implementa un Double Dispatch asimétrico. La idea es que, cada interfaz que permita una operacion entre las que las implementen, tengan métodos que permitan delegar las tareas entre sí en las clases respectivas de los tipos que son llamadas desde funciones genéricas de operación: Suma, Resta, Multiplicación, División, DisyuncionLogica y ConjuncionLogica, para mantener un un orden general de manipulación del usuario de las operaciones pertinentes. 

# Acotaciones y Supuestos relevantes
- El TipoNumeroBinario toma forma a partir del primer bit que indique su signo, esto es, se implementan binarios positivos como: 010101 pero no 0000000010101, por simplicidad. Análogo para binarios con signo negativo.
- En cuanto a la operacion unaria Negacion, se implementa en las clases IRelacionLogica y IRelacionFloatInt para poder estrátegicamente no otorgarle la posibilidad de uso a TipoString, que es el único Tipo de Scrabble que no hace uso de esta operación.

# Parte N°2 del Proyecto Scrabble; ÁST y fábricas de Tipos Scrabble
# Supuesto importante
El principal supuesto para la implementación de esta parte del proyecto es que el cliente no hará mal uso de las operaciones y transformaciones de y entre Tipos Scrabble no permitidas. Esto permitirá realizar cambios que faciliten la complejidad de la implementación como se explicitan en el siguiente punto.

# Cambios en la Parte N°1 del proyecto
Se crea un nuevo tipo que NO es un Tipo de Scrabble sino una herramienta para solventar la falta de simetría en las operaciones de los tipos como Null Pattern. De esta manera, en principio todas las operaciones y transformaciones retornan TipoNulo para solventar las asimetrías de las operaciones, como resultado no válido, pero cada clase sabe que operaciones y transformaciones puede realizar (Double Dispatch), por lo que, hace override de ellas. Dado lo anterior, se eliminan las interfaces que aportaban a solventar las asimetrías en caso de que el usuario transformase u operase entre tipos que no permiten un resultado, esas son; IRelacionBinarioInt, IRelacionFloatInt, IRelacionLogica e INumero.

# ¡Nuevas clases e interfaces!
Para la creación del AST se implementan;
- Clases; Suma, Resta, Division, Multiplicacion, Y, O, Negacion, aTipoString, aTipoBoolean, aTipoNumeroInt, aTipoNumeroBinario y aTipoNumeroFloat.
- Clase abstracta: NodoCompuesto. Extendidas por todas las clases del punto anterior.
- Interfaz: INodo. Implementada por la clase abstracta NodoCompuesto.

Para la reutilización de la memoria se implementan;
- Clases: FabricaTipoString, FabricaTipoBoolean, FabricaTipoNulo, FabricaTipoNumeroInt, FabricaTipoNumeroFloat y FabricaTipoNumeroBinario.
-
# Entonces .. ¡Factory, Flyweight, Composite, Null y Singleton Pattern!
Dado lo mencionado anteriormente en el prólogo, nos hemos apoyado de distintos patrones para lograr la funcionalidad objetivo.
* Null pattern se utiliza para facilitar la decoherencia otorgada por la asimetría de las operaciones.
* Factory Pattern se utiliza en la creación de fábricas de cada tipo scrabble y también para TipoNulo, con la finalidad de delegar la responsabilidad de la creación de los Tipos Scrabble de forma centralizada.
* Composite Pattern se utiliza para la creación del AST. 
* Singleton Pattern se utiliza sobre cada una de las fábricas para que este control centralizado sea global y cada vez que se quiera crear un nuevo Tipo Scrabble dentro de las implementaciones de los métodos de transformaciones y operaciones puedan consultarlo directamente a una única fábrica, evitando incoherencias sobre el ahorro de memoria al momento de usar las fabricas y crear un AST.
* Flyweight Pattern se utiliza para la reutilización de memoria, especificamente, sobre la creación de Tipos Scrabble a partir de un HashMap único que poseen las fábricas dado el carácter único de estas mismas. De esta forma, cualquier operacion u transformación que requiera nuevos tipos siempre consultará al diccionario para no crear Tipos existentes.

# Parte N°3 del Proyecto Scrabble; Control de Flujo
# ¡Nuevas clases e interfaces!
Para el control de flujo se implementan:
- Clases: If, While, Var,  Condición, FabricaVariable, Visitante, VisitanteIf, VisitanteWhile y VisitanteVariable.
- Interfaz: IControlDeFlujo e IVisitante.

# Acotaciones y supuestos relevantes
Para poder dar cabida a una correcta implementación de control de flujo del AST, es menester notar lo que sigue:
* Se implementa la clase Var, como implementación extra a los requerimientos, con la finalidad de motivar un control de flujo de la instrucción While coherentemente. Sin esta clase, el While vendría a ser un flujo estático desde el comienzo replicando la funcionalidad del If, por lo que, introduce la posibilidad de testearla adecuadamente.
* Para poder hacer las comparaciones pertinentes, que sabemos es, entre tipos de Scrabble iguales, se adjuntan nuevos métodos en todos los tipos que sean tipos de Scrabble, estos son:
- CompararCon, compararConBoolean, compararConString, compararConTipoNumeroInt, compararConTipoNumeroFloat, compararConTipoNumeroBinario. Donde los últimos 5 permiten implementar a CompararCon como Double Dispatch.
* Necesitamos que la creación de variables cumpla con la optmización de memoria, así como unicidad, por lo que se crea la FabricaVariable como singleton. Esto permitirá actualizarla consistentemente.
* Muy importante es que, como la idea no es modificar la implementación de las entregas anteriores, no se implementa el AST como se sugiere en el enunciado, esto es, como una lista, puesto que el composite fue ya implementado de la forma en que el testing se aprecia y todo el código subyace funcionalmente ante esa implementación. Por lo que, la actualización de las variables dentro de un AST es inminente únicamente para las que están dentro de la condición, no de las inmiscuidas en cualquier AST que recibe If y While para hacer el control de flujo.
* While recibirá el AST la condición a partir de la clase condición. Esto también es un aporte creativo para mejorar el programa, de lo contrario, se hace complicado mantener la coherencia entre la condición y las variables que inmiscuye esta misma para poder actualizarla.
* Para la actualización de las variables se usa en cada ITipo el metodo aceptaCambios() que es llamados desde el visitante VisitaVariable. Entonces con este método podemos variar una variable para lograr que el While en algún momento (para el testing usamos 10 ciclos) permita dejar pasar en el AST, el AST que recibe como variable.
* No se testea directamente la actualización de las variables puesto que está implicito en el testing tanto de lasc clases If y especialmente, While, motivo por el cual en principio se motivó la creación de variables.

# Entonces .. ¡Visitor!
Notamos que hemos implementado visitor para que el flujo que controla While e If, sea manejado desde las clases VisitanteIf y VisitanteWhile. Además, para poder actualizar variables se implementa VisitanteVariable, que permite con la ayuda de aceptaCambio() en cada uno de los ITipos actualizarlos. 
