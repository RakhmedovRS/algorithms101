package datastructures;

public class LinkedList
{

	public class Node
	{
		int data;
		Node next;

		public Node(int data)
		{
			this.data = data;
		}
	}

	public Node head;

	public void addFront(int data)
	{

		// Create new node
		Node newNode = new Node(data);

		// if head...
		if (head == null)
		{
			head = newNode;
			return;
		}

		// Set it's next to current head
		newNode.next = head;

		// Set current head equal to this new head
		head = newNode;
	}

	public int getFirst()
	{
		return head.data;
	}

	public int getLast()
	{
		if (head == null)
		{
			throw new IllegalStateException("Empty list!");
		}

		Node current = head;

		// while we are not at the tail
		while (current.next != null)
		{
			current = current.next; // O(n)
		}

		// We are at the tail
		return current.data;
	}

	public void addBack(int data)
	{
		Node newNode = new Node(data);

		// if head... set and return
		if (head == null)
		{
			head = newNode;
			return;
		}

		// Else starting at head...
		Node current = head;

		// Walk until to hit tail
		while (current.next != null)
		{
			current = current.next;
		}

		// Set current node to equal newNode
		current.next = newNode;
	}

	public int size()
	{
		if (head == null)
		{
			return 0;
		}

		int size = 1;
		Node curr = head;
		while (curr.next != null)
		{
			curr = curr.next;
			size++;
		}

		return size;
	}

	public void clear()
	{
		head = null;
	}

	public void deleteValue(int data)
	{
		if (head == null)
		{
			return;
		}
		else if (head.data == data)
		{
			head = head.next;
		}
		else
		{
			Node prev = null;
			Node curr = head;
			while (curr != null)
			{
				if (curr.data == data)
				{
					prev.next = curr.next;
					return;
				}
				prev = curr;
				curr = curr.next;
			}
		}
	}

	public void print()
	{
		Node current = head;
		while (current != null)
		{
			System.out.println(current.data);
			current = current.next;
		}
		System.out.println("");
	}
}
