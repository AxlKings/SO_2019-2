Sebastián Campos 201773517-1 
Github: Pantuflaa

Axel Reyes 201773502-3
Github: AxlKings


- Para compilar, utilizar el comando make tomc, para ejecutar utilizar el comando make run.

- Si desea ejecutar nuevamente el programa, debe borrar las carpetas creadas (para que no se acumulen las cartas).

-Aportes:

Sebastián Campos:  Creación de carpetas y repartimiento de cartas.

Axel Reyes: Creación de strings, colores, y cartas del mazo.

ENTREGA 2:

- Si desea ejecutar nuevamente el programa, debe borrar las carpetas creadas (para que no se acumulen las cartas).
- Al pedir el número de la opción deseada, por favor no ingresar strings (o explota).
- Para mayor facilidad en la verificación de jugadas válidas, se estandarizó al siguiente formato para el nombre de las cartas:

carta = CopiaColorTipo".txt" || Copian"ngr"Tipon".txt" 
Copia = '1' || '2'
Copian = '1' || '2' || '3'|| '4'
Color = 'roj'|| 'ver'|| 'zul' || 'ama' 
Tipo = 'r' || 'b' || 'p' || '0'|| '1' || '2'|| '3'|| '4'|| '5'|| '6'|| '7'|| '8'|| '9'
Tipon = '4' || 'c'

Donde:

Copia:
	[1-2] = Numero de copia de la carta (cartas no negras)

Copian:
	[1-4] = Numero de copia de la carta (cartas negras)

Color:
	roj = Color rojo
	ver = Color verde
	zul = Color Azul
	ama = Color amarillo
	ngr = Color negro

Tipo:
	r = Reversa
	b = Bloqueo
	p = +2
	[0-9] = Carta con número (no especial)
Tipon:
	4 = Carta +4 (negra)
	c = Carta cambiocolor (negra)
		
EJEMPLOS:

	2roj8.txt --> Copia número dos del ocho rojo
	3ngr4.txt --> Copia número tres del +4
	1amap.txt --> Copia número uno del +2 amarillo
	1zulr.txt --> Copia número uno del reversa azul
	2verb.txt --> Copia número dos del bloqueo verde

La carta negra de cambio color para efectos prácticos de esta entrega genera una carta "dummy" en el pozo la cual indicará el color elegido por el jugador que la lanzó

Ejemplo de carta dummy:

	El jugador que lanza el color escoge el azul, por ende la carta que se genera en el pozo será --> _zul_.txt (Por ende el jugador sólo podrá jugar cartas azules o negras)


Consideraciones: 
-Sólo poner numeros cuando se pide numeros.
-El programa debería funcionar para todos los casos posibles, en caso de que se pille un caso muy específico que se caiga corralo denuevo, plis.
-Para la entrega 3 se hizo el trabajo de pipes (todo lo que está en el main)
-Para volver a jugar, realizar make clear y luego make run.