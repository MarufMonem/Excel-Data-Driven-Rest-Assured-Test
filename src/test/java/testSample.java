import resources.dataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {
    public static void main(String[] args) throws IOException {
        dataDriven d =new dataDriven();
        ArrayList<String> data =  d.getData("Purchase");

        System.out.println("Data 1: " + data.get(1));
        System.out.println("Data 2: " + data.get(2));
        System.out.println("Data 3: " + data.get(3));
    }
}
