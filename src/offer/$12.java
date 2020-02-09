package offer;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-03
 */
public class $12 {

    public static double Power(double base, int exponent) {
        if (base == 0 && exponent == 0){
            throw new IllegalArgumentException();
        }
        if (exponent == 0){
            return 1;
        }
        if (exponent < 0){
            return  1/(power0(base,exponent * -1));
        }else {
            return power0(base,exponent);
        }
    }

    private static double power0(double base, int exponent){
        double result = base;
        for (int i = 1; i < exponent; i++) {
            result = base * result;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Power(1.2,-2));
    }
}
