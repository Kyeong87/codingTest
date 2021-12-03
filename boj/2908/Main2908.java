import java.util.Scanner;

public class Main2908 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String arr[] = a.split(" "); // string 배열로 전환

        int aa = Integer.valueOf(arr[0]); // int 로 변환
        int reverse1 = 0;
        while (aa != 0) {
            int digit = aa % 10;
            reverse1 = reverse1 * 10 + digit;
            aa /= 10;
        }

        int bb = Integer.valueOf(arr[1]); // int 로 변환
        int reverse2 = 0;
        while (bb != 0) {
            int digit = bb % 10;
            reverse2 = reverse2 * 10 + digit;
            bb /= 10;
        }

        if(reverse1 > reverse2) {
            System.out.println(reverse1);
        }else if(reverse2 > reverse1) {
            System.out.println(reverse2);
        }
    }
}
