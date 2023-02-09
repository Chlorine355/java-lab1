/**
 * Class representing a complex number.
 *
 * @author Андрейка Акимов
 */
public class Complex {
    /**
     * real - real part of the complex number
     */
    private final double real;

    /**
     * imag - imaginary part of complex number
     */
    private final double imag;

    /**
     * Constructor taking two doubles, the real and the imaginary values.
     *
     * @param realArg A double representing the real value.
     * @param imagArg A double representing the imaginary value.
     */
    public Complex(double realArg, double imagArg) {
        real = realArg;
        imag = imagArg;
    }

    /**
     * Constructor taking one double (real part) and setting imaginary to 0
     *
     * @param realArg A double representing the real value.
     */
    public Complex(double realArg) {
        this(realArg, 0);
    }

    /**
     * Constructor taking 1 complex number
     *
     * @param c A complex number
     */
    public Complex(Complex c) {
        this(c.getReal(), c.getImag());
    }

    /**
     * Default no-arg constructor.
     */
    public Complex() {
        this(0, 0);
    }

    /**
     * Method to obtain the sum of 2 Complex numbers
     * @param other Complex number to be added
     * @return the sum of 2 numbers
     */
    public Complex add(Complex other) {
        return new Complex(real + other.real, imag + other.imag);
    }

    /**
     * Method to obtain the difference of 2 Complex numbers
     * @param other Complex number to be subtracted
     * @return the difference of 2 numbers
     */
    public Complex subtract(Complex other) {
        return new Complex(real - other.real, imag - other.imag);
    }

    /**
     * Method to obtain the product of 2 Complex numbers
     * @param other Complex number to be multiplied
     * @return the product of 2 numbers
     */
    public Complex multiply(Complex other) {
        return new Complex(real * other.real - imag * other.imag, imag * other.real + real * other.imag);
    }

    /**
     * Method to obtain the product of a Complex number and a double
     * @param other double to be multiplied
     * @return the product of 2 numbers
     */
    public Complex multiply(double other) {
        return new Complex(real * other, imag * other);
    }

    /**
     * Method to obtain the modulus of a Complex number
     * @return modulus of the complex number
     */
    public double abs(){
        return Math.hypot(real, imag);
    }

    /**
     * Method to obtain the argument of a Complex number
     * @return the argument of a Complex number
     */
    public double arg(){
        return Math.atan2(imag, real);
    }

    /**
     * Method to obtain the real part of a Complex number
     * @return real part
     */
    public double getReal() {
        return real;
    }

    /**
     * Method to obtain the imaginary part of a Complex number
     * @return imaginary part
     */
    public double getImag() {
        return imag;
    }
}
