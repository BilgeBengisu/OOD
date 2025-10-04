public class Main {
    public static void main(String[] args) {
        SmartphoneBuilder smartphone = new SmartphoneBuilder();

        smartphone.setSpecs("Ram", "8");
        smartphone.setSpecs("Camera", "4k");

        smartphone.displaySpecs();
    }
}