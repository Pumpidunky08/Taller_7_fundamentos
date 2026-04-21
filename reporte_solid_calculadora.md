# Reporte de Arquitectura y Refactorización: Calculadora SOLID en Java

## 1. Contexto Inicial y Objetivo del Proyecto
El proyecto inició con el requerimiento de construir una calculadora de consola en Java que soportara operaciones matemáticas binarias (suma, resta, multiplicación, división) y unarias (raíz cuadrada, logaritmo natural).

**El problema base:** Se comenzó partiendo de una **Clase Monolítica** en la que coexistían múltiples responsabilidades. En la misma clase se manejaba la impresión de menús, la lectura de datos mediante el escaner, el control de errores, y la lógica algorítmica matemática subyacente. 

El objetivo principal fue realizar una refactorización incremental orientada por **Dominio (DDD)** y **Desarrollo Guiado por Pruebas (TDD)**, culminando en un programa que obedeciera estrictamente los cinco principios **SOLID** del diseño orientado a objetos.

---

## 2. Metodología: TDD (Test-Driven Development)
Durante todo el progreso de la refactorización, el proyecto se construyó usando TDD bajo el marco de pruebas de **JUnit**. 
El flujo de trabajo constó de:
1. **Fase Roja:** Proponer escenarios y aserciones matemáticamente correctos para una clase o método que aún no existía.
2. **Fase Verde:** Codificar e implementar la mínima lógica estructural necesaria para solventar esas pruebas unitarias.
3. **Refactorización:** Acoplar la implementación exitosa de vuelta en el núcleo del sistema preservando la mantenibilidad.

---

## 3. Aplicación Evolutiva de los Principios SOLID

### S - Single Responsibility Principle (SRP - Responsabilidad Única)
**El inconveniente:** La calculadora operaba I/O e insertaba reglas de negocio matemáticas a la vez. Cualquier ajuste mínimo a los textos de la consola arriesgaba dañar una fórmula.
**La solución:** 
Se desglosó el monolito inicial para crear un ecosistema modular:
- **`ValidadorEntrada.java`**: Tomó control exclusivo de interactuar con el escáner y la tolerancia a fallos por ingresos de texto en lugar de números.
- **`OperacionesBinarias` y `OperacionesUnarias`**: Atrajeron la absoluta responsabilidad de los algoritmos de la calculadora.
- **Evidencia del Principio:** Cada clase creada quedó provista de **una y solo una razón para cambiar**. 

### O - Open/Closed Principle (OCP - Abierto/Cerrado)
**El inconveniente:** La integración de una nueva operación como la **Potencia** exigía modificar el código antiguo de la Calculadora agregando un nuevo bloque en una larga sentencia `switch-case`.
**La solución:** 
- Se elaboró una abstracción genérica implementando la interfaz `Operacion`, e implementando individualmente clases atómicas (`Suma.java`, `Resta.java`, `Potencia.java`).
- El despachador principal mutó a un `HashMap/Diccionario` (Registro de Operaciones), aplicando **polimorfismo dinámico**.
- **Evidencia del Principio:** El ecosistema de cálculo quedó _abierto a la extensión_ al permitir introducir operaciones ilimitadas a futuro, pero **cerrado a la modificación**, salvaguardando e inmutando la manera de ejecutarlas.

### L - Liskov Substitution Principle (LSP - Sustitución de Liskov)
**El inconveniente:** A pesar de tener una interfaz común `Operacion`, las operaciones requerían cantidades de sub-argumentos distintas (1 para Raíz, 2 para Suma). Tratar a todas de la misma manera producía _Excepciones de Índice Fuera de Rango_, volviendo a las clases hijas teóricamente insustituibles y obligando indirectamente a la calculadora a usar comparadores `if` condicionales según el tipo concreto de clase subyacente.
**La solución:** 
- Se solidificó el Contrato para exigir e informar la necesidad de operandos antes de ejecutarse: `int getNumeroOperandos()`.
- Se introdujeron validaciones defensivas formales en las Clases Hijas para responder con un estándar predictivo orientado al dominio, como `IllegalArgumentException`.
- **Evidencia del Principio:** Un consumidor de la interfaz genérica, ahora, puede intercambiar incondicionalmente cualquier operación hija ignorando completamente de qué operación se trata sin colapsar el sistema. 

### I - Interface Segregation Principle (ISP - Segregación de Interfaces)
**El inconveniente:** La interfaz `Operacion` forzaba a las operaciones Unarias (como la raíz) a procesar matrices (varargs `double...`) y prepararse para listas de datos, cuando estrictamente solo requerían un número para operar.
**La solución:**
- Las interfaces de propósito general se desecharon por sub-interfaces pragmáticas: **`OperacionBinaria`** y **`OperacionUnaria`**. 
- **Evidencia del Principio:** La implementación garantizó que ningún cliente/clase haya quedado forzado a depender o validar métodos asimétricos a su dominio interno, alistando de paso firmas limpias tipo `ejecutar(double a)` ó `ejecutar(double a, double b)`.

### D - Dependency Inversion Principle (DIP - Inversión de Dependencias)
**El inconveniente:** El hilo principal del software (Main) alojaba la creación explícita de implementaciones de bajo nivel como un instanciador en bucle con `new Suma()`, acoplando al orquestador funcional estrechamente con instancias de datos fijos y complicando el testeo independiente.
**La solución:**
- Se crearon dos estructuras de alto impacto: el **`MotorCalculadora`** (el cerebro matemático), y la **`CalculadoraConsola`** (el cliente I/O). Ambas exigen dependencias inyectadas vía constructor.
- La clase principal `Calculadora.java` se tornó pasiva asumiendo el rol patronal histórico de un **Composition Root**, donde exclusivamente se ensamblan las implementaciones de bajo nivel para inyectarse a los sistemas de nivel superior. 
- **Evidencia del Principio:** Las clases de alto nivel ahora están desvinculadas por completo de herramientas volátiles como un Scanner o implementaciones directas como una Suma. Dependen cien por ciento de abstracciones en sus diccionarios de datos pasados por parámetro.
