package com.kotlinplayground;

public class Program {

    public static void main(String args[]) {


        /**
         * *
         * **
         * ***
         * ****
         * *****
         * ******
         */

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        System.out.print("====================================\n");

        /**
         *       ****
         *       ****
         *       ****
         *       ****
         */

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }


        System.out.print("====================================\n");

        /**
         *      *
         *      ##
         *      ***
         *      ####
         */
        for(int i =0; i< 4; i++){
            for(int j=0; j<=i; j++){
                if(i%2==0){
                    System.out.print("*");
                }else{
                    System.out.print("#");
                }
            }
            System.out.print("\n");
        }

        System.out.print("====================================\n");

        /**
         *     *****
         *      ***
         *       *
         */

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j <= 4; j++) {
                if (j >= i && j <= 4 - i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

}
