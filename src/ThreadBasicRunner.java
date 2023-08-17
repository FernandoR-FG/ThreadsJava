class Task extends Thread{
	
	private int number;
	public Task(int number) {
		this.number = number;
	}
	
	public void run() { //Signature o firma
		//Task1
		System.out.print("\n Task " + number + " Thread Begins \n ");
		for(int i = number*100; i<number*100+10;i++) {
			System.out.print(i + " ");
		}
		
		System.out.print("\n Task 1 Thread Done \n ");
	}
}


/* Existen dos maneras de crear un hilo
 * extends Thread
 * implements Runnable*/

/*
 * States of Thread
 * New: Instancia el hilo y lo prepara para ser ejecutado
 * 
 * */

//Primera forma

class Task1 extends Thread{
	//Esto se explica que se ejecuta este metodo en paralelo a los que estan en el main
	public void run() { //Signature o firma
		//Task1
		System.out.print("\n Task 1 Thread Begins \n ");
		for(int i = 1; i<10;i++) {
			System.out.print(i + " ");
		}
		
		System.out.print("\n Task 1 Thread Done \n ");
	}
}

//Segunda Forma

class Task2 implements Runnable{

	@Override
	public void run() {
		//Task2
		System.out.print("\n Task 2  Thread  Begins \n ");
		for(int i = 20; i<30;i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n Task 2 Thread Done \n ");		
	}
	
}

/*
 * Estados de un hilo Thread
 * 
 * New: Cuando creo la tarea1 esta lista pero no se ha ejecutado
 * Runnable: Cuando esta ready para run pero el otro hilo aun no acaba
 * Runnig: Cuando inicia a imprmir esta corriendo
 * Blocked/Waiting: Es cuando un servicio por tercero esta espero data por ejemplo mala conexion de la bd
 * Terminated/Dead:  Cuando se acabo la ejecucion
 * */


/*
 * Salida del programa
 * 
50 51 52 53 54 55 56 57 58 59 
 Task 1 Done 
 111 112 113 114 115 
 Task 1 Thread Begins 
 1 116 117 2 3 118 4 
 Task 2 Done 
 5 6 7 8 9 
 Task 1 Thread Done 
 80 81 82 83 84 85 86 87 88 89 
 Task 3 Done 
 
 Main Done 
 
 Task 2  Thread  Begins 
 20 21 22 23 24 25 26 27 28 29 
 Task 2 Thread Done 
 
 * 
 * */


public class ThreadBasicRunner {
//Cada vez que se imprime es diferente resultado 
	/*
	 * debido a la naturaleza de la concurrencia y 
	 * la ejecución paralela de hilos. 
	 * Los hilos se ejecutan de manera independiente y 
	 * pueden ser intercalados y planificados por el sistema operativo 
	 * en diferentes momentos y de diferentes maneras en cada ejecución.
	 * */
	public static void main(String[] args) throws InterruptedException {
		
		
		//Las siguientes task son normales en programacion 
		//Generalmente son independientes
		//Primero se ejecuta y termina una tarea para otra 
		//Es decir Task 1 se acab e incia la siguiente
		
		/***
		 * Como podemos notar se puede hacer un hilo paralelo
		 * */
		//Task1
		//Forma sin hilo
		for(int i = 50; i<60;i++) {
			System.out.print(i + " ");
		}
		
		System.out.print("\n Task 1 Done \n ");
		
		//Forma con hilo
		Task1 task1 = new Task1(); //New siginifica ready tu run
		task1.setPriority(5); //valores de 1 - 5 -10 
		task1.start(); //task1.run();
		
		//Task2
		
		for(int i = 111; i<119;i++) {
			System.out.print(i + " ");
		}
		
		System.out.print("\n Task 2 Done \n ");
		
		//Con hilo
		//Forma con hilo
		Task2 task2 = new Task2();
		//Debo crear una inctancia de clase Thread
		Thread task2Thread = new Thread(task2); //New siginifica ready tu run
		//task2Thread.setPriority(10);
		task2Thread.start();
		
		//Con esto haremos que los hilos esperen a que se ejecuten completamente
		//Wait for task1 to complete
		task1.join(); //Hasta que eso se termine de ejecutar espera lo anterior
		task2Thread.join();
		
		
		//Metodos interesntas
		/* Thread.sleep(int segundos) esperar
		 * Thread.yield  dejar de usar cpu*/ 
		
		
		//Task3
		
		for(int i = 80; i<90;i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n Task 3 Done \n ");
		
		System.out.print("\n Main Done \n ");
	}

}
