public class Client {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();
        remote.setCommand(new LightOnCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new StereoOnWithCDCommand(stereo));
        remote.buttonWasPressed();
        remote.setCommand(new StereoOffCommand(stereo));
        remote.buttonWasPressed();
    }
}

