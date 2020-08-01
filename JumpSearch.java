package phonebook;

public class JumpSearch implements Search {


    @Override
    public int execute(String[] data, String value) {

        int currentRight = 0;
        int prevRight = 0;

        int jump = (int) Math.sqrt(data.length);

        if (data[0].equals(value)) {
            return 0;
        }

        while (currentRight < data.length - 1) {
            currentRight = Math.min(data.length - 1, currentRight + jump);

            if (data[currentRight].compareToIgnoreCase(value) < 0) {
                break;
            }

            prevRight = currentRight;
        }

        if ((currentRight == data.length - 1) && value.compareToIgnoreCase(data[currentRight]) < 0) {
            return -1;
        }

        return searchBackwards(data, value, prevRight, currentRight);


    }

    private int searchBackwards(String[] array, String value, int leftMostExcluded, int rightMostIncluded) {
        int index = -1;

        for (int i = rightMostIncluded; i > leftMostExcluded; i--) {
            if (array[i].equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
