package basic.polymorphism;

/**
 * java 多态
 */
public class Polymorphism {
    public static void main(String[] args) {
        Cat cat = new Cat();
        doEat(cat);
    }

    static void doEat(Animal a) {
        a.eat();
    }
}

abstract class Animal {
    abstract void eat();
}

class Cat extends Animal {

    @Override
    void eat() {
        System.out.println("cat eat");
    }
}

class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("dog eat");
    }
}