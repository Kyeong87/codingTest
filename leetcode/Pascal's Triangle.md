```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] triangle = new int[numRows][numRows];
        for(int i=0;i<numRows;i++) {
            for(int j=0;j<=i;j++) {
                if(i==j) {
                    triangle[i][j] = 1;
                }else if(j==0) {
                    triangle[i][j] = 1;
                }else {
                    triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1];
                }
            }
        }
    }
}
```

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for(int i=1; i<numRows; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j == 0 || j == i){
                    temp.add(1);
                }
                else{
                    int val = res.get(i-1).get(j-1) + res.get(i-1).get(j);
                    temp.add(val);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
```