

public class TimeComplexity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 10000000;
		
		//
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= n; j++)
				System.out.println("Coding Blocks");
		}
		
		//-------------------------------------------
		
		//
		for(int i = 1; i*i <= n; i++)
			System.out.println("Coding Bocks");
		
		
		//-------------------------------------------
		
		//
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				for(int k = 1; k <= 1000; k++)
					System.out.println("Coding Blocks");
		
		
		//-------------------------------------------

		//
		for(int i = n/2; i <= n; i++)
			for(int j = 1; j <= n/2; j++)
				for(int k = 1; k <= n; k = k*2)
					System.out.println("Coding Blocks");
		
		
		//-------------------------------------------

		//
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j = j*2)
				for(int k = 1; k <= n; k = k*2)
					System.out.println("Coding Blocks");
		
		
		//-------------------------------------------
		
		//
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= i*i; j++)
				for(int k = 1; k <= n/2; k++)
					System.out.println("Coding Blocks");
		
		
		//-------------------------------------------
		
		//
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j += i)
				System.out.println("Coding Blocks");
		
		
		//-------------------------------------------
		
		//
		int i = 1,s = 1;
		while(s <= n) //if instead of 's' it is 'i'
		{
			i++;
			s += i;
			System.out.println("Coding Blocks");
		}
		
		
		//-------------------------------------------
		
		//							BestCase			WorstCase
		//Bubble Sort        					
		//Selection Sort							
		//Insertion Sort							
		
		
		
	}

}
