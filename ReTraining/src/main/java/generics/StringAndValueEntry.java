package generics;

/**
 *	Lớp này mửo rộng (extends) từ lớp KeyValue<K,V>
 *  Xác định rõ kiểu tham số <K> là String
 *  Vẫn giữ kiểu tham số Generic <V>
 */
public class StringAndValueEntry<V> extends KeyValue<String, V> {
	public StringAndValueEntry(String key, V value) {
		super(key, value);
	}
}
