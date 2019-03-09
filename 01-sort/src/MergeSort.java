import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arrays = {9, 5, 4, 2, 7, 6, 8, 1, 3};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    public static void sort(int[] arrays) {
        int[] temp = new int[arrays.length];
        sort(arrays, 0, arrays.length - 1, temp);
    }

    public static void sort(int[] arrays, int left, int right, int temp[]) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arrays, left, mid, temp); // 左边归并排序
            sort(arrays, mid + 1, right, temp); //右边归并排序
            merge(arrays, left, mid, right, temp); // 归并排序左边和右边
        }
    }

    public static void merge(int[] arrays, int left, int mid, int right, int temp[]) {
        int i = left; // 左边序列的指针
        int j = mid + 1; // 右边序列的指针
        int t = 0; // temp数组的指针
        // 1.将左边和右边序列合并
        while (i <= mid && j <= right) {
            if (arrays[i] <= arrays[j]) {
                temp[t++] = arrays[i++];
            } else {
                temp[t++] = arrays[j++];
            }
        }
        // 2. 将剩余的一边元素直接放入到temp中
        while (i <= mid)
            temp[t++] = arrays[i++];
        while (j <= mid)
            temp[t++] = arrays[j++];
        // 3. 更改原数组的顺序
        for(i = 0 ; i < t ; i++) {
            arrays[left+i] = temp[i];
        }
    }
}
