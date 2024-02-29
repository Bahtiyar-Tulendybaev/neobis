import java.util.Scanner;

public class Grenais {
    static int scoreInter = 0;
    static int scoreGremio = 0;
    static int empates = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 1;
        Grenais grenais = new Grenais();
        int inter = scan.nextInt();
        int gremio = scan.nextInt();
        System.out.println("Novo grenal (1-sim 2-nao)");
        int contin = scan.nextInt();

        grenais.count(inter,gremio);
        while (contin == 1){
            grenais.count(scan.nextInt(), scan.nextInt());
            System.out.println("Novo grenal (1-sim 2-nao)");
            contin = scan.nextInt();
            count++;
        }
        System.out.println(count + " grenais");
        System.out.println("Inter:" + scoreInter);
        System.out.println("Gremio:" + scoreGremio);
        System.out.println("Empates:" + empates);
        if(scoreInter > scoreGremio){
            System.out.println("Inter venceu mais");
        }else {
            System.out.println("Gremio venceu mais");
        }


    }

    private void count(int inter, int gremio){
        if(inter == gremio) empates++;
        else if(inter < gremio) scoreGremio++;
        else  if(inter > gremio) scoreInter++;
    }
}