package in.ineuron.controller;

import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;


public class LaunchMain {

	public static void main(String[] args)    {
		
		Scanner sc=new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("1. insert");
			System.out.println("2. delete");
			System.out.println("3. search");
			System.out.println("4. update");
			System.out.println("5. exit");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1: insertOperation();break;
			case 2:deleteRecord();break;
			case 3: selectOperation();break;
			case 4:updateRecord();break;
			case 5:System.exit(0);
			default:System.out.println("invalid input");
			}
		}

	}

	private static void updateRecord() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id :: ");
		int sid = scanner.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student std = studentService.searchStudent(sid);
		if (std != null) {
			
			String sname=std.getSname();
			Integer sage=std.getSage();
			String saddr=std.getSaddr();
			sid=std.getSid();
			String  ch;
			
			System.out.println("student name: "+ sname);
			System.out.println("Do you want to update name: (y/n)");
			ch=scanner.next();
			if(ch.equalsIgnoreCase("y")) {
			System.out.print("Enter the student name :: ");
			sname = scanner.next();
			}

			
			System.out.println("student age: "+ sage);
			System.out.println("Do you want to update age: (y/n)");
			ch=scanner.next();
			if(ch.equalsIgnoreCase("y")) {
			System.out.print("Enter the student age :: ");
			 sage = scanner.nextInt();
			}
			
			
			
			System.out.println("student address: "+ saddr);
			System.out.println("Do you want to update name: (y/n)");
			ch=scanner.next();
			if(ch.equalsIgnoreCase("y")) {
			System.out.print("Enter the student address :: ");
			saddr = scanner.next();
			}

			String msg = studentService.updateStudent(sid,sname, sage, saddr);
			if (msg.equalsIgnoreCase("success")) {
				System.out.println("record updated succesfully");
			} else {
				System.out.println("record updation failed....");
			}
		
		} else {
			System.out.println("Record not found for the given id :: " + sid);
		}

		
		
	}

	private static void deleteRecord() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id to be deleted:: ");
		int sid = scanner.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg = studentService.deleteStudent(sid);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record deleted succesfully");
		} else if (msg.equalsIgnoreCase("not found")) {
			System.out.println("record not avilable for the given id ::" + sid);
		} else {
			System.out.println("record deletion failed....");
		}

		
	}

	@SuppressWarnings("unused")
	private static void selectOperation() {
		// insertOperation();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id :: ");
		int sid = scanner.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student std = studentService.searchStudent(sid);
		if (std != null) {
			System.out.println(std);
			System.out.println("SID\tSNAME\tSAGE\tSADDR");
			System.out.println(std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddr());
		} else {
			System.out.println("Record not found for the given id :: " + sid);
		}

		
	}

	@SuppressWarnings("unused")
	private static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the student name :: ");
		String sname = scanner.next();

		System.out.print("Enter the student age :: ");
		int sage = scanner.nextInt();

		System.out.print("Enter the student address :: ");
		String saddress = scanner.next();

		String msg = studentService.addStudent(sname, sage, saddress);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed....");
		}

		
	}

}
