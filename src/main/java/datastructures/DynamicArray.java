package datastructures;

public class DynamicArray<T>
{
	private T[] data;

	// Counter for the number of elements in our array
	private int size = 0;

	// The capacity of our array - or how many elements it can hold.
	// What we double when the number of elements exceeds the capacity of the array.
	private int initialCapacity;

	@SuppressWarnings("unchecked")
	public DynamicArray(int initialCapacity)
	{
		this.initialCapacity = initialCapacity;
		data = (T[]) new Object[initialCapacity];
	}

	public String get(int index)
	{
		return (String) data[index];
	}

	public void set(int index, T value)
	{
		data[index] = value;
	}

	public void insert(int index, T value)
	{
		// Check size
		if (size == initialCapacity)
		{
			resize();
		}

		// Copy up
		for (int j = size; j > index; j--)
		{
			data[j] = data[j - 1];
		}

		// Insert
		data[index] = value;
		size++;
	}

	//
	// You try
	// Try implementing delete, isEmpty, and Contains on your own.
	// You can find the solution at the bottom
	public void delete(int index)
	{
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}

		for (int i = index + 1; i < size; i++)
		{
			data[i - 1] = data[i];
		}

		data[--size] = null;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public boolean Contains(T value)
	{
		for (int i = 0; i < size; i++)
		{
			if (data[i] != null && data[i].equals(value))
			{
				return true;
			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	private void resize()
	{
		T[] newData = (T[]) new Object[initialCapacity * 2];
		for (int i = 0; i < initialCapacity; i++)
		{
			newData[i] = data[i];
		}
		data = newData;
		initialCapacity = initialCapacity * 2;
	}

	public int size()
	{
		return size;
	}

	public void print()
	{
		for (int i = 0; i < size; i++)
		{
			System.out.println("data[i] = " + data[i]);
		}
	}

	// Some array implementations offer methods like insert (also known as pushBack).
	// Which is like insert, only in does the insert at the end of the array.
	public void add(T value)
	{

		if (size == initialCapacity)
		{
			resize();
		}

		data[size] = value;
		size++;
	}
}