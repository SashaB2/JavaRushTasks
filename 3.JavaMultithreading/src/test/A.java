package test;

public abstract class A extends AA{

    public A(String a){
        super(a);
        init();
    }
    String t;
    public void init(){
        if(t == null){
            t = "";
        }
    }
    String getT = "Hello";
    public void validate(){
        if(t.equals(getT)){
            System.out.println("aaaaaaaaaaaaaa");
        }
    }

    public String asserVisible(){
        super.shoudBeVisibe();
        return a;
    }

}


class C extends A {
    public C(String a) {
        super(a);
    }

    @Override
    public void init(){
        super.t = "Hello";
    }
}

class D {

    public static void main(String[] args) {

        C c = new C("a");
        c.asserVisible();
        c.validate();

    }

}


