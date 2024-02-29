import java.util.Scanner;

public class ColumnInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int position = scanner.nextInt();
        String method = scanner.next();

        double sum = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                double input = scanner.nextDouble();
                if (position == j) {
                    sum += input;
                }
            }
        }
        if (method.equalsIgnoreCase("s")) {
            System.out.printf("%.1f\n", sum);
        } else if (method.equalsIgnoreCase("m")) {
            System.out.printf("%.1f\n", (sum / 12));
        }
    }
}