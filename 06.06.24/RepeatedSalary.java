package count;

import java.util.Scanner;

public class RepeatedSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();     
        if (n <= 0)
        {
            System.out.println("Invalid Input");
            return;
        }       
        int[] salaries = new int[n];
        for (int i = 0; i < n; i++) 
        {
            salaries[i] = sc.nextInt();
            if (salaries[i] < 0)
            {
                System.out.println("Invalid Input");
                return;
            }
        }       
        int repeaters = countRepeaters(salaries, n);
        System.out.println(repeaters);
    }
    public static int countRepeaters(int[] arr, int size) {
        int repeaters = 0;
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) 
            {
                if (arr[i] == arr[j]) 
                {
                    count++;
                }
            }
            if (count > 1) 
            {
                repeaters++;
            }
        }
        return (int) repeaters;
    }
}
