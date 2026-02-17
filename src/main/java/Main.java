import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("24 часа Ле-Мана");
        ArrayList<Car>cars=new ArrayList<>();
        int minSpeed=0;
        int maxSpeed=250;
        Scanner scanner = new Scanner(System.in);
        for (int i=1;i<4;i++){
            String name=new String();
            int speed=0;
            boolean validInput = false;
            while (name.isEmpty()) {
                System.out.println("Напишите название " + i + " автомобиля:");
                name = scanner.next();
            }
            System.out.println("Напишите скорость " + name + " автомобиля(от 0 до 250км/ч):");
            while ((speed<=minSpeed)||(speed>maxSpeed)||(!validInput)){
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    validInput=true;
                }
                else {
                    System.out.println("Напишите скорость " + name + " автомобиля(от 0 до 250км/ч):");
                    scanner.next();
                    validInput=false;
                }
            }
            cars.add(new Car(name,speed));
        }
        Race race=new Race();
        System.out.println("Победитель " + race.raceLider(cars));
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
    final String name;
    final int speed;
    public Car(final String name,final int speed) {
        this.name = name;
        this.speed=speed;
    }
}