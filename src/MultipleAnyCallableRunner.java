import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleAnyCallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		List<CallableTask> tasks = List.of(new CallableTask("Ferxxo"),new CallableTask("Noexx"),new CallableTask("Mathex"));
		
		//Resultado del hilo mas rapido en ejecutarse
		 String results = executorService.invokeAny(tasks); //Consumir el resultado mas rapido
		 
		 
		
		System.out.println(results);
		
		
		executorService.shutdown();
	}

}
