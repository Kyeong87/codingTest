You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


주어진 (i, ai) 좌표를 나타내는 a1, a2, ..., an 정수들이 있다. n 개의 수직선들은 (i, 0), (i, ai)을 두 끝점으로 그려진다. 두 개의 수직선으로 아래와 같이 가장 많은 물을 담을 수 있는 용기를 만들고 그 최대 용량을 구하라. ( n은 최소 2 이상 )

```java
class Solution {
public:
    int maxArea(vector& height) {
        int left = 0;
        int right = height.size() - 1;
        int max_area = (right - left)*min(height[left], height[right]);
        while(left < right){
            if(height[left] <= height[right]){
                left++;
            }
            else {
                right--;
            }
            
            max_area = max(max_area, (right - left)*min(height[left], height[right]) );
        }
        
        return max_area;
    }
};
```
