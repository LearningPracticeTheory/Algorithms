# MergeSort Optimization

- `MergeSort` 的泛型实现详见说明: [MergeSort<AnyType>](https://github.com/LearningPracticeTheory/Data_Structure/blob/master/JDS7/md/MergeSort.md) 源码: [Source Code](https://github.com/LearningPracticeTheory/Data_Structure/blob/master/JDS7/src/MergeSort.java) `sort2()`

- **优化部分**主要 ==减少额外空间的使用== & ==简化代码==

- PS: 为了方便起见，使用 ==int== 代替 AnyType，**对比测试**均使用 int 型，对照对象为 `MergeSort<AnyType>.sort2`;

---

- [ ] sort

    1. `sort(int[])` 作为对外公开的方法
    2. 第二个 `sort` 实际上就是 `divide2`，对数组进行++分割++
    \
    使用递归对左右两边进行分割，再进行 `merge` 处理
    
```java
public static void sort(int array[]) {
	sort(array, 0, array.length-1);
}

private static void sort(int array[], int start, int end) {
	if(start >= end) {
		return;
	}
	int middle = (start + end)/2;
	sort(array, start, middle);
	sort(array, middle+1, end);
	merge(array, start, middle, end);
}
```

- [ ] merge

    1. 该实现于**泛型版本**==大同小异==
    \
    仅对代码进行调整，合并速度上并没有太大改变，详见 `merge2`

```java
private static void merge(int array[], int start, int middle, int end) {
	int i = 0, m = middle-start, j = m+1, k = 0;
	int tmpArray[] = new int[end-start+1];
	
	for(int index = start; index <= end; index++) {
		tmpArray[k++] = array[index];
	}
	
	for(int index = start; index <= end; index++) {
		if(i > m) {
			array[index] = tmpArray[j++];
		} else if(j >= tmpArray.length) {
			array[index] = tmpArray[i++];
		} else if(tmpArray[i] < tmpArray[j]) {
			array[index] = tmpArray[i++];
		} else {
			array[index] = tmpArray[j++];
		}
	}
}
```

- [ ] 测试对比

    1. 横坐标 **N**：递增的测试数据量，即排序的 int 的数量
    \
    纵坐标 **t**：排序所需要的时间
    
    2. 从图中红色分割线可知，**左图**==慢==（++用时多++），**右图**==快==（++用时少++）
    \
    减少的时间来源于**减少了归并过程中额外数组的使用**
    \
    实际上是利用了**合并数组相连**的特性，即 `array1 & array2` 属于**同一区间**
    
![image](https://github.com/LearningPracticeTheory/Algorithms/blob/master/Algorithms2/pic/MergeSort.png)
