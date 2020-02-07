import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {

        // Created two scanners due to 1 scanner not being able to read in all inputs
        //Multiple scanner objects are not advised
        Scanner input = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        Visitor visitor1 = new Visitor();

        System.out.println("Please enter full name: ");
        String name = input.nextLine();
        visitor1.fullName = name;

        System.out.println("Please enter age: ");
        int age = input.nextInt();
        visitor1.age = age;

        System.out.println("Please enter the comment: ");
        String comments = stringScanner.nextLine();
        visitor1.comments = comments;

        System.out.println("Please enter the assistant's name: ");
        String assist = stringScanner.nextLine();
        visitor1.assist = assist;

        visitor1.save();
        visitor1.load("Tlou Rocko");
    }
}
