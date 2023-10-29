public class Main {
    public static void main(String[] args) {
        String[][] matrix = new String[7][7];
        Integer [][] matrix1 = new Integer[7][7];
        String s = "* ";
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                matrix[i][j] = "$ ";
                matrix1[i][j] = 0;

            }
        }
        //SHIP 1X3
        int x1 = (int) Math.floor(Math.random() * 5);
        int y1 = (int) Math.floor(Math.random() * 5);
        for (int i = 0; i < 3; i++) {
            if (x1 >= y1) {
                matrix[x1 + i][y1] = s;
                try {
                    matrix1[x1 + i][Math.abs(y1 - 1)] = 2;
                    matrix1[x1 + i][Math.abs(y1 + 1)] = 2;

                    matrix1[Math.abs(x1 - 1)][y1 - 1 + i] = 2;
                    matrix1[Math.abs(x1 + 3)][y1 - 1 + i] = 2;

                    matrix1[x1 + i][y1] = 1;
                }catch (ArrayIndexOutOfBoundsException e){
                    matrix1[x1 + i][y1] = 1;
                }
            }
            else {
                try {
                    matrix[x1][y1 + i] = s;
                    matrix1[Math.abs(x1 - 1)][y1 + i] = 2;
                    matrix1[Math.abs(x1 + 1)][y1 + i] = 2;

                    matrix1[x1 - 1 + i][Math.abs(y1 - 1)] = 2;
                    matrix1[x1 - 1 + i][Math.abs(y1 + 3)] = 2;

                    matrix1[x1][y1 + i] = 1;
                }catch (ArrayIndexOutOfBoundsException e){
                    matrix1[x1][y1 + i] = 1;
                }
            }
        }



        //SHIPS 1x2
        int temp = 0;
        while(temp!=2){
            int x2 = (int) Math.floor(Math.random() * 6);
            int y2 = (int) Math.floor(Math.random() * 6);
            if(matrix1[x2][y2] != 0){
                continue;
            }
            if (x2>=y2) {
                if(matrix1[Math.abs(x2 -1)][y2] != 0){
                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    try {
                        matrix1[Math.abs(x2 - i)][y2] = 1;
                        matrix[Math.abs(x2 - i)][y2]=s;
                        matrix1[x2 - i][Math.abs(y2-1)] = 2;
                        matrix1[x2 - i][Math.abs(y2+1)] = 2;
                        for (int j = 0; j <3 ; j++){
                            try {


                                matrix1[x2 + 1][y2 - 1 + j] = 2;
                                matrix1[x2 - 2][y2 - 1 + j] = 2;
                            }catch (ArrayIndexOutOfBoundsException e){

                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException e){

                    }
                }
            }else{
                if(matrix1[x2][Math.abs(y2 - 1)] != 0){
                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    try {
                        matrix1[x2][Math.abs(y2 - i)] = 1;
                        matrix[x2][Math.abs(y2 - i)] = s;
                        matrix1[Math.abs(x2 - 1)][y2 - i] = 2;
                        matrix1[x2 + 1][y2 - i] = 2;
                        for (int j = 0; j <4 ; j++){
                            try {
                                matrix1[x2+1 - i][y2+1] = 2;
                                matrix1[x2 + 1 - i][y2 - 2] = 2;

                            }catch (ArrayIndexOutOfBoundsException e){

                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException e){

                    }
                }

            }
            temp++;


        }







        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
//        for (int i = 0; i < 7; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(matrix1[i][j]);
//            }
//            System.out.println();
//        }
    }
}