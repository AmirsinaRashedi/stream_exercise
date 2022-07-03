import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class StreamExerciseApplication {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad",
                "Ali", "Davood", "Reza", "Mohsen");

        groupByLetters(names);

    }

    private static void groupByLetters(List<String> names) {
        Map<Integer, List<String>> lettersInName = names.stream()
                .collect(groupingBy(String::length));

        System.out.println(lettersInName);
    }

}