import java.util.Scanner;
import java.util.stream.Stream;

public class Main2577 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int arr[] = new int[10];
        int abc = a * b* c;

        int[] digits = Stream.of(String.valueOf(abc).split("")).mapToInt(Integer::parseInt).toArray();

        for(int i=0;i<=9;i++) {
            int count = 0;

            for(int j=0;j<digits.length;j++ ) {
                if(i == digits[j]) {
                    count++;
                }
            }
            arr[i] = count;
        }
        for(int k=0;k<=9;k++){
            System.out.println(arr[k]);
        }
    }
}
