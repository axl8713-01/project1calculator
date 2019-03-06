package functions;

abstract class Function{

    public Function(){
    }

    abstract double evaluate(double val);
    abstract Function derivative();
//    abstract double integral(double A, double B, int num);
    abstract boolean isConstant();
}
