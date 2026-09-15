# Merge Sorted Array

## Problem

Given two sorted integer arrays `nums1` and `nums2`, merge `nums2` into `nums1` so that `nums1` becomes one sorted array.

- `nums1` has a size of `m + n`.
- The first `m` elements of `nums1` contain valid values.
- The remaining `n` elements are `0` placeholders.
- `nums2` contains `n` sorted elements.

### Example

```text
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output:
nums1 = [1,2,2,3,5,6]
```

---

## Approach

We cannot directly use `nums1` as the source while writing the merged result because the first `m` elements of `nums1` would be overwritten.

So, we first create a copy of `nums1`:

```java
int[] arr2 = Arrays.copyOf(nums1, nums1.length);
```

Now:

```text
arr2  → original valid elements from nums1
nums2 → second sorted array
nums1 → final result
```

We use three pointers:

```text
left  → current element in arr2
right → current element in nums2
idx   → position where we write the result in nums1
```

### Step 1: Compare both arrays

While both arrays still have elements:

```java
while (left < m && right < n)
```

Compare:

```java
if (arr2[left] > nums2[right])
```

- If `nums2[right]` is smaller, put it into `nums1`.
- Otherwise, put `arr2[left]` into `nums1`.

Because both arrays are already sorted, the smaller element is always the next element of the final sorted array.

### Step 2: Copy remaining elements from `arr2`

If `nums2` is exhausted first, elements remaining in `arr2` are already sorted:

```java
while (left < m) {
    nums1[idx++] = arr2[left++];
}
```

### Step 3: Copy remaining elements from `nums2`

If `arr2` is exhausted first:

```java
while (right < n) {
    nums1[idx++] = nums2[right++];
}
```

---

## Algorithm

1. Copy `nums1` into a temporary array `arr2`.
2. Initialize `left = 0`, `right = 0`, and `idx = 0`.
3. Compare `arr2[left]` and `nums2[right]`.
4. Put the smaller value into `nums1[idx]`.
5. Move the corresponding pointer and `idx`.
6. Copy any remaining elements from either array.
7. `nums1` now contains the completely merged sorted array.

---

## Code

```java
import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left = 0;
        int right = 0;
        int idx = 0;

        int[] arr2 = Arrays.copyOf(nums1, nums1.length);

        while (left < m && right < n) {

            if (arr2[left] > nums2[right]) {
                nums1[idx++] = nums2[right++];
            } else {
                nums1[idx++] = arr2[left++];
            }
        }

        while (left < m) {
            nums1[idx++] = arr2[left++];
        }

        while (right < n) {
            nums1[idx++] = nums2[right++];
        }
    }
}
```

---

## Dry Run

Consider:

```text
arr2  = [1,2,3]
nums2 = [2,5,6]
```

Initially:

```text
left = 0
right = 0
idx = 0
```

| `arr2[left]` | `nums2[right]` | Smaller value | `nums1` |
|---:|---:|---:|---|
| 1 | 2 | 1 | `[1,...]` |
| 2 | 2 | 2 | `[1,2,...]` |
| 3 | 2 | 2 | `[1,2,2,...]` |
| 3 | 5 | 3 | `[1,2,2,3,...]` |
| - | 5 | 5 | `[1,2,2,3,5,...]` |
| - | 6 | 6 | `[1,2,2,3,5,6]` |

Final result:

```text
[1,2,2,3,5,6]
```

---

## Complexity

Let `m` be the number of valid elements in `nums1` and `n` be the number of elements in `nums2`.

### Time Complexity

```text
O(m + n)
```

Each element is processed once.

### Space Complexity

```text
O(m + n)
```

The solution creates a temporary array using:

```java
Arrays.copyOf(nums1, nums1.length);
```

---

## Key Learning

The important idea is the **two-pointer technique**.

```text
arr2:  [1, 2, 3]
         ↑
       left

nums2: [2, 5, 6]
        ↑
      right

nums1: [_, _, _, _, _, _]
        ↑
       idx
```

At every step, compare the elements pointed to by `left` and `right`, place the smaller element at `idx`, and move the corresponding pointer.

> **Note:** There is also an O(1) extra-space solution that merges from the end of `nums1`. This solution intentionally uses a temporary copy because it follows the approach implemented above.
