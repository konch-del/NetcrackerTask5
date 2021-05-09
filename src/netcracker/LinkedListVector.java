package netcracker;

import java.io.Serializable;

public class LinkedListVector implements Serializable { //объект класса сериализуем, так как класс реализует интерфейс Serializable
    //все поля класса должны быть сериализуемыми. если поля содержат ссылки на другие объекты,
    private Node head;                                          //то классы этих объектов также должны реализовывать интерфейс Serializable
    private Node lastnode;                                      //для сериализации необходимо также, чтобы родительский класс был сериализуем.
    private int lastnodeindex;
    private int count;

    class Node implements Serializable {
        double data;
        Node nextlink;
        Node previouslink;
    }

    public LinkedListVector() {
        head = new Node();
        head.nextlink = head;
        head.previouslink = head;
        lastnode = head;
        count = 0;
        lastnodeindex = 0;
    }

    public void addToTail(double data) {
        Node tempnode = new Node();
        tempnode.data = data;
        head.previouslink.nextlink = tempnode;
        tempnode.nextlink = head;
        tempnode.previouslink = head.previouslink;
        head.previouslink = tempnode;
        lastnode = tempnode;
        count++;
        lastnodeindex = count;
    }

    public void delete(int index) {
        search(index + 1);
        lastnode.previouslink.nextlink = lastnode.nextlink;
        lastnode.nextlink.previouslink = lastnode.previouslink;
        lastnode = lastnode.nextlink;
        count--;
        lastnodeindex--;
    }

    private Node search(int index) {
        if (index > count || index < 0) {
            return null;
        }

        if (index < lastnodeindex) {
            if (index > lastnodeindex - index) {
                for (int i = 0; i < lastnodeindex - index; i++, lastnode = lastnode.previouslink);
            } else {
                lastnode = head;
                for (int i = 0; i < index; i++, lastnode = lastnode.nextlink);
            }
        } else {
            if (count - index > index - lastnodeindex) {
                for (int i = 0; i < index - lastnodeindex; i++, lastnode = lastnode.nextlink);
            } else {
                lastnode = head.previouslink;
                for (int i = 0; i < count - index; i++, lastnode = lastnode.previouslink);
            }
        }
        lastnodeindex = index;
        return lastnode;
    }

    public double getValue(int index) {
        return search(index + 1).data;
    }

    public void setValue(int index, double value) {
        search(index + 1).data = value;
    }

    public int size() {
        return count;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        LinkedListVector lv = (LinkedListVector) obj;
        if(size() == lv.size()){
            for(int i = 0; i < size(); i++){
                if(getValue(i) != lv.getValue(i)){
                    return false;
                }
            }
        }
        return true;
    }

}
