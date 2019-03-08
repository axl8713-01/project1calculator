package functions;

public abstract class Function{

    //Fields

    //Constructor
    public Function(){
    }

    //Methods

    public abstract double evaluate(double val);

    public abstract Function derivative();

    public double integral(double A, double B, int num){
        double interval = ((B-A)/num);
        double halfWidth = (((B-A)/num)/2);
        double approximation = 0.0;
        for (double i = 0.0; i<num+1; ++i){
            if (i==0.0){
                double firstTrapezoid = this.evaluate(A);
//                System.out.println(trapezoid);
                approximation += firstTrapezoid;
            }
            else if(i==num){
                double lastTrapezoid = this.evaluate(B);
//                System.out.println(trapezoid);
                approximation += lastTrapezoid;
            }
            else {
                double middleTrapezoids =  this.evaluate((interval * i) + A)*2.0;
//                System.out.println(average);
                approximation += (middleTrapezoids);
            }
        }
        approximation = approximation * halfWidth;
        return approximation;
    }

    public abstract boolean isConstant();
}
