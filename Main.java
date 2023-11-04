import com.sun.jdi.Value;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();

            //OUTPUT
        boolean flag = false;
        Map<String,Integer> players = new HashMap<>();

        do{
            String[][] matrix = new String[7][7];
            Integer[][] matrix1 = new Integer[7][7];
            System.out.println("Enter coordinates");
            System.out.println();
            ships(matrix,matrix1);
            int numbofshots = 0;
            int ship3 = 0;
            int ship21 = 0;
            int ship22 = 0;
            int ship1 = 0;
            while (true) {
                System.out.println("  1 2 3 4 5 6 7 ");
                for(int i = 0; i < 7; i++){
                    System.out.print(i+1 + " ");
                    for(int j = 0; j<7;j++){
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.print(i+1 + " ");
                    System.out.println();
                }
                System.out.println("  1 2 3 4 5 6 7 ");
                int shotx = scanner.nextInt();
                int shoty = scanner.nextInt();

                if (matrix[shoty - 1][shotx - 1].equals("X") || matrix[shoty - 1][shotx - 1].equals("x")){
                    System.out.println("You have already shoot there!");
                }
                else {
                    if (matrix1[shoty - 1][shotx - 1] == 3) {
                        ship3++;
                        if (ship3 < 3) {
                            System.out.println("Hit!");
                            matrix[shoty - 1][shotx - 1] = "X";
                        }
                        if (ship3 >= 3) {
                            System.out.println("Sunk!");
                            matrix[shoty - 1][shotx - 1] = "X";
                        }
                    }
                    if (matrix1[shoty - 1][shotx - 1] == 2) {
                        ship21++;
                        if (ship21 < 2) {
                            System.out.println("Hit!");
                            matrix[shoty - 1][shotx - 1] = "X";
                        }
                        if (ship21 >= 2) {
                            System.out.println("Sunk!");
                            matrix[shoty - 1][shotx - 1] = "X";
                        }

                    }
                    if (matrix1[shoty - 1][shotx - 1] == 4) {
                        ship22++;
                        if (ship22 < 2) {
                            System.out.println("Hit!");
                            matrix[shoty - 1][shotx - 1] = "X";
                        }
                        if (ship22 >= 2) {
                            System.out.println("Sunk!");
                            matrix[shoty - 1][shotx - 1] = "X";
                        }
                    }
                    if (matrix1[shoty - 1][shotx - 1] == 1) {
                        System.out.println("Sunk!");
                        matrix[shoty - 1][shotx - 1] = "X";
                        ship1++;
                    }
                    if (matrix1[shoty - 1][shotx - 1] == 9 || matrix1[shoty - 1][shotx - 1] == 0) {
                        System.out.println("Miss!");
                        matrix[shoty - 1][shotx - 1] = "x";
                    }
                }
                if (ship3 >= 3 && ship21 >= 2 && ship22 >= 2 && ship1 >= 4) {
                    break;
                }
                System.out.println();
                numbofshots++;
            }
            System.out.println("Total number of shots: " + numbofshots);
            System.out.println("Do you want to play again?");
            String answer = scanner.next();
            if (answer.equals("yes")) {
                flag = true;
            } else if(answer.equals("no")){
                flag = false;
            }
        }while(flag);


    }
    static void ships(String[][]matrix, Integer[][] matrix1){
        String s = "*";
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                matrix[i][j] = "#";
                matrix1[i][j] = 0;

            }
        }
        //SHIP 1x3
        int x1 = (int) Math.floor(Math.random() * 5);
        int y1 = (int) Math.floor(Math.random() * 5);
        for (int i = 0; i < 3; i++) {
            if (x1 >= y1) {
                matrix[x1 + i][y1] = s;
                try {
                    matrix1[x1 + i][Math.abs(y1 - 1)] = 9;
                    matrix1[x1 + i][Math.abs(y1 + 1)] = 9;
                    matrix1[Math.abs(x1 - 1)][y1 - 1 + i] = 9;
                    matrix1[Math.abs(x1 + 3)][y1 - 1 + i] = 9;
                    matrix1[x1 + i][y1] = 3;
                } catch (ArrayIndexOutOfBoundsException e) {
                    matrix1[x1 + i][y1] = 3;
                }
            } else {
                try {
                    matrix[x1][y1 + i] = s;
                    matrix1[Math.abs(x1 - 1)][y1 + i] = 9;
                    matrix1[Math.abs(x1 + 1)][y1 + i] = 9;
                    matrix1[x1 - 1 + i][Math.abs(y1 - 1)] = 9;
                    matrix1[x1 - 1 + i][Math.abs(y1 + 3)] = 9;
                    matrix1[x1][y1 + i] = 3;
                } catch (ArrayIndexOutOfBoundsException e) {
                    matrix1[x1][y1 + i] = 3;
                }
            }

        }
        //SHIPS 1x2
        //FIRST SHIP 1x2
        int temp1 = 0;
        while (temp1 != 1) {
            int x2 = (int) Math.floor(Math.random() * 6);
            int y2 = (int) Math.floor(Math.random() * 6);
            if (matrix1[x2][y2] != 0) {
                continue;
            }
            if (x2 >= y2) {
                if (matrix1[Math.abs(x2 + 1)][y2] != 0) {
                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    matrix[x2 + i][y2] = s;
                    try{
                        matrix1[x2 + i][Math.abs(y2 - 1)] = 9;
                        matrix1[x2 + i][Math.abs(y2 + 1)] = 9;
                    }catch (ArrayIndexOutOfBoundsException e){
                        continue;
                    }
                    for (int j = 0; j < 3; j++){
                        try{
                            matrix1[x2 - 1][y2 - 1 + j] = 9;
                        }catch (ArrayIndexOutOfBoundsException e){
                            matrix1[x2 + i][y2] = 2;
                        }
                        try{
                            matrix1[Math.abs(x2 + 2)][y2 - 1 + j] = 9;
                        }catch (ArrayIndexOutOfBoundsException e){
                            matrix1[x2 + i][y2] = 2;
                        }
                    }
                    matrix1[x2 + i][y2] = 2;
                }

            }
            else {
                if (matrix1[x2][Math.abs(y2 + 1)] != 0) {
                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    matrix[x2][y2 + i] = s;
                    try {
                        matrix1[Math.abs(x2 - 1)][y2 + i] = 9;
                        matrix1[Math.abs(x2 + 1)][y2 + i] = 9;
                    }catch (ArrayIndexOutOfBoundsException e){
                        matrix1[x2][y2 + i] = 2;
                    }
                    for (int j = 0; j < 3; j++){
                        try{
                            matrix1[x2 - 1 + j][Math.abs(y2 - 1)] = 9;
                        }catch (ArrayIndexOutOfBoundsException e){
                            matrix1[x2][y2 + i] = 2;
                        }
                        try{
                            matrix1[x2 - 1 + j][y2 + 2] = 9;
                        }catch (ArrayIndexOutOfBoundsException e){
                            matrix1[x2][y2 + i] = 2;
                        }
                    }
                    matrix1[x2][y2 + i] = 2;
                }

            }
            temp1++;
        }
        //SECOND SHIP 1x2
        int temp = 0;
        while (temp != 1) {
            int x2 = (int) Math.floor(Math.random() * 6);
            int y2 = (int) Math.floor(Math.random() * 6);
            if (matrix1[x2][y2] != 0) {
                continue;
            }
            if (x2 >= y2) {
                if (matrix1[Math.abs(x2 + 1)][y2] != 0) {
                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    matrix[x2 + i][y2] = s;
                    try{
                        matrix1[x2 + i][Math.abs(y2 - 1)] = 9;
                        matrix1[x2 + i][Math.abs(y2 + 1)] = 9;
                    }catch (ArrayIndexOutOfBoundsException e){
                        continue;
                    }
                    for (int j = 0; j < 3; j++){
                        try{
                            matrix1[x2 - 1][y2 - 1 + j] = 9;
                        }catch (ArrayIndexOutOfBoundsException e){
                            matrix1[x2 + i][y2] = 4;
                        }
                        try{
                            matrix1[Math.abs(x2 + 2)][y2 - 1 + j] = 9;
                        }catch (ArrayIndexOutOfBoundsException e){
                            matrix1[x2 + i][y2] = 4;
                        }
                    }
                    matrix1[x2 + i][y2] = 4;
                }

            }
            else {
                if (matrix1[x2][Math.abs(y2 + 1)] != 0) {
                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    matrix[x2][y2 + i] = s;
                    try {
                        matrix1[Math.abs(x2 - 1)][y2 + i] = 9;
                        matrix1[Math.abs(x2 + 1)][y2 + i] = 9;
                    }catch (ArrayIndexOutOfBoundsException e){
                        matrix1[x2][y2 + i] = 4;
                    }
                    for (int j = 0; j < 3; j++){
                        try{
                            matrix1[x2 - 1 + j][Math.abs(y2 - 1)] = 9;
                        }catch (ArrayIndexOutOfBoundsException e){
                            matrix1[x2][y2 + i] = 4;
                        }
                        try{
                            matrix1[x2 - 1 + j][y2 + 2] = 9;
                        }catch (ArrayIndexOutOfBoundsException e){
                            matrix1[x2][y2 + i] = 4;
                        }
                    }
                    matrix1[x2][y2 + i] = 4;
                }

            }
            temp++;
        }
        //SHIPS 1x1
        int z = 0;
        while (z < 4) {
            int x3 = (int) Math.floor(Math.random() * 7);
            int y3 = (int) Math.floor(Math.random() * 7);
            if (matrix1[x3][y3] != 0) {
                continue;
            }
            matrix[x3][y3] = s;
            for (int i = 0; i < 3; i++) {
                try {
                    matrix1[x3 - 1 + i][y3 - 1] = 9;
                }catch (ArrayIndexOutOfBoundsException e){
                    matrix1[x3][y3] = 1;
                }try{
                    matrix1[x3 - 1 + i][y3] = 9;
                }catch (ArrayIndexOutOfBoundsException e){
                    matrix1[x3][y3] = 1;
                }
                try {
                    matrix1[x3 - 1 + i][y3 + 1] = 9;
                }catch (ArrayIndexOutOfBoundsException e){
                    matrix1[x3][y3] = 1;
                }
                matrix1[x3][y3] = 1;
            }
            z++;
        }
    }
}