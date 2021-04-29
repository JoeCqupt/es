package basic.method;

public class Methods {

    public static void main(String[] args) {
        Foo foo = new Foo();
        method1(foo);
        System.out.println(foo.p);
    }
    public static void method1(Foo foo) { // 值传递，相当于拷贝了一份引用指针
        foo.p = 1;
    }

    static class Foo {
        private int p;
    }
}
