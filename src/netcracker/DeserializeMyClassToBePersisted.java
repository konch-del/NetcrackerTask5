package netcracker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeMyClassToBePersisted {
    public static void main(String [] args) throws IOException, ClassNotFoundException {

        String filename = "Myclass.txt";
        if (args.length > 0) {
            filename = args[0];
        }


        MyClassToBePersisted myClass = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        fis = new FileInputStream(filename);
        in = new ObjectInputStream(fis);
        myClass = (MyClassToBePersisted) in.readObject();
        in.close();


        System.out.println(myClass.getProfile() + " " + myClass.getGroup());
    }
}
