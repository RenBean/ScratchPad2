package main.java.week1.day1.zoo;

/**
 * Created by Ari on 7/11/16.
 */
public class Snake extends Reptile {
    public Snake(){
        this.name = "Snake";
    }
    @Override
    public void makeSound(){
        System.out.println("Ssssssssss!");
    }

}
