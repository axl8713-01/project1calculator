package functions;

/**
 * Function is an abstract class used to represent a basic mathematical function. It's descendants include Constant,
 * Variable, Sum, Product, Sine, and Cosine.
 *
 * @author Albin Liang
 */

public abstract class Function{

    //Fields

    /**
     * no fields in function
     */

    //Constructor Function cannot be instantiated.
    public Function(){
    }

    //Methods

    /**
     * evaluate is an abstract method, each of the children have their own method of evaluating.
     *
     * @param val the double value inputted by user for for the variable.
     * @return
     */
    public abstract double evaluate(double val);

    /**
     * derivative, abstract method, find the derivative of the function, each child acts uniquely.
     * @return
     */
    public abstract Function derivative();

    /**
     * integral is a concrete method to approximate the value of the integral of the function. Constant,
     * Variable, and Sum have closed methods and will override this inherited method.
     *
     * @param A the lower limit.
     * @param B the upper limit.
     * @param num the length of sub-intervals.
     * @return
     */
    public double integral(double A, double B, int num){
        double interval = ((B-A)/num);// change in X
        double halfWidth = (((B-A)/num)/2);
        double approximation = 0.0;
        for (double i = 0.0; i<num+1; ++i){
            if (i==0.0){ //lower limit
                double firstTrapezoid = this.evaluate(A);
                approximation += firstTrapezoid;
            }
            else if(i==num){//upper limit
                double lastTrapezoid = this.evaluate(B);
                approximation += lastTrapezoid;
            }
            else {//the rest of the trapezoids.
                double middleTrapezoids =  this.evaluate((interval * i) + A)*2.0;
                approximation += (middleTrapezoids);
            }
        }
        approximation = approximation * halfWidth;
        return approximation;
    }

    /**
     * isConstant checks if a function is a constant or not. If the base case is a constant and/or all of it's leaves
     * are constant, then it is constant.
     * @return
     */
    public abstract boolean isConstant();
}
