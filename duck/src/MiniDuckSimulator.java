public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
        Duck modelduck = new ModelDuck();
        modelduck.performFly();
        modelduck.setFlyBehavior(new FlyRocketPowered());
        modelduck.performFly();
    }
}
