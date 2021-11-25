import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main2884 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a = in.next();
        String b = in.next();
        String c = a+':'+b;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date saleStart = sdf.parse(c);

            Calendar cal = Calendar.getInstance();
            cal.setTime(saleStart);
            cal.add(Calendar.MINUTE, -45);
            String time = sdf.format(cal.getTime());

            int[] digits = Stream.of(String.valueOf(time).split(":")).mapToInt(Integer::parseInt).toArray();
            System.out.println(digits[0]+" "+digits[1]);
        }catch (Exception e){

        }
    }
}
