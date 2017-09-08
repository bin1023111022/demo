package com.citic;

import java.util.concurrent.TimeUnit;
/**
 * 当最后一个非后台线程（此处为main主线程）终止时，后台线程（t）会“突然”终止；因此一旦main()退出
 * JVM就会立即关闭所有的后台线程，而不会有任何你希望的确认形式
 * @author mycomputer
 *
 */
public class DeamonDemo implements Runnable {

	public void run() {
		
		try {
			System.out.println("Starting DeamonDeom........");
			TimeUnit.SECONDS.sleep(1);//睡眠（阻塞）1秒
			System.out.println("Can show this？");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Exiting via InterruptedException......");
		}finally{
			System.out.println("This should always run ?");
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new DeamonDemo());
		try{
			System.out.println("Run the Thread.......");
			t.setDaemon(true);//设置为后台线程
			t.start();
			throw new Exception();
		}catch(Exception e){
			System.out.println("Produce Exception.......");
		}finally{
			System.out.println("This of the main should always run ?");
		}
		
	}

}
