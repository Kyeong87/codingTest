Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

주어진 숫자 리스트들을 이어붙였을 때 가장 큰 숫자를 찾으면 된다.

아이디어는 Sorting해서 큰 숫자 순으로 이어붙여주는건데 두자리수, 세자리수 숫자가 있는 부분에 대한 처리이다.



자바에서 compare 하는 로직을 앞/뒤 값 비교가 아닌 두 숫자를 앞 뒤로 붙인 값들을 (ex : 5, 40 -> 5 40, 40 5)

기준으로 비교하며 더 큰 숫자 순서로 정렬해주는 것이다.


```java
    public String largestNumber(int[] nums) {
        int[] sorted = Arrays.stream(nums)
            .boxed()
            .sorted(this::compare)
            .mapToInt(i -> i).toArray();

        StringBuilder sb = new StringBuilder();
        for(int num : sorted) {
            sb.append(num);
        }

        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }
    private int compare(Integer a, Integer b) {
         String str1 = String.format("%d%d", a, b);
         String str2 = String.format("%d%d", b, a);
         return str2.compareTo(str1);
    }
```