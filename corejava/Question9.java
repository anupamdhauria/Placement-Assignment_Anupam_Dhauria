/*Write a Java program that implements a producer-consumer model using
multithreading. The program should have a producer thread that generates random
numbers and adds them to a queue, and a consumer thread that reads numbers
from the queue and calculates their sum. The program should use synchronization to
ensure that the queue is accessed by only one thread at a time.*/
package corejava;
import java.util.*;
public class Question9 {


	LinkedList<Integer> list = new LinkedList<>();
	int capacity = 2;

	public static void main(String[] args) {

		Question9 obj=new Question9();

		//creating thread 1

		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				obj.produce();
			}

		},"Producer: ");

		//creating thread 2
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				obj.consume();
			}

		},"Consumer");

		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void produce() {
		synchronized(this) {
			while(true) 
			{
				while(list.size()==capacity) {
					try {
						wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				int val=new Random().nextInt(10)+1;
				list.add(val);
				System.out.println(Thread.currentThread().getName()+ "  "+val);
				notify();
			}
		}
	}



	protected void consume() {
		int sum=0;
		synchronized(this) {
			while(true) 
			{
				while(list.size()==0) {
					try {
						wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				int val=list.removeFirst();
				sum+=val;
				System.out.println(Thread.currentThread().getName()+"  "+val+" sum is:  "+sum);
			}
		}
	}

}
