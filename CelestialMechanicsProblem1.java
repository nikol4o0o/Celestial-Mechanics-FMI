public class CelestialMechanicsProblem1
{
    public void problem1Solver(double a, double ecc, double tilt, double Anomaly, double w, double Omega, double myu, double t)
    {
        double theta = Omega * (Math.PI / 180);
        double g = (w - Omega) * Math.PI / 180;
        tilt = tilt * Math.PI / 180;

        double[][] thetaMatrix = {{Math.cos(theta), -Math.sin(theta), 0}, {Math.sin(theta), Math.cos(theta), 0}, {0, 0, 1}};

        double[][] tiltMatrix = {{1, 0, 0}, {0, Math.cos(tilt), -(Math.sin(tilt))}, {0, Math.sin(tilt), Math.cos(tilt)}};

        double[][] gMatrix = {{Math.cos(g), -(Math.sin(g)), 0}, {Math.sin(g), Math.cos(g), 0}, {0, 0, 1}};

        double[][] qMatrix = multiplyMatrix(3,3,(multiplyMatrix(3,3,thetaMatrix,3,3,tiltMatrix)),3,3,gMatrix);
        double[][] q1Matrix = multiplyMatrix(3,3,(multiplyMatrix(3,3,thetaMatrix,3,3,tiltMatrix)),3,3,gMatrix);

        double gama = 1 + myu;
        double n = Math.sqrt(gama/Math.pow(a, 3));
        double to = ((w - Anomaly)/n)*Math.PI/180;
        double l = n*(t*2*Math.PI) + to;
        double u = l + ecc*Math.sin(l + ecc*Math.sin(l + ecc*Math.sin(l)));

        double[][] rVector = {{Math.cos(u)-ecc}, {Math.sin(u)*Math.sqrt(1-Math.pow(ecc, 2))}, {0}};
        double[][] rResult = multiplyMatrix(3,3,multiplyMatrixWithConst(q1Matrix, a,3,3),3,1,rVector);
        double[][] vVector = {{-Math.sin(u)}, {Math.cos(u)*Math.sqrt(1-(ecc*ecc))}, {0}};
        double[][] vResult = multiplyMatrix(3,3,qMatrix,3,1,vVector);
        vResult = multiplyMatrixWithConst(vResult,(a*n),3,1);
        vResult = divideMatrixWithConstant(vResult, (1-ecc*Math.cos(u)), 3,1);
        System.out.println("R values");
        printVector(rResult);
        System.out.println("V values");
        printVector(vResult);
        System.out.println("|R| value");
        System.out.println(secondNorm(rResult));
        System.out.println("|V| value");
        System.out.println(secondNorm(vResult));

    }


    private double[][] multiplyMatrixWithConst(double[][] matrix, double cosnstant, int rowsNumber, int colsNumber)
    {
        for(int i = 0; i < rowsNumber; i++)
        {
            for (int j = 0; j < colsNumber; j++)
            {
                matrix[i][j] = matrix[i][j]*cosnstant;
            }
        }
        return matrix;
    }
    private double[][] divideMatrixWithConstant(double[][] matrix, double cosnstant, int rowsNumber, int colsNumber)
    {
        for(int i = 0; i < rowsNumber; i++)
        {
            for (int j = 0; j < colsNumber; j++)
            {
                matrix[i][j] = matrix[i][j]/cosnstant;
            }
        }
        return matrix;
    }

    private double[][] multiplyMatrix(int row1, int col1, double A[][], int row2, int col2, double B[][])
    {
        double[][] tempMatrix = new double[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++)
                    tempMatrix[i][j] += A[i][k] * B[k][j];
            }
        }
        return tempMatrix;
    }

    double secondNorm(double[][] a)
    {
        double c = 0.0;
        for (int i = 0; i < 3; i++)
        {
                c+= a[i][0] * a[i][0];
        }

        return Math.sqrt(c);
    }

    public void printVector(double[][] vec)
    {
        for (double[] doubles : vec)
        {
            System.out.println(doubles[0]);
        }
    }
    public static void main(String[] args)
    {
        CelestialMechanicsProblem1 nebesnaMehanika = new CelestialMechanicsProblem1();
        double birthdayToT = (352/365.25);
        System.out.println("Mercury");
        nebesnaMehanika.problem1Solver(0.387, 0.205, 7.004, 252.250, 77.457, 48.330, 1.6601368e-7, birthdayToT);
        System.out.println("Venus");
        nebesnaMehanika.problem1Solver(0.723, 0.006, 3.394, 181.979, 131.602, 76.679, 0.00000244784, birthdayToT);
        System.out.println("Earth");
        nebesnaMehanika.problem1Solver(1, 0.016, 0, 100.464, 102.937, 0,0.00000304043, birthdayToT);
        System.out.println("Mars");
        nebesnaMehanika.problem1Solver(1.523, 0.093, 1.849, -4.553, -23.943, 49.559, 3.22715145e-7,birthdayToT);
        System.out.println("Jupiter");
        nebesnaMehanika.problem1Solver(5.202, 0.048, 1.304, 34.396,14.728, 100.473, 0.00095479977, birthdayToT);
        System.out.println("Saturn");
        nebesnaMehanika.problem1Solver(9.536, 0.053, 2.485, 49.954, 92.598, 113.662, 0.00028589399, birthdayToT);
        System.out.println("Uranus");
        nebesnaMehanika.problem1Solver(19.189, 0.047, 0.772, 313.238, 170.954, 74.016, 0.00004366259, birthdayToT);
        System.out.println("Neptune");
        nebesnaMehanika.problem1Solver(30.069, 0.008, 1.770, -55.120, 44.964, 131.784, 0.00005154107, birthdayToT);
        System.out.println("Pluto");
        nebesnaMehanika.problem1Solver(39.482, 0.248, 17.140, 238.929, 224.068, 110.303, 7.40740741e-9, birthdayToT);

    }
}