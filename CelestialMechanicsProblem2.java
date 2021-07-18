import java.text.DecimalFormat;

public class CelestialMechanicsProblem2
{
    public void problem2Solver( double a, double ecc, double i, double Anomaly, double w, double Omega, double myu, double t)
    {
        i = i * Math.PI/180;
        double n = Math.sqrt(1 / (a*a*a));
        double to = ((w - Anomaly) / n) * Math.PI/180;

        double gamma = 1 + myu;
        double L = (myu) * Math.sqrt(gamma*a);
        double G = L * Math.sqrt(1 - ecc*ecc);
        double bigTheta = G*Math.cos(i);

        double l = n * (t*2*Math.PI) + to;
        double g = (w - Omega) * Math.PI/180;
        double theta = Omega * Math.PI/180;
        double H = -myu*gamma / (2*a);

        double FirstPoincare11 = L;
        double FirstPoincare12 = L - G;
        double FirstPoincare13 = G - bigTheta;
        double FirstPoincare21 = l + g + theta;
        double FirstPoincare22 = -g - theta;
        double FirstPoincare23 = -theta;
        double SecondPoincare11 = FirstPoincare11;
        double SecondPoincare12 = Math.sqrt(2 * (L - G)) * Math.cos(g + theta);
        double SecondPoincare13 = Math.sqrt(2 * (G - bigTheta)) * Math.cos(theta);
        double SecondPoincare21 = FirstPoincare21;
        double SecondPoincare22 = -Math.sqrt(2 * (L - G)) * Math.sin(g + theta);
        double SecondPoincare23 = -Math.sqrt(2 * (G - bigTheta)) * Math.sin(theta);

        System.out.println("L: "+ L);
        System.out.println("G: "+ G);
        System.out.println("ThetaBig: "+ bigTheta);
        System.out.println("l: "+ l);
        System.out.println("g: "+ g);
        System.out.println("thetaSmall: "+ theta);
        System.out.println("H:" + H);
        System.out.println("FirstPoincare11: "+ FirstPoincare11);
        System.out.println("FirstPoincare12: "+ FirstPoincare12);
        System.out.println("FirstPoincare13: "+ FirstPoincare13);
        System.out.println("FirstPoincare21: "+ FirstPoincare21);
        System.out.println("FirstPoincare22: "+ FirstPoincare22);
        System.out.println("FirstPoincare23: "+ FirstPoincare23);
        System.out.println("SecondPoincare11: "+ SecondPoincare11);
        System.out.println("SecondPoincare12: "+ SecondPoincare12);
        System.out.println("SecondPoincare13: "+ SecondPoincare12);
        System.out.println("SecondPoincare21: "+ SecondPoincare21);
        System.out.println("SecondPoincare22: "+ SecondPoincare22);
        System.out.println("SecondPoincare23: "+ SecondPoincare23);
    }

    public static void main(String[] args)
    {
        CelestialMechanicsProblem2 nebesnaMehanika = new CelestialMechanicsProblem2();
        double birthdayToT = (352/365.25);
        System.out.println("Mercury");
        nebesnaMehanika.problem2Solver(0.387, 0.205, 7.004, 252.250, 77.457, 48.330, 1.6601368e-7, birthdayToT);
        System.out.println("Venus");
        nebesnaMehanika.problem2Solver(0.723, 0.006, 3.394, 181.979, 131.602, 76.679, 0.00000244784, birthdayToT);
        System.out.println("Earth");
        nebesnaMehanika.problem2Solver(1, 0.016, 0, 100.464, 102.937, 0,0.00000304043, birthdayToT);
        System.out.println("Mars");
        nebesnaMehanika.problem2Solver(1.523, 0.093, 1.849, -4.553, -23.943, 49.559, 3.22715145e-7,birthdayToT);
        System.out.println("Jupiter");
        nebesnaMehanika.problem2Solver(5.202, 0.048, 1.304, 34.396,14.728, 100.473, 0.00095479977, birthdayToT);
        System.out.println("Saturn");
        nebesnaMehanika.problem2Solver(9.536, 0.053, 2.485, 49.954, 92.598, 113.662, 0.00028589399, birthdayToT);
        System.out.println("Uranus");
        nebesnaMehanika.problem2Solver(19.189, 0.047, 0.772, 313.238, 170.954, 74.016, 0.00004366259, birthdayToT);
        System.out.println("Neptune");
        nebesnaMehanika.problem2Solver(30.069, 0.008, 1.770, -55.120, 44.964, 131.784, 0.00005154107, birthdayToT);
        System.out.println("Pluto");
        nebesnaMehanika.problem2Solver(39.482, 0.248, 17.140, 238.929, 224.068, 110.303, 7.40740741e-9, birthdayToT);
        System.out.println("Hello");
    }
}