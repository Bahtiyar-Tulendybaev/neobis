import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt();
        int x = scanner.nextInt();
        int y = 0;

        for(int i = 1; i <= x; i++){
            if(y != column - 1){
                System.out.print(i + " ");
                y++;
            }else {
                System.out.println(i);
                y = 0;
            }
        }
    }
}