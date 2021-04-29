import java.util.List;

public class BinarySearch {
    public int binarySearch(List<Integer> sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray.get(mid) < key) {
                low = mid + 1;
            } else if (sortedArray.get(mid) > key) {
                high = mid - 1;
            } else if (sortedArray.get(mid) == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
