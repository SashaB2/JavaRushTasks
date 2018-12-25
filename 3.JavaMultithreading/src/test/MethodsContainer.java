package test;

public abstract class MethodsContainer extends AA{


    public MethodsContainer(String a) {
        super(a);
    }

    public void test( ){
        super.setA();
        System.out.println("test");
    }
}
