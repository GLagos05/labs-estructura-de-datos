public class Registro {
    String plate, year, countedValue;

    public Registro(String plate, String year, String countedValue) {
        this.plate = plate;
        this.year = year;
        this.countedValue = countedValue;
    }

    public String getPlate() {
        return plate;
    }

    public String getYear() {
        return year;
    }

    public String getCountedValue() {
        return countedValue;
    }
}
