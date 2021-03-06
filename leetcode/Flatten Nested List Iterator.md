You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

Implement the NestedIterator class:

NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
int next() Returns the next integer in the nested list.
boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.


```java
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();
    Integer current;
 
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList==null)
            return;
 
        stack.push(nestedList.iterator());    
    }
 
    @Override
    public Integer next() {
        Integer result = current;
        current = null;
        return result;
    }
 
    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && current==null){
            Iterator<NestedInteger> top = stack.peek();
            if(!top.hasNext()){
                stack.pop();
                continue;
            }
 
            NestedInteger n = top.next();
            if(n.isInteger()){
                current = n.getInteger();
                return true;
            }else{
                stack.push(n.getList().iterator());
            }
        }
 
        return false;
    }
}
```