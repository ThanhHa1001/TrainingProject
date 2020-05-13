package generics;

public class GenericsClass<T> {
	private T data;
	
	public GenericsClass(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
}

