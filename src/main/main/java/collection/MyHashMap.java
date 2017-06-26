package collection;

import java.util.*;

/**
 * Created by hadoop on 17-5-21.
 */
public class MyHashMap<K,V> extends AbstractMap<K,V> {
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

    }

    /* ---------------- Static utilities -------------- */
    private float loadFactor ;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    final int DEFAULT_INITIAL_CAPACITY = 16;
    int threshold;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    transient Set<Map.Entry<K,V>> entrySet;
    transient Node[] table;
    int size;
    public Set<Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> es;
        return (es = entrySet) == null ? entrySet  : es;
    }

    private int tableSizeFor(int cap){
        int n = cap -1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        table = new Node[n];
        return n;
    }
    public MyHashMap(){
        table = new Node[DEFAULT_INITIAL_CAPACITY-1];
        this.threshold = (int)(DEFAULT_LOAD_FACTOR*DEFAULT_INITIAL_CAPACITY);
    }

    public MyHashMap(int initialCapacity){
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor){
        if(initialCapacity<0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                initialCapacity);
        if(initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if(loadFactor < 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);

    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    static int indexFor(int hash , int length){
        return hash & (length-1);
    }
    public V put(K key,V value){
        if(key == null)
            putForNullKey(key,value);
        int hash = hash(key);
        int i = indexFor(hash,table.length);
        for(Node<K,V> e=table[i];e != null;e = e.next){
            Object k;
            if((e.hash==hash) && ((k = e.key) == key || k.equals(key))){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addNode(hash, key, value, i);
        return value;
    }

    public V putForNullKey(K key,V value){
        for(Node<K,V> e = table[0]; e!=null ; e=e.next){
            if(e.key == null){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addNode(0,null,value,0);
        return value;
    }
    public void addNode(int hash,K key,V value,int bucketIndex){
        Node<K,V> e = table[bucketIndex];
        table[bucketIndex] = new Node<K,V>(hash, key, value, e);
        if (size++ >= threshold) //如果大于临界值就扩容
            resize(2 * table.length);
    }

    public void resize(int n){
        Node<K,V>[] old = table;
        if(old.length == MAXIMUM_CAPACITY)
            threshold = Integer.MAX_VALUE;
        Node newTable[] = new Node[n];
        table = newTable;
        //transfer(newTable);
        threshold = (int)(n*loadFactor);
    }

    public V get(Object key){
        if(key == null)
            getForNullKey(key);
        int hash = hash(key);
        int i = indexFor(hash,table.length);
        for(Node<K,V> e = table[i];e!=null;e=e.next){
            Object k;
            if((e.hash==hash) && ((k = e.key) == key || k.equals(key) )){
                return e.value;
            }
        }
        return null;
    }

    public V getForNullKey(Object key){
        for(Node<K,V> e = table[0]; e!=null ; e=e.next){
            if(e.key == null){
                return e.value;
            }
        }
        return null;
    }

    public boolean containsKey(Object key){
        return getNode(key) != null;
    }

    public Node getNode(Object key){
        int hash = (key == null) ? 0: hash(key);
        int i = indexFor(hash,table.length);
        for(Node<K,V> e=table[i];e!=null;e=e.next){
            Object k;
            if((e.hash == hash) && ((k=e.key) == key || k.equals(key))){
                return e;
            }
        }
        return null;
    }


    public static void main(String[] args){
        HashMap<String,String> a=new HashMap<String, String>();
        int n = 10 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        MyHashMap<String,String> aa =new MyHashMap<String, String>();
        aa.put("a","a");

        System.out.println(aa.containsKey("a"));
    }
}
