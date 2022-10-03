public class Main {
    public static void main(String[] args) {

        int max = 100000;
//-------------------------------------------------
        ArrayBub A1 = new ArrayBub(max);
        ArrayIns A2 = new ArrayIns(max);
        ArraySel A3 = new ArraySel(max);
        A1.insert();
        A2.copyContent(A1);
        A3.copyContent(A1);
//-------------------------------------------------
        A1.bubbleSort();
        A2.insertionSort();
        A3.selectionSort();
        System.out.println();
//-------------------------------------------------
        A1.bubbleSortReverse();
        A2.insertionSortReverse();
        A3.selectionSortReverse();

    }
}
