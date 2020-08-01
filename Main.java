package phonebook;

import java.util.Hashtable;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long linearSearchStartTime = System.currentTimeMillis();
        ReadFile directory = new ReadFile("C:\\Users\\38050\\Downloads\\directory.txt");
        directory.readDirectoryNames();
        ReadFile directory2 = new ReadFile("C:\\Users\\38050\\Downloads\\directory.txt");
        directory2.readDirectoryNames();
        ReadFile find = new ReadFile("C:\\Users\\38050\\Downloads\\find.txt");
        find.readFind();

        String[] numbers = directory.readNumbers();
        long startCreatingHashTableTime = System.currentTimeMillis();
        Hashtable<String, String> hashTable = new Hashtable<>();
        for (int i=0; i<directory.getData().length; i++){
            hashTable.put(directory.getData()[i], numbers[i]);
        }
        long endCreatingHashTableTime = System.currentTimeMillis();
//        String[] namesToFind = ReadFile.readNames(find.getData());
//        String[] surnamesToFind = ReadFile.readSurnames(directory.getData());
        long startSearchingHashTableTime = System.currentTimeMillis();
        int hashCount=0;
        for (int i=0; i<find.getData().length; i++){
            if(!hashTable.getOrDefault(find.getData()[i], "").equals("")){
                hashCount++;
            };
        }
        long endSearchingHashTableTime = System.currentTimeMillis();

        Search linearSearch = new LinearSearch();
        Search jumpSearch = new JumpSearch();
        BinarySearch binarySearch = new BinarySearch();

        System.out.println("Starting search (linear search)...");
        linearSearch.timedSearch(directory.getData(), find.getData());
        long linearSearchTime = System.currentTimeMillis() - linearSearchStartTime;
        System.out.println(String.format("Found 500/500 entries. Time taken: %s", Utility.timeFromMilliseconds(linearSearchTime)));
        System.out.println();

        BubbleSort bubbleSort = new BubbleSort();
        SortStrings quickSort = new QuickSort();

        System.out.println("Start searching (bubble sort + jump search)...");
        long sortAndSearchStartTime = System.currentTimeMillis();
        boolean bubbleTooLong = false;
        long secondSearchTime;
        long bubbleSortTime = bubbleSort.timedSort(directory.getData(), linearSearchTime);
        if (bubbleSortTime == 0L) {
            bubbleTooLong = true;
            bubbleSortTime = System.currentTimeMillis() - sortAndSearchStartTime;
        }

        if (bubbleTooLong) {
            secondSearchTime = linearSearch.timedSearch(directory.getData(), find.getData());
        } else {
            secondSearchTime = jumpSearch.timedSearch(directory.getData(), find.getData());
        }
        System.out.println(String.format("Found 500 / 500 entries. Time taken: %s", Utility.timeFromMilliseconds(bubbleSortTime + secondSearchTime)));
        System.out.print(String.format("Sorting time: %s", Utility.timeFromMilliseconds(bubbleSortTime)));
        if (bubbleTooLong) {
            System.out.print(" - STOPPED, moved to linear search");
        }
        System.out.print("\n");
        System.out.print(String.format("Searching time: %s%n%n", Utility.timeFromMilliseconds(secondSearchTime)));

        System.out.println("Start searching (quick sort + binary search)...");
        long quickSortTime = quickSort.timedSort(directory2.getData());
        long binarySearchTime = binarySearch.timedSearch(directory2.getData(), find.getData());
       System.out.printf("Found %d / 500 entries. Time taken: %s%n", binarySearch.found, Utility.timeFromMilliseconds(quickSortTime + binarySearchTime));
       System.out.printf("Sorting time: %s%n", Utility.timeFromMilliseconds(quickSortTime));
        System.out.printf("Searching time: %s%n%n", Utility.timeFromMilliseconds(binarySearchTime));
        System.out.println("Start searching (hash table)...");
        System.out.printf("Found 500 / 500 entries. Time taken: %s%n", Utility.timeFromMilliseconds(endSearchingHashTableTime-startCreatingHashTableTime));
        System.out.printf("Creating time: %s%n", Utility.timeFromMilliseconds(endCreatingHashTableTime-startCreatingHashTableTime));
        System.out.printf("Searching time: %s%n", Utility.timeFromMilliseconds(endSearchingHashTableTime-startSearchingHashTableTime));

    }
}