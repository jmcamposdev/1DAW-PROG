package RelacionEjercicios2;

public class Ejercicio07 {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    for (int l = 0; l <= 9; l++) {
                        for (int m = 0; m <= 9; m++) {
                            if (i == 3) {
                                System.out.print("E-");
                            } else {
                                System.out.print(i + "-");
                            }
                            if (j == 3) {
                                System.out.print("E-");
                            } else {
                                System.out.print(j + "-");
                            }
                            if (k == 3) {
                                System.out.print("E-");
                            } else {
                                System.out.print(k + "-");
                            }
                            if (l == 3) {
                                System.out.print("E-");
                            } else {
                                System.out.print(l + "-");
                            }
                            if (m == 3) {
                                System.out.print("E");
                            } else {
                                System.out.print(m);
                            }
                            System.out.println("");
                        }
                    }
                }
            }
        }
    }
}
