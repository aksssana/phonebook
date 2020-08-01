package phonebook;

public class Utility {
    static String timeFromMilliseconds(long milliseconds) {
        if (milliseconds == 0) {
            return "";
        }

        int milli = (int) milliseconds % 1000;
        int seconds = (int) (milliseconds / 1000) % 60 ;
        int minutes = (int) ((milliseconds / (1000*60)) % 60);


        return String.format("%d min. %d sec. %d ms.", minutes, seconds, milli);

    }
}
