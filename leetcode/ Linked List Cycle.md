LinkedList가 Cycle을 가지고 있는지 판단하는 문제이다.
head 에서부터 List를 순환하다가 다음 노드가 이전노드를 발견하면 Cycle이 있는 경우이니 바로 true를 return 한다.
이전에 있는 노드를 발견하지 못하고 next가 null 일 경우 Cycle이 없는 경우니 false를 return 한다.
노드의 next가 이전에 있던 노드인지 아닌지는 구분하는게 핵심인 것 같다.
마음 같아서는 ListNode의 class 에 isVisited라는 변수를 통해 처리하고 싶긴 하나 그럼 ListNode 들을 전부 새로 CustomNode로 새로 생성해야 되기 때문에 효율적이지 못한 방법같다.
아니면 ListNode를 순회하면서 ArrayList에 저장한 뒤 다음 ListNode의 val 이 ArrayList에 있는지를 판단해서 Cycle의 유무를 가리는 것도 좋을 것 같다.



```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ArrayList<ListNode> arraylist = new ArrayList();
        while(true) {
            arraylist.add(head);
            head = head.next;
            for(int i =0;i<arraylist.size();i++) {
                if(arraylist.get(i)==head) {
                    return true;
                }   
            }
            if(head.next==null) {
                break;
            }
        }
        return false;
    }
}
```