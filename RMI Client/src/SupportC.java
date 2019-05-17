
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SupportC {

    public String RecValoresF(File FICHEROB) throws FileNotFoundException, IOException {
        String maxValoresF;
        try (
                DataInputStream disT = new DataInputStream(new FileInputStream(FICHEROB));) {
            maxValoresF = disT.readUTF();
        }

        return maxValoresF;
    }
}
