import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Permiso {
    Registro[] registros;
    private int nElems;
    //--------------------------------------------------------------
    public Permiso() {
        nElems = readFile();
        this.registros = new Registro[nElems];
    }
    //--------------------------------------------------------------
    public Registro[] cargarPermisos(){
        String line = "";
        int contador = 0;
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("target\\CSVDemo.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] data = line.split(";");    // use comma as separator
                registros[contador] = new Registro(data[0], data[9], data[6]);
                //System.out.println("Patente: " + data[0] + ", Año: " + data[9] + ", Valor contado: " + data[6]);
                contador++;
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return registros;
    }
    //--------------------------------------------------------------
    public int readFile(){
        String line = "";
        int contador = 0;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("target\\CSVDemo.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(";");
                contador++;
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contador;
    }
    //--------------------------------------------------------------
    public static void getDataSimple(Registro registro){
        String plate = registro.getPlate();
        String year = registro.getYear();
        String countedValue = registro.getCountedValue();
    }

    public static String[] getDataPlate(Registro[] registro){
        String[] plate = new String[registro.length];
        for (int i = 0; i < registro.length; i++) {
            plate[i] = registro[i].getPlate();
        }
        return plate;
    }

    public static String[] getDataYear(Registro[] registro){
        String[] year = new String[registro.length];
        for (int i = 0; i < registro.length; i++) {
            year[i] = registro[i].getYear();
        }
        return year;
    }
    //--------------------------------------------------------------
    public static long[] getDataCountedValue(Registro[] registro){
        long[] countedValue = new long[registro.length];
        for (int i = 0; i < registro.length; i++) {
            countedValue[i] = Long.parseLong(registro[i].getCountedValue());
        }
        return countedValue;
    }
    //--------------------------------------------------------------
    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }
    //--------------------------------------------------------------
    public void recQuickSort(int left, int right) {
        if (right - left <= 0)              // if size <= 1,
            return;                      //    already sorted
        else                             // size is 2 or larger
        {
            long pivot = getDataCountedValue(registros)[right];      // rightmost item
                                                                    // partition range
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);   // sort left side
            recQuickSort(partition + 1, right);  // sort right side
        }
    }
    //--------------------------------------------------------------
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;           // left    (after ++)
        int rightPtr = right;           // right-1 (after --)
        while (true) {                            // find bigger item
            while (getDataCountedValue(registros)[++leftPtr] < pivot)
                ;  // (nop)
            // find smaller item
            while (rightPtr > 0 && getDataCountedValue(registros)[--rightPtr] > pivot)
                ;  // (nop)

            if (leftPtr >= rightPtr)      // if pointers cross,
                break;                    //    partition done
            else                         // not crossed, so
                swap(leftPtr, rightPtr);  //    swap elements
        }  // end while(true)
        swap(leftPtr, right);           // restore pivot
        return leftPtr;                 // return pivot location
    }
    //--------------------------------------------------------------
    public void swap(int dex1, int dex2)  // swap two elements
    {
        Registro temp = registros[dex1];        // A into temp
        registros[dex1] = registros[dex2];   // B into A
        registros[dex2] = temp;             // temp into B
    }
}

