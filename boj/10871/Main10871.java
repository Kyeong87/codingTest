
import java.util.Scanner;
public class Main10871 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int arr[] = new int[a];

        for(int i=0; i<a;i++) {
            int c = in.nextInt();
            if(b>c) {
                arr[i] =  c;
            }
        }
        for(int j=0;j<arr.length;j++) {
            if(arr[j] != 0 ) {
                System.out.print(arr[j] + " ");
            }
        }
    }
}
