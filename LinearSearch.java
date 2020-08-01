package phonebook;

public class LinearSearch implements Search {


    @Override
    public int execute(String[] data, String value) {
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
