import java.util.Arrays;
import java.util.Scanner;
public class Main2562 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[9];
        int tmp_arr[] = new int[9];
        int max = 0;
        int count = 0;
        int max_count = 0;
        for(int i=0; i<9;i++) {
            int c = in.nextInt();
            arr[i] = c;
            tmp_arr[i] = c;
        }
        Arrays.sort(tmp_arr);
        max = tmp_arr[8];
        for(int j=0;j<9;j++) {
            count++;
            if(max==arr[j]) {
                max_count = count;
            }
        }
        System.out.println(max);
        System.out.println(max_count);
    }
}