public class MainArrayOrder {
    public static void main(String[] args) {
        int max = 10000;
        OrdArray o1 = new OrdArray(max);
        OrdArray o2 = new OrdArray(max);
        o1.insert();
        o2.insert();
        int occurrences = o1.getOccurrences(o2);
        System.out.println("N° of occurrences: " + occurrences);
    }
}
