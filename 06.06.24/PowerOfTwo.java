package powerOfTwo;

import java.util.Scanner;

public class PowerOfTwo {
      public static void main(String[] args) {
    	  Scanner sc = new Scanner(System.in);
    	  int number = sc.nextInt();
    	  String output = powerOfTwo(number);
    	  System.out.println(output);
      }

      public static String powerOfTwo(int n) {
    	  if (n < 0) {
    		  return "Number too small";
    	  } else if (n > 32767) 
    	  {
    		  return "Number too large";
    	  }
    	  if ((n & (n - 1)) == 0)
    	  {
    		  return "Yes";
    	  } else
    	  {
    		  return "No";
    	  }
      }
}
    	  