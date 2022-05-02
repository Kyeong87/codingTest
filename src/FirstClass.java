import java.io.*;
import java.util.*;

class FistClass {
    public static void main(String[] args) {
        int[] arr = {20,7};
        int n = Integer.valueOf(arr[0]);
        int m = Integer.valueOf(arr[1]);
        int result = piz(n,m);
        System.out.println(n + result);
    }
    public static int piz(int n, int m) {
        int result = n/m;
        System.out.println(result);
        if(result == 0) return 0;
        System.out.println(piz(result + n%m , m));

        return result + piz(result + n%m , m);
    }
}
