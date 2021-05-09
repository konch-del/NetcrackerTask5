package netcracker;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class Vectors {

    public static void multByScalar(Vector x, float k){
        for(int i = 0; i < x.size(); i++){
            if(x.get(i) instanceof Number) {
                x.set(i, Float.parseFloat(x.get(i).toString()) * k);
            }else{
                System.out.println("Не числовой вектор");
                for (int j = 0; j < i; j++){
                    x.set(j, Float.parseFloat(x.get(j).toString()) / k);
                }
                break;
            }
        }
    }

    public static Vector summ(Vector a, Vector b){
        if(a.size() == b.size()){
            ArrayList<Float> x = new ArrayList<>();
            for(int i = 0; i < a.size(); i++){
                if(a.get(i) instanceof Number && b.get(i) instanceof Number) {
                    x.add(Float.parseFloat(a.get(i).toString()) + Float.parseFloat(b.get(i).toString()));
                }else{
                    System.out.println("Не числовой вектор");
                    break;
                }
            }
            Vector result = new Vector(x);
            return result;
        }else return null;
    }

    public static Vector mult(Vector a, Vector b){
        if(a.size() == b.size()){
            ArrayList<Float> x = new ArrayList<>();
            for(int i = 0; i < a.size(); i++){
                if(a.get(i) instanceof Number && b.get(i) instanceof Number) {
                    x.add(Float.parseFloat(a.get(i).toString()) * Float.parseFloat(b.get(i).toString()));
                }else{
                    System.out.println("Не числовой вектор");
                    break;
                }
            }
            Vector result = new Vector(x);
            return result;
        }else return null;
    }

    public static void outputVector(Vector v, OutputStream out) throws IOException {
        DataOutputStream s = new DataOutputStream(out);
        s.writeInt(v.size());
        for(int i = 0; i < v.size(); i++){
            System.out.println(Float.floatToIntBits(Float.parseFloat(v.get(i).toString())));
            s.write(Float.floatToIntBits(Float.parseFloat(v.get(i).toString())));
        }
    }

    public static Vector inputVector(InputStream in) throws IOException {
        DataInputStream invec = new DataInputStream(in);
        int length = invec.read();
        Vector v = new Vector(length);
        for (int i = 0; i < length; i++){
            v.add(invec.readFloat());
        }
        return v;
    }

    public static void writeVector(Vector v, Writer out) throws IOException {
        PrintWriter s = new PrintWriter(out);
        s.write(Integer.toString(v.size()));
        for (int i = 0; i < v.size(); i++) {
            s.write(' ' + v.get(i).toString());
        }
    }

    public static Vector readVector(Reader in) throws IOException {
        StreamTokenizer inread = new StreamTokenizer(in);
        inread.nextToken();
        int lenght = (int) inread.nval;
        Vector v = new Vector(lenght);
        for (int i = 0; i < lenght; i++){
            inread.nextToken();
            v.add(inread.nval);
            //v.set(i, inread.nval);
        }
        return v;
    }


}
