# TrabajoPractico1
TP 1 THREADS


1- Con los parametros iniciales se necesitan como minimo 4 consumidores
para que el stock decrezca hasta llegar a 0 (muy lento).

2- Los bloques syncronized solo admiten un thread a la vez dejando en espera
a lo demas procesos que intenten acceder a ellos mientras estan " ocupados ".

3- El recurso compartido es el objeto contenedor de los bloques syncronized que se 
disputaran los procesos. En este caso la cerveceria a la cual acceden consumidores
y productores , ambos en caracter de hilo.

4-  1- Creando un objeto de la clase Thread. 
     2- Heredar de la clase Thread.
     3- Implementar la la interfaz Runnable.
