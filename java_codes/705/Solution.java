import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyHashSet {

    private int size = 10000;
    private ArrayList<List<Integer>> buckets = new ArrayList<>();

    /** Initialize your data structure here. */
    public MyHashSet() {
        for(int i = 0; i < size; i++){
            buckets.add(new ArrayList<Integer>());
        }
    }

    public void add(int key) {
        TwoTuple<List<Integer>, Integer> res = indexFunc(key);
        List<Integer> bucket = res.first;
        int index = res.second;
        if (index < 0){
            bucket.add(key);
        }
    }

    public void remove(int key) {
        TwoTuple<List<Integer>, Integer> res = indexFunc(key);
        List<Integer> bucket = res.first;
        int index = res.second;
        if (index >= 0){
            bucket.remove(new Integer(key));  // be careful (if pass int directly, it will think as index)
//            Iterator<Integer> integerIterator = bucket.iterator();
//            while (integerIterator.hasNext()){
//                int number = integerIterator.next();
//                if (number == key){
//                    integerIterator.remove();
//                }
//            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        TwoTuple<List<Integer>, Integer> res = indexFunc(key);
        int index = res.second;
        return index >= 0;
    }

    private int hashFunc (int key){
        return key % size;
    }

    private TwoTuple<List<Integer>, Integer> indexFunc (int key){
        int hashValue = hashFunc(key);
        List<Integer> bucket = buckets.get(hashValue);
        for (int i = 0; i < bucket.size(); i++){
            if (bucket.get(i) == key){
                return new TwoTuple<>(bucket, i);
            }
        }
        return new TwoTuple<>(bucket, -1);
    }
}

class TwoTuple<A, B> {

    public final A first;

    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

}