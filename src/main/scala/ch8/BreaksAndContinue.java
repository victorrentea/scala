package ch8;

public class BreaksAndContinue {
    public static void main(String[] args) {
        String[] arr = {"-d", "blabla", "-x.scala", "asdakdas.scala"};
        int i = 0;                // This is Java
        boolean foundIt = false;
        while (i < arr.length) {
            if (arr[i].startsWith("-")) {
                i = i + 1;
                continue;
            }
            if (arr[i].endsWith(".scala")) {
                foundIt = true;
                break;
            }
            i = i + 1;
        }
        System.out.println("Found it " + foundIt);
    }
}
