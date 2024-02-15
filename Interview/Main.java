package Interview;

public class Main {
    public static void main(String[] args) {
        int p = run();
        System.out.println(p);
    }

    public static int run() {
        int a = 10;
        try{
            int b= a/0;
            return b;
        } catch(Exception e){
            return a;
        } finally {
            a = 3;
            return a;
        }
    }
    }
