import java.io.IOException;
import java.util.ArrayList;

public class testSample {
    public static void main(String[] args) throws IOException {
        dataDriven d =new dataDriven();
        ArrayList<String> data =  d.getData("Purchase");
    }
}
