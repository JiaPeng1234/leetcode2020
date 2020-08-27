// quicksort average case runtime complexity O(NlogN), worst case runtime O(N^2), worst case: the array is already sorted, 
// but everytime we pick the first element as pivot which leads to a result that every time we divide,
// the left side subarray is null, that makes the efficiency extremely low just like a buble sort algorithm
// quicksort average space complexity O(logN)

// TODO: 把该方法翻译成漂亮的python代码

// 方法一：使用subarray中间一个数作为pivot，逼格稍微比方法二高一些，稍微可以避免出现最坏情况，但是代码比较难以理解，很多地方要不要加等号很烧脑，如果使用该方法建议死记硬背下来
// 这个方法还可以有提升空间，提升成逼格最高的quicksort，那就是每次不使用坐标为中间的element作为pivot，而是在[beginelement, endelement, middleelement]之中选取中间数作为pivot，
// 基本上可以避免出现最坏情况






// 方法二：容易理解与书写，建议使用，但是细节仍然需要一些死记硬背，具体步骤参见geeksforgeeks的教程：https://www.geeksforgeeks.org/quick-sort/
// 总结下来让人容易理解的一段话：每次都把最后一个element作为pivot，使用i，j两个哨兵来遍历前n-1个element，（其中初始化i=low-1，而j=low），
// 只有当j遇到比pivot值小的element的时候，才让i++，同时置换array[i]和array[j]，也就是说，保证了array[0]-array[i]永远全部都是数值小于pivot的元素
// 而i永远指向这一段全部小于pivot的最右端，当j遍历array结束的时候，置换array[i+1]和array[high], 使得最后high所在的位置就是分割点，分割点的左侧元素全部小于它
// 而右侧元素全部大于他
