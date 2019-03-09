import functions.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Albin Liang
 */

public class FunctionTest2 {
    public static void main( String[] args ) {
        if (args.length != 0) {
            System.err.println("FunctionTest2 takes no command line arguments.");
            System.exit(1);
        }

        Variable var = Variable.X;
        System.out.println("Conducting Basic Tests on sums, products, sine, and cosine\n");

        final Function sum1 = new Sum(new Constant(0));
        System.out.println("Testing single constant zero in sum: \n sum1: " + sum1.toString() +
                "\nExpected Output: 0.0\n");

        final Function sum2 = new Sum(var);
        System.out.println("Testing single var in sum: \n sum2: " + sum2.toString() +
                "\nExpected Output:  x \n");

        final Function pro1 = new Product(new Constant(0));
        System.out.println("Testing single constant zero in product: \n pro1: " + pro1.toString() +
                "\nExpected Output: 0.0\n");

        final Function pro2 = new Product(var);
        System.out.println("Testing single var in product: \n pro2: " + pro2.toString() + "\nExpected Output: x \n");

        final Function sin1 = new Sine(new Constant(0));
        System.out.println("Testing Sine with a basic zero for subordinate: \n " + sin1.toString() +
                "\nExpected Output: sin( 0.0 ) \n");

        final Function sin2 = new Sine(var);
        System.out.println("Testing Sine with a simple var for subordinate: \n " + sin2.toString() +
                "\nExpected Output: sin ( x ) \n");

        final Function cos1 = new Cosine(new Constant(0));
        System.out.println("Testing Cosine with a basic zero for subordinate: \n " + cos1.toString() +
                "\nExpected Output: cos ( 0.0 ) \n");

        final Function cos2 = new Cosine(var);
        System.out.println("Testing Coine with a simple var for subordinate: \n " + cos2.toString() +
                "\nExpected Output: cos ( x ) \n");

        final Function sum3 = new Sum(var, new Sum(var, new Constant(135.531)));
        System.out.println("Testing sums with vars and constants: \n " + sum3.toString() + "\nExpected Output: " +
                " ( x + ( x + 135.531 ) ) \n");

        final Function sum4 = new Sum(new Product(sum3, sum3), new Product(new Constant(30), var, var));
        System.out.println("Testing sums with complex products: \n " + sum4.toString() +
                "\nExpected Output: ( ( ( x + ( x + 135.531 ) ) * ( x + ( x + 135.531 ) ) ) + ( x * x * 30.0 ) ) \n");

        final Function pro3 = new Product(var, var, sum3, sum4);
        System.out.println("Testing complex product: \n " + pro3.toString() +
                "\nExpected Output:  ( x * x * ( x + ( x + 135.531 ) ) * ( ( ( x + ( x + 135.531 ) )" +
                " * ( x + ( x + 135.531 ) ) ) + ( x * x * 30.0 ) ) ) \n");

        final Function sin3 = new Sine(new Sum(pro3,sum4));
        System.out.println("Testing sine with complex subordinate: \n " + sin3.toString() + "\nExpected Output: " +
                " sin( ( ( x * x * ( x + ( x + 135.531 ) ) * ( ( ( x + ( x + 135.531 ) ) * ( x + ( x + 135.531 ) ) ) + " +
                "( x * x * 30.0 ) ) ) + ( ( ( x + ( x + 135.531 ) ) * ( x + ( x + 135.531 ) ) ) + ( x * x * 30.0 ) ) ) )\n");

        final Function cos3 = new Cosine(new Product(sum3,sum2, pro3));
        System.out.println("Testing cosine with complex subordinate: \n " + cos3.toString() +
                "\nExpected Output:  cos( ( ( x + ( x + 135.531 ) ) * x * ( x * x * ( x + ( x + 135.531 ) )" +
                " * ( ( ( x + ( x + 135.531 ) ) * ( x + ( x + 135.531 ) ) ) + ( x * x * 30.0 ) ) ) ) ) \n");

        final Function pro4 = new Product(pro3, cos3);
        System.out.println("Testing sine with complex subordinate: \n " + pro4.toString() + "\nExpected Output:" +
                " ( ( x * x * ( x + ( x + 135.531 ) ) * ( ( ( x + ( x + 135.531 ) ) * " +
                "( x + ( x + 135.531 ) ) ) + ( x * x * 30.0 ) ) ) * cos( ( ( x + ( x + 135.531 ) ) * x * " +
                "( x * x * ( x + ( x + 135.531 ) ) * ( ( ( x + ( x + 135.531 ) ) * ( x + ( x + 135.531 ) ) ) + " +
                "( x * x * 30.0 ) ) ) ) ) ) \n");

        final Function pro5 = new Product(pro3, sin3);
        System.out.println("Testing cosine with complex subordinate: \n " + pro5.toString() +
                "\nExpected Output:\n ( ( x * x * ( x + ( x + 135.531 ) ) * ( ( ( x + ( x + 135.531 ) )" +
                " * ( x + ( x + 135.531 ) ) ) + ( x * x * 30.0 ) ) ) * sin( ( ( x * x * ( x + ( x + 135.531 ) )" +
                " * ( ( ( x + ( x + 135.531 ) ) * ( x + ( x + 135.531 ) ) ) + ( x * x * 30.0 ) ) ) + " +
                "( ( ( x + ( x + 135.531 ) ) * ( x + ( x + 135.531 ) ) ) + ( x * x * 30.0 ) ) ) ) ) \n");


        List<Function> functions = new ArrayList<>() {{
            add(sum1);
            add(sum2);
            add(pro1);
            add(pro2);
            add(sin1);
            add(sin2);
            add(cos1);
            add(cos2);
            add(sum3);
            add(sum4);
            add(pro3);
            add(sin3);
            add(cos3);
            add(pro4);
            add(pro5);
        }};

        System.out.println("Conducting all methods test on functions \n");

        for (Function func : functions) {
            System.out.println("function: " + func + " is " +
                    (func.isConstant() ? "" : "not ") +
                    "a constant.");

            System.out.println("function is " + func.evaluate(25.52) + " evaluated at 25.52");

            System.out.println("The derivative of " + func +
                    " is " + func.derivative() +
                    ", which is " +
                    (func.derivative().isConstant() ? "" : "not ") +
                    "a constant.");
            System.out.println("The integral of " + func +
                    " is " + func.integral(0, 10, 10000000) +
                    ", which is evaluated from 0 to " +
                    "10 with length of 1 * 10^6\n");
        }
    }
}
