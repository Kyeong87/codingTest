import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer="sssss";
        String[] str = String.valueOf(numbers).split(",");
        perm(str, 0, numbers.length, numbers.length);

        return answer;
    }

    public static void perm(String[] str, int depth, int n, int r) {
        if (depth == r) { // 한번의 depth가 k로 도달하면 사이클을 한번 돈거다.)
            // String[] arr = new String[numbers.length];
            System.out.println(Arrays.toString(str));
//             for(int k =0;k<numbers.length;k++) {

//                 int ss = String.valueOf(numbers[k]).length();
//                 for(int l = 0; l<ss;l++) {
//                     arr[k] += numbers[k];

//                 }
//             }
//             System.out.println(Arrays.toString(arr));
        }
        for (int i = depth; i < n; i++) {
            swap(str, i, depth);
            perm(str, depth + 1, n, r);
            swap(str, i, depth);
        }
    }

    private static void swap(String[] str, int i, int j) {
        String temp = String.valueOf(str[i]);
        str[i] += str[j];
        str[j] += temp;
    }
}