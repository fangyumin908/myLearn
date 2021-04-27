package fangyumin.suanfa;

public class ArraysUtils {
    //生成随机数组
    public static Integer[] createRandomArr(int maxLength, int maxValue) {
        int arrLength = (int) (Math.random() * maxLength);
        Integer[] arr = new Integer[arrLength];
        for (int i = 0 ; i< arrLength; i++){
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }


    //交换位置
    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //打印数组
    public static void printArr(Integer[] arr){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
