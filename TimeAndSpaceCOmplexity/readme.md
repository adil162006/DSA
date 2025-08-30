# Time and Space Complexity

## Introduction
Time and space complexity are fundamental concepts in computer science that help us analyze and compare different algorithms.

## Time Complexity
Time complexity describes how the runtime of an algorithm grows with input size.

### Common Time Complexities
- **O(1)** - Constant Time
  - Example: Accessing an array element by index
  
- **O(log n)** - Logarithmic Time
  - Example: Binary search
  
- **O(n)** - Linear Time
  - Example: Linear search
  
- **O(n log n)** - Linearithmic Time
  - Example: Merge sort, Quick sort
  
- **O(n²)** - Quadratic Time
  - Example: Bubble sort, Selection sort
  
- **O(2ⁿ)** - Exponential Time
  - Example: Recursive calculation of Fibonacci numbers

## Space Complexity
Space complexity describes how much additional memory an algorithm needs relative to input size.

### Common Space Complexities
- **O(1)** - Constant Space
  - Example: Variables that don't grow with input
  
- **O(n)** - Linear Space
  - Example: Creating an array the size of input
  
- **O(n²)** - Quadratic Space
  - Example: Creating a 2D array

## Big O Notation Rules
1. Drop constants: O(2n) → O(n)
2. Drop non-dominant terms: O(n² + n) → O(n²)
3. Different inputs use different variables: O(a + b) not O(2n)

## Example
```python
def find_sum(arr):  # Time: O(n), Space: O(1)
    total = 0
    for num in arr:
        total += num
    return total
```

## Tips for Analysis
- Focus on the worst-case scenario
- Consider both time and space when designing algorithms
- Look for nested loops (often indicates quadratic complexity)
- Watch for recursive calls (especially in exponential time algorithms)
- Remember that some problems can be solved with different algorithms having different complexities