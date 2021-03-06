import java.io.*;
import java.util.*;
public class Main{
    
	//List imported by user
	static ArrayList<Integer> num_list = new ArrayList<Integer>();
	public static String perms[] ;
	public static int counter = -1;
	public static String biggest = "0";
	//Scanner for input
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String args[])
    {
		 System.out.println("Please enter the sequence of numbers you want me to consume: ");
		 while (scanner.hasNextInt()) {
			    //Check for non-negative integers
			    int i = scanner.nextInt();
			    if(i<0){
			    	System.out.println("Please, enter non-negative integers only.");
			    	System.out.println("Please enter the sequence of numbers you want me to consume: ");
			    }
			    else{
			    	num_list.add(i);
			    }
			    
			}
		 Output(num_list);
	}
	
	public static String Output(ArrayList<Integer> sequence)
	{
		
		//The function will cycle through all possible combinations and return the biggest of them
		//First we need to find the number of permutations we will need
		//Factorial based on list length
		Integer length = sequence.size();
		Integer factorial = Factorial(length);
		String perms[] = new String[factorial];
		Arrays.fill(perms, "0");
		
		//Find the permutations
		Permutations(num_list,0);
		System.out.println("The largest combination is: " + biggest);
		return biggest;
	}
	
	public static Integer Factorial(Integer length)
	{
		 int i,fact=1;  
		   
		 for(i=1 ; i <= length; i++){    
		      fact=fact*i;    
		  }    
		return fact;
	}
	
	public static void Permutations(ArrayList<Integer> numbers, int index) {
		  counter += 1;
		  String newperm = "";
		  if(index >= numbers.size() - 1){ //If we are at the last element - nothing left to permute
		  
		  for(int i = 0; i < numbers.size() - 1; i++){
			  
		          newperm = newperm.concat(numbers.get(i).toString());
		        }
		  if(numbers.size() > 0){
			  
			  newperm = newperm.concat(String.valueOf(numbers.get(numbers.size() - 1)));
		  }
		  
		  
		  if(!newperm.equals("")){
			  
			  if(Integer.parseInt(newperm)>Integer.parseInt(biggest)){
				  biggest = newperm;
			  }
				  
		  }
		  
		  return;
		  }
		  
		  for(int i = index; i < numbers.size(); i++){ //For each index in the sub array numbers[index...end]
			//Swap the elements at indices index and i
		        int t = numbers.get(index);
		        numbers.set(index,numbers.get(i));
		        numbers.set(i, t);

		        //Recurse on the sub array numbers[index+1...end]
		        Permutations(numbers, index+1);

		        //Swap the elements back
		        t = numbers.get(index);
		        numbers.set(index,numbers.get(i));
		        numbers.set(i, t);
		    }
	}
	
}
