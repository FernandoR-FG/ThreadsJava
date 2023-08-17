import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		List<CallableTask> tasks = List.of(new CallableTask("Ferxxo"),new CallableTask("Noexx"),new CallableTask("Mathex"));
		
		
		//Future es una promesa que espera un resultado
		List<Future<String>> results = executorService.invokeAll(tasks);
				//.submit(new CallableTask("Ferxxo"));
		
		for(Future<String> res: results) {
			System.out.println(res.get());
		}
		
		executorService.shutdown();
	}

}
