public class Main {
    public static void main(String[] args) {
        final CarShop carShop = new CarShop();
        new Thread(null, carShop::sellCar, "Покупатель").start();
        new Thread(null, carShop::sellCar, "Покупатель 1").start();
        new Thread(null, carShop::sellCar, "Покупатель 2").start();
        new Thread(null, carShop::sellCar, "Покупатель 3").start();
        new Thread(null, carShop::receiveCar, "Продавец").start();
    }
}
