public class IJ {
    public static void main(String[] args) {
        double[][] array = new double[3][2];
        double count = 1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                array[i][1] = count;
                if(j == 0){
                    System.out.print("I=" + String.format("%.0f",array[i][j]));
                }else if(j == 1){
                    System.out.print(" J=" + String.format("%.0f",array[i][j]));
                }

            }
            System.out.println();
            count++;
        }


        for(int v = 0; v < 10; v++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {

                    array[i][j] += 0.2;
                    if(v == 9 || v == 4){
                        if(j == 0){
                            System.out.print("I=" + String.format("%.0f",array[i][j]));
                        }else if(j == 1){
                            System.out.print(" J=" + String.format("%.0f",array[i][j]));
                        }
                    }
                    else if(j == 0){
                        System.out.print("I=" + String.format("%.1f",array[i][j]));
                    }else if(j == 1){
                        System.out.print(" J=" + String.format("%.1f",array[i][j]));
                    }

                }
                System.out.println();
            }
        }


    }
}