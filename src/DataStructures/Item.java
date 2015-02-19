package DataStructures;

public class Item<K,V> {
	
	K key;
	V value;
	public Item(K keys, V values) {
		// TODO Auto-generated constructor stub
		key = keys;
		value = values;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}

}
