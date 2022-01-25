### 실패

```java
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static void sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int data : ar) {
            q.add(data);
        }
        Collections.sort(ar);

        int count = 0;
        int j = 0;
        while(!q.isEmpty()) {
            if(j!=ar.size()-1) {
                System
                if(ar.get(j)==ar.get(j+1)){
                    q.remove(j);
                    q.remove(j+1);
                    count++;
                    j = j+2;
                }else {
                    j = j+1;
                }
            }else {
                break;
            }
        }
        System.out.println(count);
    }
}

public class FirstClass {
public static void main(String[] args) throws IOException {
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.sockMerchant(n, ar);

        bufferedReader.close();
    }
}
```

- 런타임에러 ㅠㅠㅠㅠㅠ

### 아 .. 너무 복잡하게 생각한건가..............
```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
 
public class Solution {
 
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int result = 0;
 
        Arrays.sort(ar);
 
        for (int i = 0; i < n - 1; i++) {
            if (i < n && ar[i] == ar[i + 1]) {
                result++;
                i = i + 1;
            }
        }
       return result;
    }
 
    private static final Scanner scanner = new Scanner(System.in);
 
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
 
        int[] ar = new int[n];
 
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
 
        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
 
        int result = sockMerchant(n, ar);
 
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
 
        bufferedWriter.close();
 
        scanner.close();
    }
}
```

