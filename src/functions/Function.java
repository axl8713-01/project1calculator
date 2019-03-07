package functions;

public abstract class Function{

    private boolean constant;

    public Function(){
    }

    public abstract double evaluate(double val);
    public abstract Function derivative();
//    abstract double integral(double A, double B, int num);
    public abstract boolean isConstant();
}
