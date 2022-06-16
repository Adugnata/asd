package duck;

class TurkeyObjectAdapter implements Duck {
    Turkey turkey;

    public TurkeyObjectAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        turkey.fly();
    }
}


class TurkeyyClassAdapter extends Turkey implements Duck {



    public void quack() {

        this.gobble();

    }


    public void fly() {

        this.fly();

    }

}

public class Main {
    public static void main(String[] args) {
        TurkeyyClassAdapter t = new TurkeyyClassAdapter();
        t.fly();
        t.gobble();
    }

}
