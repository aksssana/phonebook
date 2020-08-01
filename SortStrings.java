package phonebook;

public interface SortStrings {

    int execute(String[] array);

    default long timedSort(String[] data) {
        long startTime = System.currentTimeMillis();

        execute(data);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
