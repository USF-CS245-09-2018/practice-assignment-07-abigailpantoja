
import java.util.*;

public class ArrayList implements List{
	private Object[] a = new Object[10];
	private int size;
	@Override

	public void add(Object obj){
		if(size == a.length){
			grow_arr();
		}
		a[size++] = obj;
	}

	public Object remove(int pos){
		if(pos < 0 || pos > a.length){
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		if(a[pos]==null) {
			throw new NullPointerException();
		}
		Object obj = a[pos];
		for(int i = pos+1; i < size; i++){
			a[i-1] = a[i];
		}
		size--;
		return obj;

	}

	public void add(int pos, Object obj){
		if(pos < 0 || pos > size){
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		if(size == a.length){
			grow_arr();
		}

		for(int i = size; i > pos; i--){
			a[i] = a[i-1];
		}
		a[pos] = obj;
		size++;
	}

	public Object get(int pos){
		if(pos > a.length || pos < 0){
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		return a[pos];
	}

	public int size(){
		return size;
	}

	public void grow_arr(){
		a = Arrays.copyOf(a, a.length*2);
	}

}