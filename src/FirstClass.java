import java.util.*;

public class FirstClass {
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
