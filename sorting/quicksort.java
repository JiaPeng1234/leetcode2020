// quicksort average case runtime complexity O(NlogN), worst case runtime O(N^2), worst case: the array is already sorted, 
// but everytime we pick the first element as pivot which leads to a result that every time we divide,
// the left side subarray is null, that makes the efficiency extremely low just like a buble sort algorithm
// quicksort average space complexity O(logN)

// TODO: 把该方法翻译成漂亮的python代码

// 方法一：使用subarray中间一个数作为pivot，逼格稍微比方法二高一些，稍微可以避免出现最坏情况，但是代码比较难以理解，很多地方要不要加等号很烧脑，如果使用该方法建议死记硬背下来
// 这个方法还可以有提升空间，提升成逼格最高的quicksort，那就是每次不使用坐标为中间的element作为pivot，而是在[beginelement, endelement, middleelement]之中选取中间数作为pivot，
// 基本上可以避免出现最坏情况
public Quicksort{
    public static void main(String[] args){
        Quicksort a = new Quicksort();
        int[] array = {1,3,2,4};
        a.quick_sort(array, 0, array.length - 1);
        for(int i: array)   //  打印数组
            System.out.print(i + ",");
    }
    
    private void quick_sort(int[] array, int low, int high){
        int index = partition(array, low, high);
        if(index - 1 > low)     // 左数组，一定要low ~ index - 1
            partition(array, low, index - 1);
        if(index < high)        // 右数组，一定要index + 1 ~ high
            partition(array, index, high);
    }
    
    private int partition(int[] array, int low, int high){
        int pivot = array[(low+high) / 2];
        while(low <= high){     // 一定要<=而不是<, 这是为了保证low和high产生交错那么low就是index，而index - 1 ~ low就一定都小于pivot，尽管有的时候会造成pivot值并不在两边的分割边界上
            while(array[low] < pivot)   //一定要<而不是<=，我们不想跳过和pivot相等的数值，想象如果数组所有数值都是相等的，那么我们一直跳过会得到一个左右及其不均衡的组合，会大大损害效率，总之死记就好
                low++;
            while(array[high] > pivot)
                high--;
            if(low <= high){    // 一定要带=，否则有陷入while无限循环的危险
                int tmp = array[low];
                array[low] = array[high];
                array[high] = tmp;
                low++;
                high--;
            }
        }
        return low;     // 一定要返回左边，返回右边有可能造成无限划分相同的数组无限循环
    }
}



// 方法二：容易理解与书写，建议使用，但是细节仍然需要一些死记硬背，具体步骤参见geeksforgeeks的教程：https://www.geeksforgeeks.org/quick-sort/
// 总结下来让人容易理解的一段话：每次都把最后一个element作为pivot，使用i，j两个哨兵来遍历前n-1个element，（其中初始化i=low-1，而j=low），
// 只有当j遇到比pivot值小的element的时候，才让i++，同时置换array[i]和array[j]，也就是说，保证了array[0]-array[i]永远全部都是数值小于pivot的元素
// 而i永远指向这一段全部小于pivot的最右端，当j遍历array结束的时候，置换array[i+1]和array[high], 使得最后high所在的位置就是分割点，分割点的左侧元素全部小于它
// 而右侧元素全部大于他
public class Quicksort2{
    public static void main(String[] args){
        int[] array = {1, 3, 2, 4};
        Quicksort2 a = new Quicksort2();
        a.quick_sort(array, 0, array.length - 1);
        for(int i: array)
            System.out.print(i + ",");
    }

    private void quick_sort(int[] array, int low, int high){
        if(low < high){
            int index = partition(array, low, high);
            quick_sort(array, low, index - 1);
            quick_sort(array, index + 1, high);
        }
    }

    private int partition(int[] array, int low, int high){
        int pivot = array[high];    // pick last element as pivot
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(array[j] < pivot){
                i++;
                int tmp = array[i];     // swap array[i] and array[j] so that array[0~i] < pivot
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        i++;
        int tmp = array[i];     // swap pivot with i, elements in pivot left: < all pivot, elements in pivot right: >= pivot
        array[i] = array[high];
        array[high] = tmp;
        return i;
    }
}
