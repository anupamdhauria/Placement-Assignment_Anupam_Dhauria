/*Demonstrate the difference between abstract class and interface by writing programs
as well as in keypoints.*/

package corejava;

interface Mobile{
	void call();//by default public and abstract
	void internet();
	void bluetooth();
}

//Creating abstract class that provides the implementation of one method of Mobile interface
abstract class SamsungGuru implements Mobile{
	
	public void call() {
		System.out.println("calling feautures added..");
	}
}

//Creating subclass of abstract class, now we need to provide the implementation of rest of the methods
class SamsungGalaxy extends SamsungGuru{
	
	public void internet() {
		System.out.println("internet implementation successfully...");
	}
	
	
	public void bluetooth() {
		System.out.println("Bluetooth implementation successfully......");
	}
}

//Creating a Main class that calls the methods of Mobile interface  
public class Question5 {

	public static void main(String[] args) {
		
		Mobile m1=new SamsungGalaxy();
		m1.call();
		m1.internet();
		m1.bluetooth();
	}

}
