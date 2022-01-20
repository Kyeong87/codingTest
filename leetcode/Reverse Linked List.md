Given the head of a singly linked list, reverse the list, and return the reversed list.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack;
        stack = new Stack<>();
        ListNode ans = new ListNode();
        // ListNode temp = ans ;
        
        stack.push(head);
        
        for(int i=0;i<stack.size();i++) {
            ans = stack.peek();
        }
        
        return ans;
    }
}
```
- stack 마지막에 들어간게 먼저 나오는거. 근데 왜 내 생각과 다르지... 지금 이게 노드로 구현이 되있어서 인가.   
너무 어렵네 증말 ㅠㅠ

#해답
- Linked List 의 root 가 주어지면 뒤집은 Linked List 의 root 를 구하는 문제입니다.
재귀와 반복입니다.
처음에 생각할 수 있는 건 재귀인데 Linked List 의 꼬리까지 쭉 들어간 다음에 node.next 를 변경 하면서 다시 돌아오면 됩니다.
예제를 통해서 어떻게 바뀌는지 알아보겠습니다.

```java
// 1. Recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode result = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return result;
    }
}

// 2. iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode parent = null;

        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next = parent;
            parent = current;
        }

        return parent;
    }
}
```
  

