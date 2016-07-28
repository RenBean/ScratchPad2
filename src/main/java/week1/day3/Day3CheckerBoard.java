package main.java.week1.day3;

public class Day3CheckerBoard {
    public static void main (String[] args) {
        int size = 8;    // size of the board

        for (int row = 1; row <= size ; row++ ) {
            boolean isEven = false;
            String printRow ="";
            // Use modulus 2 to find alternate lines
            if ((row % 2) == 0) {   // row 2, 4, 6, 8
            isEven=true;
            }

            for (int col = 1; col <= size; col++) {

                if (isEven) {
                    printRow = printRow+"##";
                    isEven = false;
                } else{
                    isEven = true;
                    printRow = printRow+"  ";


                }

            }
            System.out.println(printRow);

        }

    }
}

    /*
    public static void main (String[] args) {
        int size = 8;    // size of the board



        for (int row = 1; true; ) {
            // Use modulus 2 to find alternate lines
            if ((row % 2) == 0) {   // row 2, 4, 6, 8
                System.out.print(" ");
            }
            for (int col = 1; true; ) {
                System.out.print("X");
            }

        }
    }

}
*/
