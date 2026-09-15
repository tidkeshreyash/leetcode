# 704. Binary Search

## Problem

Given a sorted array `nums` and a `target` value, find the index of the target. Return `-1` if the target does not exist.

### Example

```text
Input:  nums = [-1,0,3,5,9,12], target = 9
Output: 4
```

## Approach

1. Initialize two pointers: `left = 0` and `right = nums.length - 1`.
2. Find the middle index.
3. Compare `nums[mid]` with `target`:

   * If equal, return `mid`.
   * If `nums[mid] > target`, search the left half.
   * Otherwise, search the right half.
4. Continue until `left > right`.
5. Return `-1` if the target is not found.

### Key Logic

```java
if (nums[mid] == target) {
    return mid;
} else if (nums[mid] > target) {
    right = mid - 1;
} else {
    left = mid + 1;
}
```

## Complexity

* **Time:** `O(log n)`
* **Space:** `O(1)`

## Key Takeaway

**Use two pointers → check middle → eliminate half of the search space each time.**
