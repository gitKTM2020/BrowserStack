package browserStack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class eService {


		public static final String USERNAME = "ameerhamza16";
		public static final String AUTOMATE_KEY = "vM6PAezswFe123z7BbpL";
		public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		public static void main(String[] args) throws InterruptedException, ExecutionException {
			ExecutorService executorService = Executors.newFixedThreadPool(2);  // A pool of 2 threads are being created here. You can change this as per your parallel limit
			Set<Callable<String>> callables = new HashSet<Callable<String>>();
			eService obj1 = new eService();
			callables.add(new Callable<String>() {
			    public String call() throws Exception {
			    	obj1.executeTest("Chrome", "latest", "Windows", "10", "Test 1", "Java Executor Sample Build");
			        return "Task 1 completed";
			    }
			});
			callables.add(new Callable<String>() {
			    public String call() throws Exception {
			    	obj1.executeTest("Firefox", "latest", "Windows", "10", "Test 2", "Java Executor Sample Build");
			        return "Task 2 completed";
			    }
			});
			callables.add(new Callable<String>() {
			    public String call() throws Exception {
			    	obj1.executeTest("IE", "latest", "Windows", "10", "Test 3", "Java Executor Sample Build");
			        return "Task 3 completed";
			    }
			});
			callables.add(new Callable<String>() {
			    public String call() throws Exception {
			    	obj1.executeTest("Safari", "latest", "OS X", "Catalina", "Test 4", "Java Executor Sample Build");
			        return "Task 4 completed";
			    }
			});
			// You can add as many test functions as Callables as you want
			List<Future<String>> futures;
			futures = executorService.invokeAll(callables);
			for(Future<String> future : futures){
				System.out.println("future.get = " + future.get());
			}
			executorService.shutdown();
		}
	  public void executeTest(String browser, String version, String os, String os_version, String test_name, String build_name) {
		  // The same test function as shown in the code snippet above
		}
	
}
