package Function;

abstract class Function{

    public Function(){
    }

    abstract double evaluate();
    abstract Function derivative();
//    abstract double integral(double A, double B, int num);
    abstract boolean isConstant();
}
