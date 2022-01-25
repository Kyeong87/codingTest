# 문제 (Easy) - Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

![스크린샷 2022-01-24 오후 4 19 18](https://user-images.githubusercontent.com/93639793/150738627-69a83290-d9fc-4741-9680-db04594b8004.png)

## 풀이
1. 배열 2개를 더해서 target 값이 되는 index 2개 리턴
2. 처음 문제 답게 영어인데 문제를 이해함!
3. 이중 for문으로 처리

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<nums.length;j++) {
                if(j!=i) {
                    if(nums[i]+nums[j] == target) {
                        arr[0] = i;
                        arr[1] = j;
                        break;
                    } 
                }
            }
        }
        return arr;
    }
}
```

![스크린샷 2022-01-24 오후 4 21 19](https://user-images.githubusercontent.com/93639793/150738826-c0e5db79-e4cc-41ce-a33f-529ff12bc66e.png)

### 5.67%

1. 아 코테에서 비슷한 문제 나왔는데 못풀었는데 진짜 너무 후회되고 한심해서 울렁거린다
2. 근데 효율성 5% 라서 어차피 풀었어도 탈락이라는 위안을 삼아보자

### Complexity
- 시간복잡도 (Time Complexity)
    - 이중 for문 사용에 따라 O(n2)
- 공간복잡도 (Space Complexity)
    - 추가 할당하여 사용하는 공간이 없으므로 O(1)   
    
## 다른사람 풀이
- 와 풀이를 이해하는데 더 오래 걸림 ㅠㅠ
- map (key,value) 값을 가짐(php 에서 foreach 같은 느낌)
    - containsKey -> 동일한 키값이 있는 지 체크
    - 키 값이 없으면 map.put 으로 [타켓 - nums의 값(9-2), 7] 값을 저장 해줌 => 즉, 7 값을 찾는거임, 두개를 더해서 9 가 되어야하니까
    - 키 값이 있으면 즉, 더해서 9가 되는 값을 찾으면 리턴
- 획기적이다 ㅋㅋ 이걸 어떻게 생각 해서 푸냐고!!!!!!!
    
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
```

![스크린샷 2022-01-24 오후 4 34 24](https://user-images.githubusercontent.com/93639793/150740456-1b580151-7289-4b73-beea-b0d67fc94918.png)

### 72.48%


### Complexity
- 시간복잡도 (Time Complexity)
    - for문 사용에 따라 O(n)
- 공간복잡도 (Space Complexity)
    - 주어진 배열의 항목 수만큼 HashMap에 저장하므로 O(n)

## 결론
- 내가 푼 거(이중for문)는 시간복잡도가 제곱이 되기 때문에 5% gg
