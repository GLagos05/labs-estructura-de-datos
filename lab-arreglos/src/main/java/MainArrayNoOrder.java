public class MainArrayNoOrder {
    public static void main(String[] args) {
        int max = 10000;
        HighArray h1 = new HighArray(max);
        HighArray h2 = new HighArray(max);
        h1.insert();
        h2.insert();
        int occurrences = h1.getOccurrences(h2);
        System.out.println("N° of occurrences: " + occurrences);
    }
}
