import java.util.Scanner;

public class Main2439 {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
//int a = 5;
        for(int j=0;j<a;j++) {
            int k = (a-1) -j;
            for (int i = 0; i < k; i++) {
                System.out.print(" ");
            }
            for(int b=1;b<=j+1;b++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
