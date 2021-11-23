import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main3052 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[10];
        for(int k=0;k<=9;k++){
            int a = in.nextInt();
            int sum = a % 42;
            arr[k] = sum;

        }
        int[] resultArr = Arrays.stream(arr).distinct().toArray();
        System.out.println(resultArr.length);

        ArrayList<Integer> list = new ArrayList<Integer>();
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);

        IntStream stream1 = IntStream.of(7,5,2,3,4,1,6);
        IntStream stream2 = IntStream.of(7,5,2,3,4,1,6);
        stream1.distinct().forEach(e - > System.out.println(e + "")); // 중복된 요소 제거
        stream2.filter(n - > n %2 !=0).forEach(e - > System.out.println(e + " ")); // 홀수만 골라냄

        // map(), flatmap()
        Stream<String> stream = Stream.of("test","css");
        stream.map(s -> s.toLowerCase(Locale.ROOT)).forEach(System.out::println); //해당 스트림의 요소들을 주어진 함수에 인수로 전달하여 그반환값들로 이루어진 새로운 스트림 반환

        String[] arr = {"i am hungry", "i love you"};
        Stream<String> stream = Arrays.stream(arr);
        stream.flatMap(s -> Stream.of(s.split(" +"))).forEach(System.out::println); // 여러 문자열이 저장된 배열을 각 문자열에 포함된 단어로 이루어진 스트림으로 반환
    }
}
