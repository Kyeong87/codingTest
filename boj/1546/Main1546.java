import java.util.Arrays;
import java.util.Scanner;

public class Main1546 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        int arr[] = new int[a];

        for(int k=0;k<a;k++){
            int b = in.nextInt();
            arr[k] = b;
        }
        Arrays.sort(arr);
        float tmpsum = 0;

        for(int j=0;j<a;j++){
            tmpsum += ((float) arr[j] / (float) arr[a-1]) * 100;
        }
        float sum = tmpsum / a;
        System.out.println(sum);
    }
}
