# 3870. Count Commas in Range

## Problem

Given an integer `n`, count the total number of commas used when writing all numbers from `1` to `n` in standard number formatting.

### Example

```text
Input: 3870

Numbers with commas:
1000, 1001, 1002, ... 3870

Each contains 1 comma.

Answer = 3870 - 1000 + 1 = 2871
```

## Approach

Instead of checking every number individually, divide the numbers into ranges based on their number of commas.

| Range                     | Commas |
| ------------------------- | -----: |
| `1 - 999`                 |      0 |
| `1,000 - 999,999`         |      1 |
| `1,000,000 - 999,999,999` |      2 |
| `1,000,000,000+`          |      3 |

For each range:

```text
Number of values × commas per value
```

Then add the contributions from all ranges.

### Key Formula

```text
count = end - start + 1

answer += count × commas
```

## Complexity

* **Time:** `O(log n)`
* **Space:** `O(1)`

## Key Idea

The important observation is that numbers in the same digit range contain the same number of commas, so we can count them as a group instead of checking every number individually.
