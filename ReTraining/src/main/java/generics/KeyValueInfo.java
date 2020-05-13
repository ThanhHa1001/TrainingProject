package generics;

/**
 *	Lớp này mở rộng (extends) từ lớp KeyValue<K, V>
 *  Nó có thêm một tham số Generics <I> 
 */
public class KeyValueInfo<K, V, I> extends KeyValue<K, V>{
	private I info;
	
	public KeyValueInfo(K key, V value) {
		super(key, value);
	}
	
	public KeyValueInfo(K key, V value, I info) {
		super(key, value);
		this.info = info;
	}
	
	public I getInfo() {
		return info;
	}
	
	public void setInfo(I info) {
		this.info = info;
	}
}
