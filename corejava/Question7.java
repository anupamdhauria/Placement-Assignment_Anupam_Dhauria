/*Create a Java program that implements a binary search algorithm. The program
should accept user input for the target value and search for it in a sorted array. The
program should return the index of the target value if found or a message if not
found.*/
package corejava;
import java.util.*;
public class Question7 {

	private static int binarySearch(int arr[],int size,int target) {
		
		int low=0;
		int high=size-1;
		
		while(low<=high) {
			int mid=(low+high)/2;
			if(arr[mid]==target) {
				return mid;
			}else if(arr[mid]>target) {
				high=mid-1;
			}else {
				low=mid+1;
			}
			
		}
		return -1;
	}
	public static void main(String[] args) {
		int arr[]= {2,4,6,7,8,9};
		int size=arr.length;
		int target;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number which you want to search..");
		target=sc.nextInt();
		int index=binarySearch(arr,size,target);
		
		if(index==-1) {
			System.out.println(target + " element is not found");
		}else {
			System.out.println(target +"  element is found at :"+index+ " index");
		}
		
	}

}
