import java.util.Scanner;

public class Main2675 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        in.nextLine();
        String arr[] = new String[a];

        for(int i=0;i<a;i++) {
            String b = in.nextLine();
            arr[i] = b;
        }
        for(int j=0;j<a;j++){
            String[] arr2 = arr[j].split(" ");
            String[] arr3 = arr2[1].split("");
            for(int k=0;k<arr3.length;k++) {
                for(int l=1;l<=Integer.valueOf(arr2[0]);l++) {
                    System.out.print(arr3[k]);
                }
            }
            System.out.println("");
        }
    }
}
