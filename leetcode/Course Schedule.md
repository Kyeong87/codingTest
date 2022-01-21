There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.   


내가 들어야하는 총 과목의 수 : numCourses
배열 prerequisites
prerequisites[i] = [ai, bi] => ai과정을 수강하려면 먼저 bi 과정을 수강해야 함
모든 과목을 들을 수 있는지 여부 확인

선행 과목해야하는 과목 확인 => 위상정렬 이용
위상정렬로 탐색한 과목이 전체 과목 수와 맞으면 모든 과목 수강 가능하다는 의미

```java
class Solution {
    public LinkedList<Integer>[] course;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 과목 수강 그래프
        course = new LinkedList[numCourses];
        
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            course[i] = new LinkedList<Integer>();
        }
        
        for (int[] pre : prerequisites) {
            int start = pre[0];
            int end = pre[1];
            
            course[start].add(end);
            indegree[end]++;
        }
        
        return checkCourse(indegree, numCourses);
        
    }
    
    public boolean checkCourse(int[] indegree, int numCourses) {
        // 탐색 완료한 과목들 넣어줌
        HashSet<Integer> subjects = new HashSet<Integer>();
        // 선행학습 완료된 과목 탐색하기 위한 큐
        Queue<Integer> queue = new LinkedList<Integer>();
        
        // 선행이 필요 없는 과목부터 큐에 넣어줌
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) 
                queue.add(i);
        }
        
        while(!queue.isEmpty()) {
            int subject = queue.poll();
            
            for (int next : course[subject]) {
                indegree[next]--;
                
                if (indegree[next] == 0)
                    queue.add(next);
            }
            
            subjects.add(subject);
        }
        
        if (subjects.size() == numCourses)
            return true;
        return false;
    }
}
```   

수강할 수 있는 과목 중 위상이 0인 과목을 수강한다. 이 문제에서는 위상을 -1로 만들어주는 것으로 중복을 피했다. 위상이 0인 과목을 수강하는 동시에,    
해당 과목의 선수강이 필요한 과목의 위상을 1씩 감소시킨다. 위상이 줄어든 과목 중 위상이 0인 과목이 있으면 전의 과정을 반복하여 모든 과목을 수강하면 true를 반환한다. 수강할 수 있는 과목을 찾던 중 어떠한 과목도 수강할 수 없으면 더 이상 수강할 수 있는 과목이 없으므로 false를 반환한다.

```java
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] topology = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            topology[x]++;
            graph.get(y).add(x);
        }

        int count = 0;
        while (count < numCourses) {
            boolean courseTaken = false;
            for (int i = 0; i < numCourses; i++) {
                if (topology[i] == 0) {
                    List<Integer> list = graph.get(i);
                    for (Integer x : list) {
                        topology[x]--;
                    }
                    topology[i]--;
                    courseTaken = true;
                    count++;
                }
            }
            if (!courseTaken) break;
        }

        return count == numCourses;
    }
}
```