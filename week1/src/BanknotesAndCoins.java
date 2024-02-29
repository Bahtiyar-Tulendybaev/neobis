import java.util.Scanner;
public class BanknotesAndCoins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num = scan.nextDouble();
        int[] banknotes = {100, 50, 20, 10, 5, 2};
        int[] coins = {505, 25, 10, 5, 1};
        System.out.println("NOTAS:");
        for(int banknote : banknotes){
            int numOfCurrBanknote = (int) (num / banknote);
            System.out.println(numOfCurrBanknote + " nota(s) de R$ " + String.format("%.2f", (double)banknote));
            num -= numOfCurrBanknote * banknote;
        }
        System.out.println("MOEDAS:");
        if(num >= 1){
            System.out.println("1 moeda(s) de R$ 1.00");
            num -= 1;
        }
        int n = (int)(num*100);

        for(int coin : coins){
            int numOfCurrCoins = (int) (n / coin);
            System.out.println(numOfCurrCoins + " moeda(s) de R$ " + String.format("%.2f", (double) coin / 100));
            n  -= numOfCurrCoins * coin;
        }
    }
}