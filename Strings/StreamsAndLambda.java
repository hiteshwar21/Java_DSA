package Strings;

import java.util.Arrays;
import java.util.Objects;

public class StreamsAndLambda {
    public static void main(String[] args) {
        vowelExtraction();
    }

    private static void vowelExtraction() {
        String[] name = {"H","I","T","E","S","H","W","A","R"};
        String result = Arrays.stream(name)
                .filter(n-> Objects.equals(n, "A") || Objects.equals(n, "E") || Objects.equals(n, "I") || Objects.equals(n, "O") || Objects.equals(n, "U"))
                .map(n -> n.toLowerCase())
                .reduce("", (c, e) -> c+e);
        //.forEach(n->System.out.println(n));
        System.out.println(result);
    }
}
