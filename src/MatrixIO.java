import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class to print matrices and execute commands.
 *
 * @author Андрейка Акимов
 */
public class MatrixIO {
    /**
     * Method to print a matrix
     * @param matr matrix to be printed
     */
    static void print(Matrix matr) {
        for (int i = 0; i < matr.getRows(); i++) {
            for (int j = 0; j < matr.getCols(); j++) {
                ComplexIO.print(matr.getMatrix()[i][j]);
                System.out.print("      ");
            }
            System.out.println();
        }
    }
    /**
     * Method to accept and execute commands from user
     */
    public static void loop() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        Matrix a, b;
        System.out.println("""
                Введите команду:
                add - сложить 2 матрицы
                sub - вычесть вторую матрицу из первой
                mult - перемножить 2 матрицы, если возможно
                multf - умножить матрицу на число
                trans - транспонировать матрицу
                det - вывести определитель матрицы
                exit - выйти""");
        String command = scanner.nextLine();
        while (!Objects.equals(command, "exit")) {
            switch (command) {
                case "add" -> {
                    a = inputmatrix();
                    b = inputmatrix();
                    MatrixIO.print(a.add(b));
                    // System.out.println("Нажмите Enter для продолжения");
                }
                case "sub" -> {
                    a = inputmatrix();
                    b = inputmatrix();
                    MatrixIO.print(a.subtract(b));
                }
                case "mult" -> {
                    a = inputmatrix();
                    b = inputmatrix();
                    MatrixIO.print(a.multiply(b));
                }
                case "multf" -> {
                    a = inputmatrix();
                    System.out.println("Введите множитель:");
                    double f = scanner.nextDouble();
                    MatrixIO.print(a.multiply(f));
                }
                case "trans" -> {
                    a = inputmatrix();
                    MatrixIO.print(a.transpose());
                }
                case "det" -> {
                    a = inputmatrix();
                    ComplexIO.println(a.determinant());
                }
                case "" -> {command = scanner.nextLine();continue;}
                default -> {System.out.println("Неверная команда!");}
            }
            System.out.println("""
                    Введите команду:
                    add - сложить 2 матрицы
                    sub - вычесть вторую матрицу из первой
                    mult - перемножить 2 матрицы, если возможно
                    multf - умножить матрицу на число
                    trans - транспонировать матрицу
                    det - вывести определитель матрицы
                    exit - выйти""");
            command = scanner.nextLine();
        }
    }
    /**
     * Method to accept a matrix from user
     * @return the accepted matrix
     */
    public static Matrix inputmatrix() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        System.out.println("Введите высоту и ширину матрицы через пробел:");
        int rows, cols;
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        System.out.println("Введите матрицу:");
        Matrix a = new Matrix(rows, cols);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                String input = scanner.next();
                double real = Double.parseDouble(input.split(",")[0]);
                double imag = Double.parseDouble(input.split(",")[1]);
                a.assign(i, j, new Complex(real, imag));
            }
        }
        return a;
    }
}