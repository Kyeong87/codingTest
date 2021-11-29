import java.util.*;
import java.util.stream.Stream;

public class Main11720 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a = in.nextLine();
        String b = in.nextLine();

        int aa = Integer.valueOf(a);

        int[] digits = Stream.of(String.valueOf(b).split("")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for(int i=0;i<aa;i++) {
            sum += digits[i];
        }
        System.out.println(sum);
    }
}