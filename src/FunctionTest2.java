import functions.*;

/**
 *
 *
 * @author Albin Liang
 */

public class FunctionTest2 {
    public static void main( String[] args ) {
        Variable var = Variable.X;

        Sum test1 = new Sum(
                new Product(var, var),
                new Cosine(new Product(new Constant(2), Variable.X)),
                new Constant(7));
        System.out.println(test1);

        Product test2 = new Product( new Constant(15),
                var, var, var, var, var);
        System.out.println(test2.integral(0, 10, 1000000));
    }
}
