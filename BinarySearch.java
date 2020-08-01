package phonebook;

public class BinarySearch implements Search{
    int found = 0;

    @Override
    public int execute(String[] data, String value) {
        int left = 0;
        int right = data.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // the index of the middle element

            if (value.equals(data[mid])) {
                return mid; // the element is found, return its index
            } else if (value.compareToIgnoreCase(data[mid])<0) {
                right = mid - 1; // go to the left subarray
            } else {
                left = mid + 1;  // go the the right subarray
            }
        }
        return -1; // the element is not found
    }

    @Override
    public long timedSearch(String[] data, String[] values) {
        long startTime = System.currentTimeMillis();

        for (String value : values) {
            if (execute(data, value)>0) {
                found++;
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
