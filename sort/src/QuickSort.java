import java.util.Arrays;

/**
 * 快速排序 O(nlogn)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        QuickSort.quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    public static void quickSort(int[] a, int low, int high) {
        // 1. 递归结束条件
        if (low > high)
            return;
        // 2. 赋值
        int i = low, j = high;
        // 3. 插空
        int key = a[low];
        // 4. 排序
        while (i < j) {
            // 4.1 从右往左找比key小的数
            while (i < j && key < a[j])
                j--;
            // 4.2 从左往右找比key大的数
            while (i < j && key >= a[i])
                i++;
            // 4.3 交换位置
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // 4.4 调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        // 5. 对key的左边进行快排
        quickSort(a, low, i - 1);
        // 6. 对key的右边进行快排
        quickSort(a, i + 1, high);
    }
}
