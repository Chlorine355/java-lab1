import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;


/**
 * Class to print complex numbers and execute commands.
 *
 * @author Андрейка Акимов
 */
public class ComplexIO {
    /**
     * Method to print a complex number with a newline
     * @param c number to be printed
     */
    public static void println(Complex c) {
        System.out.printf("%.3f", c.getReal());
        if (c.getImag() != 0) {
            if (c.getImag() > 0) {
                System.out.printf(" + %.3fi", c.getImag());
            } else {
                System.out.printf("-%.3fi", -c.getImag());
            }
        }
        System.out.print('\n');
    }
    /**
     * Method to print a complex number without a newline
     * @param c number to be printed
     */
    public static void print(Complex c) {
        System.out.printf("%.3f", c.getReal());
        if (c.getImag() != 0) {
            if (c.getImag() > 0) {
                System.out.printf(" + %.3fi", c.getImag());
            } else {
                System.out.printf("-%.3fi", -c.getImag());
            }
        }
        // System.out.print('\n');
    }

    /**
     * Method to print a complex number in trigonometric form with a newline
     * @param c number to be printed
     */
    public static void printlnT(Complex c) {
        System.out.printf("%.3f(cos(%.3f) + isin(%.3f))\n", c.abs(), c.arg(), c.arg());
    }

    /**
     * Method to print a complex number in trigonometric form without a newline
     * @param c number to be printed
     */
    public static void printT(Complex c) {
        System.out.printf("%.3f(cos(%.3f) + isin(%.3f))", c.abs(), c.arg(), c.arg());
    }

    /**
     * Method to accept and execute commands from user
     */
    public static void loop() {
        Complex a, b;
        System.out.println("""
                Введите команду:
                add - сложить 2 комплексных числа
                sub - вычесть второе комплексное число из первого
                mult - перемножить 2 комплексных числа
                print - вывести комплексное число
                trig - вывести комплексное число в тригонометрической форме
                exit - выйти""");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        String command = scanner.nextLine();
        while (!Objects.equals(command, "exit")) {
            switch (command) {
                case "add" -> {
                    System.out.println("Введите действительную и комплексную часть первого числа через пробел:");
                    a = new Complex(scanner.nextDouble(), scanner.nextDouble());
                    System.out.println("Введите действительную и комплексную часть второго числа через пробел:");
                    b = new Complex(scanner.nextDouble(), scanner.nextDouble());
                    ComplexIO.println(a.add(b));
                }
                case "sub" -> {
                    System.out.println("Введите действительную и комплексную часть первого числа через пробел:");
                    a = new Complex(scanner.nextDouble(), scanner.nextDouble());
                    System.out.println("Введите действительную и комплексную часть второго числа через пробел:");
                    b = new Complex(scanner.nextDouble(), scanner.nextDouble());
                    ComplexIO.println(a.subtract(b));
                }
                case "mult" -> {
                    System.out.println("Введите действительную и комплексную часть первого числа через пробел:");
                    a = new Complex(scanner.nextDouble(), scanner.nextDouble());
                    System.out.println("Введите действительную и комплексную часть второго числа через пробел:");
                    b = new Complex(scanner.nextDouble(), scanner.nextDouble());
                    ComplexIO.println(a.multiply(b));
                }
                case "print" -> {
                    System.out.println("Введите действительную и комплексную часть через пробел:");
                    a = new Complex(scanner.nextDouble(), scanner.nextDouble());
                    ComplexIO.println(a);
                }
                case "trig" -> {
                    System.out.println("Введите действительную и комплексную часть через пробел:");
                    a = new Complex(scanner.nextDouble(), scanner.nextDouble());
                    ComplexIO.printlnT(a);
                }
                case "" -> {command = scanner.nextLine();continue;}
                default -> {System.out.println("Неверная команда!");}
            }
            System.out.println("""
                    Введите команду:
                    add - сложить 2 комплексных числа
                    sub - вычесть второе комплексное число из первого
                    mult - перемножить 2 комплексных числа
                    print - вывести комплексное число
                    trig - вывести комплексное число в тригонометрической форме
                    exit - выйти""");
            command = scanner.nextLine();
        }
    }
}
