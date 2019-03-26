import java.util.Arrays;

/**
 * 桶排序
 */
public class BucketSort {

    public static void BucketSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1)
            return;

        int n = arr.length; // 数组的长度
        int max = getMaxVal(arr);
        int[] tmpArr = new int[max + 1]; // 空桶，[0,max+1]个桶

        for (int i = 0; i < n; i++) // 把每一个数放入对应的桶中
            tmpArr[arr[i]]++;
        int j = 0;
        for (int i = 0; i < max + 1; i++)
            while (tmpArr[i] != 0) {
                arr[j++] = i;
                tmpArr[i]--;
            }
    }

    private static int getMaxVal(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        BucketSort.BucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
