package netcracker;

import java.io.Serializable;

public class ArrayVector implements Serializable {
    private float[] v;
    private int size;

    ArrayVector(int size){
        this.size = size;
        this.v = new float[size];
    }

    ArrayVector(int size,float ... v){
        this(size);
        this.v = v;
    }

    public void setCoord(float ... v){
        this.v = v;
    }

    public int getSize(){
        return size;
    }

    public float getValue(int index){
        return v[index];
    }

    public void setValue(int index, float x){
        v[index] = x;
    }

    public float[] getValues(){
        return v;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ArrayVector av = (ArrayVector) obj;
        if(v.length == av.getValues().length){
            for(int i = 0; i < v.length; i++){
                if(v[i] != av.getValue(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
