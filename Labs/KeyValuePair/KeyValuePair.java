package keyValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class KeyValuePair<K extends Comparable<K>,V> implements Comparable< KeyValuePair <K, V>> {
	
	
	private K key;
	private V value;
	
	
	public KeyValuePair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyValuePair other = (KeyValuePair) obj;
		return Objects.equals(key, other.key) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "(" + this.key + ", " + this.value + ")";
	}
	
	@Override
	public int compareTo(KeyValuePair<K, V> o) {
		 return this.key.compareTo(o.key);
	}
	

}
