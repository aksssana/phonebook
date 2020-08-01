package phonebook;

public class BubbleSort implements SortStrings {

    @Override
    public int execute(String[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareToIgnoreCase(array[j + 1]) > 0) {
                    swapElements(array, j, j + 1);
                }
            }
        }
        return 1;
    }

    public long timedSort(String[] data, long linearSearchTime) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareToIgnoreCase(data[j + 1]) > 0) {
                    swapElements(data, j, j + 1);
                    if (System.currentTimeMillis() - startTime > linearSearchTime * 10) {
                        return 0L;
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        return timeTaken;
    }

    public void swapElements(String[] array, int first, int second) {
        String temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
