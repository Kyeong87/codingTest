import java.util.Arrays;
import java.util.Scanner;

public class Main10809 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a = in.nextLine();
        String[] arr = a.split(""); // string 배열로 전환
        String[] arr2 = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int[] arr3 = new int[26];

        for (int j=0;j<arr2.length;j++) {
            arr3[j] = Arrays.asList(arr).indexOf(arr2[j]);
        }

        for(int i=0;i<arr3.length;i++) {
            if(i==arr3.length-1){
                System.out.println(arr3[i]);
            }else {
                System.out.print(arr3[i] + " ");
            }
        }
    }
}
