import java.util.Arrays;
import java.util.Scanner;

public class Main1157 {
    public static void main(String[] args) {
        //메모리초과
        Scanner in = new Scanner(System.in);

        int count2 = 0;
        String resulstr = "";
        String a = in.nextLine();
        String aa = a.toUpperCase(); // 전부 대문자로 변환
        String[] arr = aa.split("");
        String[] resultArr = Arrays.stream(arr).distinct().toArray(String[]::new); // 중복제거

        int[] arr2 = new int[resultArr.length];

        for(int i=0;i<resultArr.length;i++) {
            int count = aa.length() - aa.replace(String.valueOf(resultArr[i]), "").length(); // 중복 개수 찾기
            arr2[i] = count;
        }
        int max = Arrays.stream(arr2).max().getAsInt();

        for(int j =0; j<arr2.length;j++) {
            if (max == arr2[j]) {
                count2++;
                resulstr = resultArr[j];
            }
        }
        if(count2==1) {
            System.out.println(resulstr);
        }else {
            System.out.println("?");
        }
        // CharAt
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
//        int max=0;
        int cnt=0;
        int num=0;
        st = st.toUpperCase(); // 대문자로 바꿈
        int Alpha[] = new int[26]; // 알파벳 a~z 26개
        for(int i=0;i<st.length();i++) {
            Alpha[(st.charAt(i)-65)]++; // charAt(0)이 'A'일 경우 A-65=0 이므로 Alpha[0]의 값을 +1 해줌
        }
        for(int i=0;i<Alpha.length;i++) {
            if(Alpha[i]>max) {
                max = Alpha[i];
                num = i;
            }
        }
        for(int i=0;i<Alpha.length;i++) {
            if(Alpha[i]==max) { // 가장 큰 값이 배열 안에 있을때 cnt 를 +1 해줌
                cnt++;
            }
        }
        if(cnt>1) {
            System.out.println("?");
        }else {
            System.out.println((char)(num+65));
        }
    }
}