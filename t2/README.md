# tarea2
Problema 2 [Completo]
Problema 1 [Completo]

Sebastián Campos 201773517-1
Axel Reyes 201773502-3

Para compilar el problema 2, entrar a la carpeta nk y ejecutar el comando "make", para ejecutar, ejecutar java -jar Problema2.jar
Para compilar el problema 1, entrar a la carpeta Problema_1 y ejecutar el comando "make", para ejecutar, ejecutar java -jar Problema1.jar

En el problema 2 se utilizó quick sort cómo algoritmo de ordenamiento. QuickSort al ser un algoritmo que implementa dividir y conquistar, se aprovecha de las hebras al crear una hebra por camino posible del árbol, por lo que cada instancia de la recursividad está siendo ejecutada por una hebra por lo que se paralelizan las ramas del árbol. Disminuyendo el tiempo de ejecución.

En el problema 1 se procedió a transformar cada expresión aritemtica a su versión postFix, lo cuál facilita considerablemente la forma de evaluar la expresión. Las hebras se utilizaron para parsear cada función en paralelo y transformarlas a su versión postFix. Luego la hebra principal se encargará de evaluar la función entregada por input (se decidió no utilizar hebras para evaluar, ya que cada hebra debía esperar que  otra hebra terminara para poder seguir evaluando, por lo que no existe una mejora sustancial en el tiempo de ejecución con respecto a hacerlo con una hebra).