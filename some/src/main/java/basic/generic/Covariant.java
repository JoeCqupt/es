package basic.generic;

import java.util.ArrayList;
import java.util.List;

// 协变
public class Covariant {

    public static void main(String[] args) {
        Animal[] animals = new Cat[5]; // it is right, java数组是支持协变的
        animals[0] = new Cat();  // it is right
//        animals[1] = new Dog(); // runtime error， 因为jvm知道这个数组的真正数据类型，一个不合适的类型会抛出异常

//        List<Animal> animalList = new ArrayList<Cat>(); // compile error, 范型这样子是不支持协变的
        List<? extends Animal> animalList = new ArrayList<Cat>(); // right， 这样范型才能支持协助变
        
    }

    static class Animal {
    }

    static class Cat extends Animal {
    }

    static class Dog extends Animal {
    }
}
