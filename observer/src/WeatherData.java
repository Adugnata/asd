import java.util.ArrayList;

public class WeatherData implements subject {
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;
    public WeatherData(){
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
int i = observers.indexOf(o);
if(i>=0) observers.remove(i);
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }
    public void measurementChanged(){
        notifyObserver();
    }
    public void setMeasureemnts(float t, float h, float p){
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
    }
}
