abstract public class Duck {
    FlyableBehavior flyableBehavior;
    QuackBehavior quackBehavior;
    public Duck(){}
    public abstract void display();
    public void setFlyBehavior(FlyableBehavior fb){
        this.flyableBehavior = fb;
    }
    public void setQuackBehavior(QuackBehavior qb){
        this.quackBehavior = qb;
    }
    public void performQuack(){quackBehavior.quack();}
    public void performFly(){
        flyableBehavior.fly();
    }
    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }
}
