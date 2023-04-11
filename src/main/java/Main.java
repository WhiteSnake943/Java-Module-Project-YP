import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("24 часа Ле-Мана");
        ArrayList<Car>cars=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i=1;i<4;i++){
            String name=new String();
            int speed=0;
            while (name.isEmpty()) {
                System.out.println("Напишите название " + i + " автомобиля:");
                name = scanner.next();
            }
            while ((speed<=0)||(speed>250)){
                System.out.println("Напишите скорость " + name + " автомобиля(от 0 до 250км/ч):");
                speed = scanner.nextInt();
            }
            cars.add(new Car(name,speed));
        }
        Race race=new Race();
        System.out.println(race.raceLider(cars));
    }
}
class Race{
    String lider="";
    int maxDistance = 0;
    public String raceLider(ArrayList<Car>cars){
        for (Car car : cars) {
            int distance = 24 * car.speed;
            if (distance>maxDistance){
                maxDistance=distance;
                lider=car.name;
            }
        }
        return lider;
    }
}
class Car{
    String name;
    int speed;
    public Car(String name,int speed) {
        this.name = name;
        this.speed=speed;
    }
}