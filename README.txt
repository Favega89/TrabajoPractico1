# TrabajoPractico1
TP 1 THREADS


1- Con los parametros iniciales se necesitan como minimo 4 consumidores
para que el stock decrezca hasta llegar a 0 (MUY lento).

2- Los bloques syncronized solo admiten un thread a la vez dejando en espera
a lo demas procesos que intenten acceder a ellos mientras estan " ocupados ".

3- El recurso compartido es el objeto contenedor de los bloques syncronized que se 
disputaran los procesos. En este caso la cerveceria a la cual acceden consumidores
y productores , ambos en caracter de hilo.

4-  1- Heredar el comportamiento de la clase Thread.
     2- Implementar la la interfaz Runnable.
     3- Utilizando la clase Executors que a travez de la interfaz ExecutorService 
     nos brinda un pool de Threads.
     4- Implementar la interfaz Callable (similar a Runnable pero Run nos permite
     utlizar return).	
	