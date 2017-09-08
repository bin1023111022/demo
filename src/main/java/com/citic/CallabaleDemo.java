package com.citic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallabaleDemo implements Callable<String> {

	private int id;
	
	public CallabaleDemo(int id){
		this.id = id;
	}
	
	public String call() throws Exception {
		return "result of TaskWithResult " + id;
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> res = new ArrayList<Future<String>>();
		
		for(int i = 0 ; i < 10 ; i++){
			res.add(exec.submit(new CallabaleDemo(i)));
		}
		
		for(Future<String> fs : res){
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}finally{
				exec.shutdown();
			}
		}
	}
	
}
