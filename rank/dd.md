```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static void countingValleys(int steps, String path) {
    // Write your code here
        int up = 1;
        int down = -1;
        int sum = 0;
        int dhfmrl = 0;
        
        for(int i=0; i<path.length();i++){
            if(path.charAt(i)=='U') {
                sum += up;
            }else {
                sum += down;
            }
            if(sum > 0) dhfmrl++;
        }
        System.out.println(dhfmrl);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        Result.countingValleys(steps, path);

        bufferedReader.close();
    }
}

```

- 아 이건 문제 이해를 잘못했네... 0보다 큰시점이 아니라. 0 이 되는 시점을 찾았어야 하네.까비

```java

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
 
public class Solution {
 
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int sealevel = 0;
        int result = 0;
 
        for(int i = 0; i < n; i ++) {
            int compSealevel = sealevel;
            char comp = s.charAt(i);
            
            if (comp == 'U') {
                sealevel ++;
            } else if (comp == 'D') {
                sealevel --;
            }
 
            if (compSealevel < 0 && sealevel == 0) {
                result ++;
            }
        }
 
        return result;
    }
 
    private static final Scanner scanner = new Scanner(System.in);
 
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
 
        String s = scanner.nextLine();
 
        int result = countingValleys(n, s);
 
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
 
        bufferedWriter.close();
 
        scanner.close();
    }
}
```