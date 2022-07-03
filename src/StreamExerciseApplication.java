import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.groupingBy;

public class StreamExerciseApplication {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad",
                "Ali", "Davood", "Reza", "Mohsen");


        System.out.println("part 1");
        System.out.println();

        groupByLetters(names);

        System.out.println("part 2");
        System.out.println();

        groupByLettersAndPrintNumberOfNamesInGroup(names);

        System.out.println("part 3");
        System.out.println();

        meanValueWithLambda();

        System.out.println("part 4");
        System.out.println();

        checkStartAndEndSimilar();

        System.out.println("part 5");
        System.out.println();

        testCode();

    }

    private static void testCode() {
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(3);

        nums.add(5);

        nums.add(1);

        nums.stream()
                .filter(val -> val > 1)
                .forEach(val -> System.out.println(val));
    }

    private static void checkStartAndEndSimilar() {
        System.out.println("enter a word:");

        Scanner stringInput = new Scanner(System.in);

        String testWord;

        try {

            testWord = stringInput.nextLine();

        } catch (Exception e) {

            System.out.println("bad input");

            return;

        }

        Predicate<String> checkStartAndEnd = (s) -> s.charAt(0) == s.charAt(s.length() - 1);

        System.out.println(checkStartAndEnd.test(testWord));
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
