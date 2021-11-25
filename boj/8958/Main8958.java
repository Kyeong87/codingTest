import java.util.Scanner;

public class Main8958 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String arr[] = new String[a];

        for (int i = 0; i < a; i++) {
            arr[i] = in.next();
        }
        in.close();
        for(int i = 0; i < a; i++) {
            int sum = 0;
            int count = 0;
            for(int j=0;j<arr[i].length();j++) {
                if (arr[i].charAt(j) == 'O') {
                    count++;
                }else {
                    count = 0;
                }
                sum+= count;
            }
            System.out.println(sum);
        }
    }
}