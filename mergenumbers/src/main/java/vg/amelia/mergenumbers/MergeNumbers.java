package vg.amelia.mergenumbers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Merge numbers in two files to one, unique & ordered set of numbers. Just using plain old java. No lambdas or streams :)
 */
public class MergeNumbers {

    public static void main(String...args) throws IOException, URISyntaxException {

        // Sorted set of numbers
        Set<Integer> numbers = new TreeSet<>();

        // Read files & add to set
        numbers.addAll(readNumbers("numbers-1.txt"));
        numbers.addAll(readNumbers("numbers-2.txt"));

        // Print numbers
        for (Integer number : numbers) {
            System.out.println(number);
        }

    }


    /**
     * Read numbers from file, line by line, comma by comma.
     **/
    private static Collection<Integer> readNumbers(String fileName) throws IOException, URISyntaxException {
        Collection<Integer> result = new ArrayList<>();

        // Read all lines from file
        List<String> allLines = Files.readAllLines(Paths.get(MergeNumbers.class.getClassLoader().getResource(fileName).toURI()), Charset.defaultCharset());

        // Compute all lines
        for (String line : allLines) {

            // Compute all values in one line & add numbers to collection
            String[] numberStrings = line.split(",");
            for (String numberStr : numberStrings) {
                result.add(Integer.parseInt(numberStr));
            }
        }

        return result;
    }


}
