There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique




```java
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int gasLeft = 0;
        int startStation = 0;
        for (int i = 0; i < 2 * N; i++) {
            int k = i % N;
            gasLeft = gasLeft + gas[k] - cost[k];
            if (gasLeft < 0) {
                startStation = (i + 1) % N;
                gasLeft = 0;
            }
            else {
                if (startStation == (i + 1) % N)
                    return startStation;
            }
        }
        return -1;
    }
}
```