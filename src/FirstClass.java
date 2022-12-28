import java.io.*;
import java.util.*;

import static java.lang.Math.*;

class FistClass {
    static void printMinOp(String l1, String l2)
    {
        int count = 0;
        char arr1[] = new char[l1.length()];
        char arr2[] = new char[l2.length()];
        for(char ch : l1.toCharArray()) {
            arr1[count] = ch;
            count++;
        }
        int count2 = 0;
        for(char ch : l2.toCharArray()) {
            arr2[count2] = ch;
            count2++;
        }
        int count3 = 0;
        if(arr1[0] == 'x' || arr2[0] =='x') count3++;
        int j =0;
        for(int i=1;i<arr1.length;i++) {
            j = i-1;
            if(arr1[i] == 'x' && arr2[i] =='x') count3++;
            else if(arr1[i] == 'x' || arr2[i] =='.') {
                if(arr1[j] == '.' && arr2[j] == 'x') continue;
                count3++;
            }else if(arr2[i] == 'x' || arr1[i] =='.') {
                if(arr1[j] == 'x' && arr2[j] == '.') continue;
                count3++;
            }
        }
        System.out.println(count3);
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
//        String L1 = ".xxx...x"; // 6
//        String L2 = "..x.xxxx";
        String L1 = "..xx.x."; // 4
        String L2 = "x.x.x..";
        printMinOp(L1, L2);
    }
}
