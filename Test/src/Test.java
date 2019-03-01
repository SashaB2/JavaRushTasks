public class Test {
    public static void main(String[] args) {
    }
}

enum Type{
    INT(true){
        public Object parse(String string){return Integer.valueOf(string);}
    };

    boolean primitive;
    Type(boolean primitive){this.primitive = primitive;
    super.name();
    }

    public abstract Object parse(String string);
}
