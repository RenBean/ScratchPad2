package main.java.week2.day1;

/**
 * Created by Ari on 7/18/16.
 */
public class FizzBuzz2 {
    public static void main(String[] args) {
        FizzBuzz2 fb = new FizzBuzz2();
        for (int count = 1; count <= 100; count++) {
            fb.output(count);
        }
    }

    public void output(int count) {
        if (count % 3 == 0) {
            System.out.print("Fizz");
        }
        if (count % 5 == 0) {
            System.out.print("Buzz");
        }
        if (count % 3 != 0 && count % 5 != 0) {
            System.out.print("" + count);
        }

        System.out.println();
    }
}

    class FizzBuzz2Test {
        public void main(String[] args) {
            FizzBuzz2 fb = new FizzBuzz2();
            fb.output(1); // 1
            fb.output(3); // Fizz
            fb.output(5); // Buzz
            fb.output(15); // FizzBuzz
            fb.output(2); // 2
            fb.output(100); // Buzz
        }
    }

    //how do i run the test though?

