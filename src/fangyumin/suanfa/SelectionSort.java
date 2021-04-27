package fangyumin.suanfa;

public class SelectionSort {

    //选择排序
    public static void selection(Integer[] arr){
        for(int i = 0; i<arr.length; i++) {
            for (int j = i + 1; j<arr.length; j++){
                if(arr[i] > arr[j]) {
                    ArraysUtils.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArraysUtils.createRandomArr(100,200);
        selection(arr);
        ArraysUtils.printArr(arr);
    }


}
