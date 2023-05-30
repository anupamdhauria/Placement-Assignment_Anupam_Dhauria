/* Write a Java program that creates two threads. The first thread should print even
numbers between 1 and 10, and the second thread should print odd numbers
between 1 and 10. */
package corejava;

public class Question8 {

	int counter=1;
	static int n;
	public static void main(String[] args) {

		n=10;
		Question8 obj=new Question8();

		//create 1st Thread
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				obj.printOddNo();
			}


		},"Thread-1");

		//create 2nd Thread
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				obj.printEvenNo();
			}


		},"Thread-2");
		t1.start();
		t2.start();

	}
	protected void printOddNo() {
		int c=0;
		synchronized(this){
			while(counter<n) {
				c++;
				while(counter%2==0) {
					try {
						wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+ " odd: "+ counter);
				counter++;
				notify();
			}
			System.out.println("T1 time: "+ c);
		}

	}
	protected void printEvenNo() {
		int c=0;
		synchronized(this){
			while(counter<n) {
				c++;
				while(counter%2!=0) {
					try {
						wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+ " even: "+ counter);
				counter++;
				notify();
			}
			System.out.println("T2 time: "+ c);
		}

	}

}
