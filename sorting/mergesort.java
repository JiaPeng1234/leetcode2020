// run time complexity O(nlogn) in average and worst case. space complexity O(n)
package sorting;

public class mergesort {
    public static void main(String[] args) {
        int[] array = {1,5,6,234,2,6,12,74,1,53,62,-1,-42};
        mergesort a = new mergesort();
        a.mergesort(array);
        for(int i: array)
            System.out.println(i);

    }

    private void mergesort(int[] array){
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    private void mergesort(int[] array, int[] helper, int low, int high){
        if(low < high){
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle);  // sort left half
            mergesort(array, helper, middle + 1, high); // sort right half
            merge(array, helper, low, high, middle);  // merge them
        }
    }

    private void merge(int[] array, int[] helper, int low, int high, int middle){
        // copy both halves into a helper array
        for(int i = 0; i < array.length; i++){
            helper[i] = array[i];
        }

        int current = 0;
        int leftlow = 0, rightlow = middle + 1;
        /* iterate through helper array. Compare the left and right half, copying back the smaller element from the two halves into the original array */
        while(leftlow <= middle && rightlow <= high){
            if(helper[leftlow] <= helper[rightlow]){
                array[current] = helper[leftlow];
                leftlow++;
            }
            else {
                array[current] = helper[rightlow];
                rightlow++;
            }
            current++;
        }

        // copy the rest part of the left side of the array into the target array
        for(int i = leftlow; i <= middle; i++){
            array[current] = helper[i];
            current++;
        }
    }
}
