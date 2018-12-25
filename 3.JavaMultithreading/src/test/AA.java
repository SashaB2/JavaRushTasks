package test;

public abstract class AA{

    String a;

    public AA(String a){
        setA();
        this.a = a;
    }


    public void setA(){
        a = "s";
    }

    public void shoudBeVisibe(){
        System.out.println("shoudBeVisibe()");
    }

}
