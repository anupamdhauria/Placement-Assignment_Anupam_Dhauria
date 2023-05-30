/*Create a Java program that simulates a bank account. The program should allow
users to deposit and withdraw money, check their balance.*/
package corejava;
import java.util.Scanner;
class InsufficientBalance extends RuntimeException{
	public InsufficientBalance(String msg) {
		super(msg);
	}
}

interface Bank{
	void withdraw(double balance);
	void deposit(double balance);
}
class SBI implements Bank{
	private double accountBalance;

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public void withdraw(double balance) {
		if(balance>this.accountBalance) {
			throw new InsufficientBalance("Insufficient balance to withdraw");
		}else {
			this.accountBalance=this.accountBalance-balance;
			System.out.println(balance+ "  has been deducted from your account...");
			System.out.println("your updated balance is: "+getAccountBalance());
		}
	}

	@Override
	public void deposit(double balance) {

		this.accountBalance=this.accountBalance+balance;
		System.out.println(balance +" has been deposited" );
		System.out.println("your updated balance is: "+getAccountBalance());
	}
}

public class Question4 {



	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int balance;
		SBI sbi=new SBI();
		sbi.setAccountBalance(30000);
		int choice;

		while(true) {
			
			System.out.println("1. know your Account Balance");
			System.out.println("2. Withdraw Money");
			System.out.println("3. Deposit Money");
			System.out.println("4. Exit");
			System.out.println("Enter your choice..");
			choice=sc.nextInt();
			switch(choice) {
			case 1: System.out.println("Your Account Balance is: "+ sbi.getAccountBalance());
					break;
			case 2:
				try {
					System.out.println("enter the amount which you want to withdraw: ");
					balance=sc.nextInt();
					sbi.withdraw(balance);
					
				}catch(InsufficientBalance ex) {
					ex.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 3:	
				try {
					System.out.println("enter the amount which you want to deposit: ");
					balance=sc.nextInt();
					sbi.deposit(balance);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 4: System.exit(0);

			}
		}



	}

}
