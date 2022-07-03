import java.util.*;
import java.util.function.BiConsumer;

import static java.util.stream.Collectors.groupingBy;

public class StreamExerciseApplication {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad",
                "Ali", "Davood", "Reza", "Mohsen");


        groupByLetters(names);

        groupByLettersAndPrintNumberOfNamesInGroup(names);

        meanValueWithLambda();

    }

    private static void meanValueWithLambda() {
        System.out.println("enter two numbers: ");

        Scanner intInput = new Scanner(System.in);

        Double number1, number2;

        try {

            number1 = intInput.nextDouble();

            number2 = intInput.nextDouble();

        } catch (InputMismatchException e) {

            System.out.println("InputMismatchException");

            return;

        }

        BiConsumer<Double, Double> meanValue = (n1, n2) -> {
            System.out.println("mean = " + ((n1 + n2) / 2));
        };

        meanValue.accept(number1, number2);
    }

    private static void groupByLettersAndPrintNumberOfNamesInGroup(List<String> names) {
        Map<Integer, List<String>> lettersInName = names.stream()
                .collect(groupingBy(String::length));

        lettersInName.forEach((i, s) -> System.out.println(i + " " + s + " number of names= " + s.size()));
    }

    private static void groupByLetters(List<String> names) {
        Map<Integer, List<String>> lettersInName = names.stream()
                .collect(groupingBy(String::length));

        System.out.println(lettersInName);
    }

}
