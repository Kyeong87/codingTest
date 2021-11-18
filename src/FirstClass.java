import java.util.*;

public class FirstClass {
    public static void main(String args[]) {
        int  n = 26;
        int temp = n;
        int count = 0;
        while(true) {
            int left = temp / 10;
            int right = temp % 10;
            System.out.println(left);
            System.out.println(right);
            temp = right * 10 + (left + right) % 10;

            System.out.println(temp);
            count++;
            if(n == temp) {
                break;
            }
        }

        System.out.println(count);
    }
}
