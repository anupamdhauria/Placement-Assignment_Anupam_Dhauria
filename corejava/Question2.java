package corejava;
/*Write a Java program to invoke parent class constructor from a child class. Create
Child class object and parent class constructor must be invoked. Demonstrate by
writing a program. Also explain key points about Constructor.*/

class A{
	public int a;
	public int b;
	A(int a ,int b){
		this.a=a;
		this.b=b;
	}
}
class B extends A {

	public int c;
	B(int a,int b,int c){
		super(a,b);//invoked parent class constructor
		this.c=c;
	}
	public void sum() {
		int sum=0;
		sum=a+b+c;
		System.out.println("sum of three no: "+ sum);
	}
	
}
public class Question2 {

	public static void main(String[] args) {
		
		B obj=new B(10,30,40);
		obj.sum();

	}

}
