import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {

	public static void main(String[] args) {
		//Esta clase nos permite ejecutar un hilo a la vez
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		//Para eejecutar varios a la veez
		ExecutorService executorService = Executors.newFixedThreadPool(2);//Aqui se manda como parametro cuantos hilos se ejecutan a la vez
		/*
		executorService.execute(new Task1());
		executorService.execute(new Thread(new Task2()));
		*/
		
		//La cantidad de hilos que se ejecutan a la vez depende de la pool
		executorService.execute(new Task(1));
		executorService.execute(new Task(2));
		executorService.execute(new Task(3));
		executorService.execute(new Task(4));
		executorService.execute(new Task(4));

		//El funcionamiento es el siguiente, primero se ejecuta la 1 
		//como solo se permite ejecutar un hilo a la vez se va al main
		//termina ejecutando la task2
		
		//Task3
		
				for(int i = 80; i<90;i++) {
					System.out.print(i + " ");
				}
				System.out.print("\n Task 3 Done \n ");
				
				System.out.print("\n Main Done \n ");
				
				
		executorService.shutdown();//Para cerrar el hilo o si no el programa seguira ejecutandose
	}

}
