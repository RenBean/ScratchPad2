package main.java.week1.day1.zoo;

/**
 * Created by Ari on 7/11/16.
 */
public class Dog extends Mammal {
    public Dog (){
        this.name = "Dog";
    }

    @Override
    public void makeSound(){
        System.out.println("Bark!");
    }
}
