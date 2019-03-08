package functions;

public abstract class Function{

    public Function(){
    }

    public abstract double evaluate(double val);
    public abstract Function derivative();
    public double integral(double A, double B, int num){
        double width = ((B-A)/num);
        double halfWidth = (((B-A)/num)/2);
        double approximation = 0.0;
        for (double i = 0; i<num+1; ++i){
            if (i==0){
                double trapezoid = this.evaluate(A) * halfWidth;
//                System.out.println(trapezoid);
                approximation += trapezoid;
            }
            else if(i==num-1){
                double trapezoid = this.evaluate(B) * halfWidth;
//                System.out.println(trapezoid);
                approximation += trapezoid;
            }
            else {
                double average = 2 * evaluate((width * i) + A);
//                System.out.println(average);
                approximation += (average*halfWidth);
            }

        }
        return approximation;
    }

    public abstract boolean isConstant();
}
