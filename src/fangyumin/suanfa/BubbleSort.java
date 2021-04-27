package fangyumin.suanfa;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(Integer[] arr) {
        int length = arr.length;
        for (int k = 0;k < length; length--){
            for(int j = 1; j < length; j++) {
                if(arr[j-1] > arr[j]){
                    ArraysUtils.swap(arr,j-1,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArraysUtils.createRandomArr(10,20);
        sort(arr);
        ArraysUtils.printArr(arr);
    }

}
