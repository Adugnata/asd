package duck;

public class TurkeyClassAdapter extends Turkey implements Duck {
    @Override
    public void quack() {
        super.gobble();
    }
    @Override
    public void fly(){
            super.fly();
        }
    }
