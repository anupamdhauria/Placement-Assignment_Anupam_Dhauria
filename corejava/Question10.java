package corejava;
public class Question10 {
	protected static int getSecondLargest(int[] arr, int size){  
		int highest=Integer.MIN_VALUE;
		int secondHighest=Integer.MIN_VALUE;
		
		for (int i = 0; i < size; i++)   {
			if(arr[i]>highest) 
				highest=arr[i];
		}
	
	for(int i=0;i<size;i++) {
		if(secondHighest<arr[i] && arr[i]!=highest) 
			secondHighest=arr[i];
		
	}
	return secondHighest;
			
	}  
	public static void main(String[] args) {

		int a[]={1,2,5,6,3,2};  
		int b[]={44,66,99,77,33,22,55};  
		System.out.println("Second Largest: "+getSecondLargest(a,a.length));  
		System.out.println("Second Largest: "+getSecondLargest(b,b.length));  

	}

}
