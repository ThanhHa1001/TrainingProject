package generics;

/**
 * Lớp này mở rộng <extends> từ lớp KeyValue<K,V>
 * Và chỉ định rõ K, V
 * K = Integer (Số điện thoại)
 * V = String (Tên người dùng)
 */
public class PhoneNameEntry extends KeyValue<Integer, String>{

	public PhoneNameEntry(Integer key, String value) {
		super(key, value);
	}
}
