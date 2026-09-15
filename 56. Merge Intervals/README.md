# 56. Merge Intervals

## Problem

Given an array of intervals, merge all overlapping intervals and return the non-overlapping intervals.

### Example

```text
Input:  [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
```

## Approach

1. **Sort** the intervals based on their starting value.
2. Add the first interval to the result.
3. For each remaining interval:

   * If `current.start <= last.end`, the intervals overlap.
   * Merge them by updating the end to the maximum of both ends.
   * Otherwise, add the current interval as a new interval.
4. Convert the result list to a 2D array.

### Overlap Condition

```java
current[0] <= last[1]
```

### Merge

```java
last[1] = Math.max(last[1], current[1]);
```

## Complexity

* **Time:** `O(n log n)` — sorting
* **Space:** `O(n)` — result list

## Key Takeaway

**Sort by start → check overlap → merge or add.**
