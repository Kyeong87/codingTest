import java.util.Arrays;
import java.util.Scanner;
public class Main10818 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int arr[] = new int[a];

        for(int i=0; i<a;i++) {
            int c = in.nextInt();
            arr[i] = c;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]+" "+arr[a-1]);
    }
}
