import java.util.Scanner;

public class Main1152 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String arr[] = a.split(" ");
        int cnt = 0;
        for(int i=0;i<arr.length;i++) {
            if(!arr[i].isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
