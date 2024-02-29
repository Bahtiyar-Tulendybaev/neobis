import java.util.Scanner;

public class PopulationIncrease {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());

        for(int a = 0; a < t; ++a) {
            String[] str = scan.nextLine().split(" ");
            int pa = Integer.parseInt(str[0]);
            int pb = Integer.parseInt(str[1]);
            double g1 = Double.parseDouble(str[2]);
            double g2 = Double.parseDouble(str[3]);
            int n = 0;

            while(pa <= pb) {
                pa = (int)((double)pa + (double)pa * (g1 / 100.0));
                pb = (int)((double)pb + (double)pb * (g2 / 100.0));
                ++n;
                if (n > 100) {
                    break;
                }
            }

            System.out.println(n <= 100 ? n + " anos." : "Mais de 1 seculo.");
        }
    }
}