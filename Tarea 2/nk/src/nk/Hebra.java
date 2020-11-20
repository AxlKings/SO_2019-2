package nk;

public class Hebra implements Runnable {
	int[] array;
	int head;
	int tail;
/*Variables para solucionar el ordenamiento. Se implementara quicksort */
	public Hebra(int[] array, int head, int tail){
		this.array = array;
		this.head = head;
		this.tail = tail;
	}
	
	public void run(){
		/*El programa solo itera si el tail esta mas a la derecha que el head */
			if(head < tail){
				/* Se toma un pivote, podria ser cualquiera, en este caso es el tail */
				int pivote = array[tail];
				int z= head-1;
				/*Se itera desde la cabeza hasta el penultimo elemento (Ya que el ultimo es el pivote) 
				Si el elemento del arreglo en el que estoy es mayor al pivote, lo muevo a la izquierda del arreglo 
				*/
				for(int j=head;j<=tail-1;j++){
					if(array[j] >= pivote){
						z+=1;
						int aux;
						aux=array[j];
						array[j]=array[z];
						array[z]=aux;
					}
				}
				/*
				Una vez se corrieron todos los elemento mayores al pivote a la izquierda del arreglo, se procede a cambiar la posicipn
				del pivote a la que corresponderia su posicion en el arreglo ordenado
				*/

				int aux=array[z+1];
				array[z+1]=array[tail];
				array[tail]=aux;
				/*
				Se crean dos threads las cuales ejecutaran el algoritmo desde el pivote hasta la cabeza y despues del pivote hasta la cola
				*/
				Thread t1 = new Thread(new Hebra(array, head,z ));
				Thread t2 = new Thread(new Hebra(array, z+1, tail));
				t1.start();	
				t2.start();	
				try{
					t1.join();
				}
				catch(InterruptedException ie)
				{
					Thread.currentThread().interrupt();
				}
				try{
					t2.join();
				}
				catch(InterruptedException ie)
				{
					Thread.currentThread().interrupt();
				}
			}


		}
		
	}
