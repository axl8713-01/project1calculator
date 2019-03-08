import functions.*;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 * @author Albin Liang
 * @accrediation Heavily borrowed and reused code from FnTest2.
 */

public class FunctionTest1 {
    public static void main( String[] args ) {
        if (args.length != 0) {
            System.err.println("FuntionTest1 takes no command line arguments.");
            System.exit(1);
        }

        final Function sin = new Sine(Variable.X);
        final Function cos = new Cosine(Variable.X);
        List<Function> functions = new ArrayList<>() {{
            add(sin);
            add(cos);
            add(cos.derivative());
            add(new Sum(Variable.X, new Constant(1.5),
                    new Sum(Variable.X, new Constant(2.0))
            ));
            add(new Sum(new Product(Variable.X, new Constant(1.5)),
                    new Product(Variable.X, new Constant(2.0))
            ));
        }};

        for (Function func : functions) {
            System.out.println(func + " is " +
                    (func.isConstant() ? "" : "not ") +
                    "a constant.");
            System.out.println("The derivative of " + func +
                    " is " + func.derivative() +
                    ", which is " +
                    (func.derivative().isConstant() ? "" : "not ") +
                    "a constant.");
        }

        System.out.println();

        System.out.printf("%4s %8s %8s %8s %8s %8s\n",
                "x", "sin", "cos", "cos'", "fn#4", "fn#5");
        System.out
                .println("=================================================");
        for (double x = 0; x <= Math.PI; x += 0.1) {
            System.out.printf("%4.2f", x);
            for (Function f : functions) {
                System.out.printf(" %8.4f", f.evaluate(x));
            }
            System.out.println();
        }
        System.out.println();


        Variable var = Variable.X;

        Function s1 = new Sum(var);
        Function s2 = new Sum(new Constant(0));
        Function s3 = new Sum(var, new Constant(2));
        Function s4 = new Sum(s3, s2, s1);
        Function s5 = new Sum(s4, new Constant(1234.4321), new Constant(4321.1234));
        System.out.println("Conducting Basic Tests of Sums\n");
        System.out.println("Testing single variable sum: \n s1: " + s1.toString() + "\nExpected Output: x\n");
        System.out.println("Testing single constant zero in sum: \n s2: " + s2.toString() + "\nExpected Output: 0.0\n");
        System.out.println("Testing basic constant plus var: \n s3: " + s3.toString() + "\nExpected Output: ( x + 2.0 )\n");
        System.out.println("Testing sum of sums: \n s4: " + s4.toString() + "\nExpected Output: ( ( x + 2.0 ) + x )\n");
        System.out.println("Testing more sums: \n s5: " + s5.toString() + "\nExpected Output: ( ( ( x + 2.0 ) + x ) + 5555.5555 )\n");
        System.out.println("Testing derivatives on sums: \n s5 derivative: " + s5.derivative().toString() + "\nExpected Output: 2.0 \n");


        Function p1 = new Product(new Constant(0));
        Function p2 = new Product(var);
        Function p3 = new Product(var, new Constant(0));
        Function p4 = new Product(var, new Constant(1));
        Function p5 = new Product(p4, p2, new Constant(4321));


        Function s6 = new Sum(p5, p5);
        Function p6 = new Product(s5, s5);

    }
}

