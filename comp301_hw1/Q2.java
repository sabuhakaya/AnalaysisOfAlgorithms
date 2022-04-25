package comp301_hw1_sabuha_kaya;

import java.util.ArrayList;

public class Q2 {

	  public static void main( String args[] ) {
			ArrayList<Long> nlognRunningTime = new ArrayList<Long>();
			ArrayList<Long> nFuctorialRunningTime = new ArrayList<Long>();
			long startTime1, startTime2, endTime1, endTime2, elapsedTime1, elapsedTime2;
		
	int counter=0;
		  do {
			   
			    int [] array = new int[counter];
			    startTime1= System.currentTimeMillis();
			    mergeSort(array,counter);
				endTime1 = System.currentTimeMillis();
				elapsedTime1 =( endTime1 - startTime1); 
				nlognRunningTime.add(elapsedTime1);
				counter++;
				
		  }while(nlognRunningTime.get(counter-1)<=1);//0.001 second 1000 milliseconds
		  
		  System.out.println("N value for nlogn: "+ counter*1000);// in 1 seconds
		  
		 
//there is always stack overflow error
		 int counter2= 0;
		  do {
			
			  startTime2=  System.currentTimeMillis();
			  factorial(counter2);
				endTime2 =  System.currentTimeMillis();
				elapsedTime2 =( endTime2 - startTime2); //Convert to microseconds
				nFuctorialRunningTime.add(elapsedTime2);
				counter2++;
			  
		  }while(nFuctorialRunningTime.get(counter2-1)<=1); //0.001 second 1000 milliseconds
		  System.out.println("N value for n!: "+ counter2*1000); // in 1 seconds
		  
	    
	        
	    }
	  
	  
	  
	  
	  //n! running time
	  public static long factorial(int n) {
		   if (n <= 2) {
		        return n;
		    }
		    return n * factorial(n - 1); 
	
	  }

	  
	  
	  
	  
	  
	  
	  //nlogn running time
	  public static void merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size){
	      
	      int i=0,l=0,r = 0;
	      //The while loops check the conditions for merging
	      while(l<left_size && r<right_size){
	          
	          if(left_arr[l]<right_arr[r]){
	              arr[i++] = left_arr[l++];
	          }
	          else{
	              arr[i++] = right_arr[r++];
	          }
	      }
	      while(l<left_size){
	          arr[i++] = left_arr[l++];
	      }
	      while(r<right_size){
	        arr[i++] = right_arr[r++];
	      }
	  }

	  public static void mergeSort(int [] arr, int len){
	      if (len < 2){return;}
	      
	      int mid = len / 2;
	      int [] left_arr = new int[mid];
	      int [] right_arr = new int[len-mid];
	      
	    //Dividing array into two and copying into two separate arrays
	      int k = 0;
	      for(int i = 0;i<len;++i){
	          if(i<mid){
	              left_arr[i] = arr[i];
	          }
	          else{
	              right_arr[k] = arr[i];
	              k = k+1;
	          }
	      }
	    // Recursively calling the function to divide the subarrays further
	      mergeSort(left_arr,mid);
	      mergeSort(right_arr,len-mid);
	    // Calling the merge method on each subdivision
	      merge(left_arr,right_arr,arr,mid,len-mid);
	  }



}
