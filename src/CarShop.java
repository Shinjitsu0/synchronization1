import java.util.*;

public class CarShop {
    private List<Car> carList = new ArrayList<>();
    final long CARACCEPTTIME = 3000;
    final long WAITINGCARTIME = 2000;
    final long CARQUANTITY = 5;

    public List<Car> getCarList() {
        return carList;
    }

    public void receiveCar() {
        try {
            for (int i = 0; i < CARQUANTITY; i++) {
                System.out.printf("%s принимает новый автомобиль\n", Thread.currentThread().getName());
                Thread.sleep(CARACCEPTTIME);
                System.out.println("Приемка завершена");
                synchronized (this) {
                    getCarList().add(new Car());
                    notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sellCar() {
        try {
            System.out.printf("%s заходит в салон\n", Thread.currentThread().getName());
            synchronized (this) {
                while (carList.size() == 0) {
                    System.out.println("Машин нет в наличии");
                    wait();
                }
            }
            Thread.sleep(WAITINGCARTIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новой машине");
            getCarList().remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}