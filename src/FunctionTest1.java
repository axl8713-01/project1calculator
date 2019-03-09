import functions.*;

import java.util.ArrayList;
import java.util.List;


/**
 * FunctionTest1 is a test suite class that will perform extensive tests of part one of the project.
 * Some of the code is heavily based on the code from FnTests2 with more extensive values and tests..
 *
 * @author Albin Liang
 *
 */

public class FunctionTest1 {
    public static void main( String[] args ) {
        if (args.length != 0) {
            System.err.println("FunctionTest1 takes no command line arguments.");
            System.exit(1);
        }

        Variable var = Variable.X;
        System.out.println("Conducting Basic Tests of Sums\n");
        final Function s1 = new Sum(new Constant(0));
        System.out.println("Testing single constant zero in sum: \n s1: " + s1.toString() + "\nExpected Output: 0.0\n");
        final Function s2 = new Sum(var);
        System.out.println("Testing single var: \n s2: " + s2.toString() + "\nExpected Output:  x \n");
        final Function s3 = new Sum(var, new Constant(2));
        System.out.println("Testing basic constant plus var: \n s3: " + s3.toString() + "\nExpected Output: ( x + 2.0 )\n");
        final Function s4 = new Sum(s3, s2, s3, s2, s3, s1);
        System.out.println("Testing sum of sums and multiple variable and zero with non-constant terms:" +
                " \n s4: " + s4.toString() + "\nExpected Output: (( x + 2.0 ) + x + ( x + 2.0 ) + x + " +
                "( x + 2.0 ) )\n");
        final Function s5 = new Sum(s4, s3, s2, new Constant(1234.4321), new Constant(4321.1234), new Constant(9876.6789));
        System.out.println("Testing sum creation with multiple sums and constants:" +
                " \n s5: " + s5.toString() + "\nExpected Output: (( x + 2.0 ) + x + ( x + 2.0 ) + x + " +
                "( x + 2.0 ) + ( x + 2.0 ) + x + 15432.234400000001)\n");
        List<Function> functions = new ArrayList<>() {{
            add(s1);
            add(s2);
            add(s3);
            add(s4);
            add(s5);
            add(new Sum(var, var, var, var,  new Constant(1.5),
                    new Sum(var, new Constant(2.0))
            ));
        }};

        System.out.println("Conducting Tests of Sums evaluate, derivatives, and, isConstant, \n");

        for (Function func : functions) {
            System.out.println("function: " + func + " is " +
                    (func.isConstant() ? "" : "not ") +
                    "a constant.");

            System.out.println("function is " + func.evaluate(25.52) + " evaluated at 25.52");

            System.out.println("The derivative of " + func +
                    " is " + func.derivative() +
                    ", which is " +
                    (func.derivative().isConstant() ? "" : "not ") +
                    "a constant.\n");
        }
    }
}

