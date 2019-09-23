package ch8;

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
    }
}
