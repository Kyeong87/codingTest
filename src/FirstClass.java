import java.util.Arrays;
import java.util.Scanner;

public class FirstClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int arr[] = new int[a];
        int cnt = 0;
        for(int i=0;i<a;i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0;i<a;i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Test");
    }
}
