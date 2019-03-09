import java.util.Arrays;

/**
 * 三路快排
 * 时间复杂度：O(nlogn)
 */
public class QuickSort3Ways {

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        QuickSort3Ways.quickSort3(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort3(int[] a) {
        if (a == null && a.length == 0)
            return;
        quickSort3(a, 0, a.length - 1);
    }

    // [low+1,lt]为小于key，[lt,i-1]==key，[gt,high]>key
    public static void quickSort3(int[] a, int low, int high) {
        if (low >= high)
            return;
        int key = a[low];
        int lt = low;
        int gt = high + 1;
        int i = low + 1;
        while (i < gt) {
            if (a[i] < key) {
//                swap(a[i++],a[++lt]);
                swap(a, i++, ++lt);
            } else if (a[i] > key) {
//                swap(a[i],a[--gt]);
                swap(a, i, --gt);
            } else
                i++;
        }
//        swap(a[l],a[lt]);
        swap(a, low, lt);
        quickSort3(a, low, lt);
        quickSort3(a, gt, high);
    }

    private static void swap(int[] a,int loc1,int loc2) {
        int temp = a[loc1];
        a[loc1] = a[loc2];
        a[loc2] = temp;
    }

}
