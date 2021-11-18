import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int ii = in.nextInt();
        String str = String.valueOf(ii);

//        String str = "71";
        String strsum = "";
        int count = 0;
        int sum = 0;

        if(ii < 10) { // 처음 변수 받았을 때 1~9 일 경우, 0을 붙여줌
            String strTmp = String.format("%02d", ii);
            str = strTmp;
        }

        while (str.equals(strsum)==false || count==0) {
            count++;
            if(count==1) {// 처음 들어올 경우 strsum이 없어서
                strsum = str;
            }
            int[] arr = new int[strsum.length()];

            for(int i=0; i<strsum.length(); i++) {
                arr[i] = strsum.charAt(i) - '0';
            }
            sum = arr[0] + arr[1];

            if(sum >= 10) {
                String strwhile = String.valueOf(sum);
                int[] arr2 = new int[strwhile.length()];
                for(int i=0; i<strwhile.length(); i++) {
                    arr2[i] = strwhile.charAt(i) - '0';
                }
                String str1 = String.valueOf(arr[str.length()-1]);
                String str2 = String.valueOf(arr2[strwhile.length()-1]);
                strsum = str1+str2;
            }else {
                String str1 = String.valueOf(arr[str.length()-1]);
                strsum = str1 + sum;
            }
        }
        System.out.println(count);
    }
}