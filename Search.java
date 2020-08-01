package phonebook;

public interface Search {

    int execute(String[] data, String value);


    default long timedSearch(String[] data, String[] values) {
        long startTime = System.currentTimeMillis();

        for (String value : values) {
            execute(data, value);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
