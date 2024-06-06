package Salary;

import java.util.Scanner;

public class Calculatesalary 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int salary = sc.nextInt();
        int shifts = sc.nextInt();       
        int saving = calculateSal(salary, shifts);
        System.out.println(saving);
    }

    public static int calculateSal(int salary, int shifts) 
    {
        if (salary > 8000) 
        {
            System.out.println("Salary too large");
            return -1;
        }
        else if(shifts < 0)
        {
            System.out.println("Shifts too small");
            return -1;
        }
        
        else if (salary < 0)
        {
            System.out.println("Salary too small");
            return -1;
        } 
        double food = 0.2 * salary , travel =  0.3 * salary ;
        double savings = salary - food- travel;
        if (shifts > 0)
        {
            savings += (0.02 * salary) * shifts;
        } 
        return  (int) savings;
    }
}
