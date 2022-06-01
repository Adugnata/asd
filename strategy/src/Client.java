public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new Add());
        int r = context.executeStrategy(4,5);
        System.out.println(r);
    }
}
