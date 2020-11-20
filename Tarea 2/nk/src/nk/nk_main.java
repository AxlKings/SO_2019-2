package nk;

import java.util.Scanner;

public class nk_main{
	/*
	Se lee la cantidad de datos en el arreglo para después leer el arreglo, luego se ejecuta un quicksort creando una hebra llamada t1.
	*/
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i;
		int[] array;
		array = new int[n];
		for(i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		in.close();
		Thread t1 = new Thread(new Hebra(array, 0, n-1));
		t1.start();
		try{
			t1.join();
		}
		catch(InterruptedException ie)
		{
			Thread.currentThread().interrupt();
		}
		for (int j : array) {
			System.out.print(j);
			System.out.print(" ");
		}
	
		
		
	}
}
