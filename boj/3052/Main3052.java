import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main3052 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[10];
        for(int k=0;k<=9;k++){
            int a = in.nextInt();
            int sum = a % 42;
            arr[k] = sum;

        }
        int[] resultArr = Arrays.stream(arr).distinct().toArray();
        System.out.println(resultArr.length);
    }
}
