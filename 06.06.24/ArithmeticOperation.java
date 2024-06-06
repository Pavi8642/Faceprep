package Arithmetic;

import java.util.*;
public class ArithmeticOperation {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int a = sc.nextInt();
	        int b = sc.nextInt() ;
	        int c= sc.nextInt();
	        int result = performArithmeticOperation(a, b, c);
	        if (result != -1) {
	            System.out.println(result);
	        } else {
	            System.out.println("Invalid Input");
	        }
	    }
	    public static int performArithmeticOperation(int a, int b, int c) {
	        if (a < 0 || b < 0 || a > 32767 || b > 32767) {
	            return -1;
	        }
	        if (c < 1 || c > 4) {
	            return -1;
	        }
	        switch (c) {
	            case 1:
	                return a + b;
	            case 2:
	                return a - b;
	            case 3:
	                return a* b;
	            case 4:
	                if (b == 0) {
	                    return -1;
	                }
	                return a / b;
	            default:
	                return -1;
	        }
	    }
	}