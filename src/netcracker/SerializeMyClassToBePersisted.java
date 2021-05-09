package netcracker;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeMyClassToBePersisted {
    public static void main(String [] args) throws IOException {
        MyClassToBePersisted x = new MyClassToBePersisted("abc","123");
        FileOutputStream fos = new FileOutputStream("Myclass.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(x);
        oos.close();
    }
}
