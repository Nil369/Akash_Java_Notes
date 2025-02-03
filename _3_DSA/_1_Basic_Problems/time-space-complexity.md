# **Time & Space Complexity of Algorithms**

## **1. Asymptotic Notations**
Asymptotic analysis is used to describe the efficiency of an algorithm as input size grows. It focuses on how the runtime or space requirements grow relative to input size **N**.

### **Big O, Big Omega, and Big Theta Notations**
1. **Big-O (O)** → **Upper Bound (Worst Case)**
   - Defines the worst-case performance of an algorithm.
   - Example: **O(N²)** means the runtime **at most** grows like **N²**.
   - Example Code:
     ```java
     // O(N^2) - Nested Loops Example
     for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
             System.out.println(i + "," + j);
         }
     }
     ```

2. **Big-Omega (Ω)** → **Lower Bound (Best Case)**
   - Defines the best-case scenario.
   - Example: **Ω(N)** means the algorithm runs at least in **linear time**.
   - Example Code:
     ```java
     // Ω(N) - Best case when element found at first position
     public static int linearSearch(int[] arr, int target) {
         for (int i = 0; i < arr.length; i++) {
             if (arr[i] == target) return i;
         }
         return -1;
     }
     ```

3. **Big-Theta (Θ)** → **Tight Bound (Average Case)**
   - Defines both upper and lower bounds.
   - Example: **Θ(N log N)** means the algorithm always runs in this time complexity.
   - Example Code:
     ```java
     // Θ(N log N) - Merge Sort
     public static void mergeSort(int[] arr) {
         if (arr.length < 2) return;
         int mid = arr.length / 2;
         int[] left = Arrays.copyOfRange(arr, 0, mid);
         int[] right = Arrays.copyOfRange(arr, mid, arr.length);
         mergeSort(left);
         mergeSort(right);
         merge(arr, left, right);
     }
     ```

---

## **2. Time-Space Tradeoff**
- **Definition:** A tradeoff where an algorithm uses **more space** to reduce **time complexity**, or vice versa.
- **Example:**
  - Using **extra memory (space)** for faster lookups:
    ```java
    // O(1) Lookup using HashSet (More space, less time)
    Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
    if (set.contains(3)) System.out.println("Found!");
    ```
  - Using **less space but more computation**:
    ```java
    // O(N) Lookup using Linear Search (Less space, more time)
    int[] arr = {1, 2, 3, 4, 5};
    for (int num : arr) {
        if (num == 3) System.out.println("Found!");
    }
    ```
- **Conclusion:**  
  - If **memory is expensive**, choose an algorithm with **lower space complexity**.  
  - If **speed is critical**, prefer an approach with **lower time complexity**.

---

## **3. Master’s Theorem**
Master’s theorem provides a formula to find the time complexity of **divide and conquer** algorithms.

**Standard Form:**
\[
T(N) = aT(N/b) + O(N^d)
\]
Where:  
- **a** = Number of recursive calls  
- **b** = Factor by which problem size shrinks  
- **d** = Exponent of additional work done outside recursion  

### **Case Analysis**
1. **If** \( d > \log_b a \) → Complexity = O(N^d)
2. **If** \( d = \log_b a \) → Complexity = O(N^d log N)
3. **If** \( d < \log_b a \) → Complexity = O(N^{\log_b a})

### **Example: Merge Sort**
- **Recurrence Relation**:  
  
>  T(N) = 2T(N/2) + O(N)
  
  Here:  
  - **a = 2** (two recursive calls)  
  - **b = 2** (problem size reduced by 2)  
  - **d = 1** (O(N) merge step)  
  - log<sub>2</sub>  2 = 1 → Case 2 → **O(N log N)**  

```java
// O(N log N) - Merge Sort Implementation
public static void mergeSort(int[] arr) {
    if (arr.length < 2) return;
    int mid = arr.length / 2;
    int[] left = Arrays.copyOfRange(arr, 0, mid);
    int[] right = Arrays.copyOfRange(arr, mid, arr.length);
    mergeSort(left);
    mergeSort(right);
    merge(arr, left, right);
}
```

---

## **4. Time Complexity Examples**
| Algorithm     | Best Case  | Average Case | Worst Case |
|--------------|-----------|--------------|------------|
| **Linear Search** | Ω(1) | Θ(N) | O(N) |
| **Binary Search** | Ω(1) | Θ(log N) | O(log N) |
| **Bubble Sort** | Ω(N) | Θ(N²) | O(N²) |
| **Merge Sort** | Ω(N log N) | Θ(N log N) | O(N log N) |
| **Quick Sort** | Ω(N log N) | Θ(N log N) | O(N²) |
| **Heap Sort** | Ω(N log N) | Θ(N log N) | O(N log N) |

### **Example: Quick Sort**
```java
// Quick Sort (O(N log N) average, O(N^2) worst)
public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

---

## **5. Space Complexity**
### **Definition:**
- Measures **extra memory** an algorithm uses **relative to input size**.

### **Common Space Complexities**
| Algorithm | Space Complexity |
|-----------|-----------------|
| Bubble Sort | O(1) |
| Merge Sort | O(N) |
| DFS (Recursive) | O(N) |
| BFS (Queue-based) | O(N) |

### **Example: Recursive Fibonacci (O(N) Space)**
```java
// Recursive Fibonacci (O(N) space due to call stack)
public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

### **Example: Iterative Fibonacci (O(1) Space)**
```java
// Iterative Fibonacci (O(1) space)
public static void fibonacci(int n) {
    int a = 0, b = 1;
    for (int i = 0; i < n; i++) {
        System.out.print(a + " ");
        int temp = a + b;
        a = b;
        b = temp;
    }
}
```

---

## **Conclusion**
- **Time Complexity** → Measures execution time growth.
- **Space Complexity** → Measures additional memory usage.
- **Master's Theorem** → Helps solve recurrence relations.
- **Time-Space Tradeoff** → Balancing time and memory usage.
