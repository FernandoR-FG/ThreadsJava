import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableTask implements Callable<String>{

	private String name;

	public CallableTask(String name) {
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Hello "+name;
	}
	
}

public class CollableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		//Future es una prmesa que espera un resultado
		Future<String> welcomeThreads = executorService.submit(new CallableTask("Ferxxo"));
		System.out.println("Hilo ejecutado");
		String welcomeM = welcomeThreads.get();
		
		System.out.println("welcomeM = " + welcomeM);
		
		System.out.println("Completado");
		
		executorService.shutdown();
	}

}
