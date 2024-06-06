package oddevenaverage;
import java.util.*;

public class OddEvenAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Invalid Input");
            return;
        }
        int number[] = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num < 0) {
                System.out.println("Invalid Input");
                return;
            }
            number[i] = num;
        }
        float average = avgOddEvenSum(number, n);
        System.out.printf("%.2f",average);
    }
    public static float avgOddEvenSum(int number[], int n) {
        float oddSum = 0, evenSum = 0;
        for (int num : number) {
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        float oddAverage = oddSum;
        float evenAverage = evenSum;
        float average = (oddAverage + evenAverage) / 2;
        return average;
    }
}
