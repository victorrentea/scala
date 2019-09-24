package ch8;

import java.util.Optional;
import java.util.concurrent.Callable;

public class BreaksAndContinue {
    public static void main(String[] args) {
        String[] arr = {"-d", "blabla", "-x.scala", "asdakdas.scala"};
        boolean foundIt = false;
        for (int i = 0; i < arr.length && !foundIt; i++) {
            if (!arr[i].startsWith("-")) {
                if (arr[i].endsWith(".scala")) {
                    foundIt = true;
                }
            }
        }
        System.out.println("Found it " + foundIt);

        Optional<String> o;

        int x = 2;
        Try<Integer> objectTry = tryThis(() -> {
            if (x == 1) {
                return 1;
            } else {
                throw new RuntimeException();
            }
        });
    }

    public static <T> Try<T> tryThis(Callable<T> r) {
        try {
            return new Try(r.call());
        }catch (Exception e ) {
            return new Try(e);
        }
    }
}
class Try<T> {
    private T value;
    private Exception e;

    public Try(T value) {
        this.value = value;
    }

    public Try(Exception e) {
        this.e = e;
    }
}