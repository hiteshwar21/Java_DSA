package MockPractise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//Design a data structure that supports insert, delete, search and getRandom in constant time
public class CRUDAndGetRandom {
    public static void main(String[] args) {
        System.out.println(search(0));
        System.out.println(add(1));
        System.out.println(add(5));
        System.out.println(add(6));
        System.out.println(delete((10)));
        System.out.println(delete(5));
        System.out.println(getRandom());
    }

    static HashMap<Integer, Integer> map = new HashMap<>();
    static List<Integer> elemList = new ArrayList<>();

    public static boolean search(int element){
        if(map.containsKey(element)){
            return true;
        }
        return false;
    }

    public static boolean add(int element){
        if(!search(element)){
            elemList.add(element);
            int index = elemList.size()-1;
            map.put(element, index);
            return true;
        }
        return false;
    }

    public static boolean delete(int element){
        if(search(element)){
            int index = map.get(element);
            elemList.set(index, elemList.get(elemList.size()-1));
            elemList.remove(elemList.size()-1);
            map.remove(element);
            return true;
        }
        return false;
    }

    public static int getRandom(){
        Random random = new Random();
        int randIdx = random.nextInt(elemList.size());
        return elemList.get(randIdx);
    }
}
