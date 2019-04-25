public class Node implements Comparable<Node> {

	public char nodeType;
	public int i, j;
	public int weight;

	public Node(char x, int y, int i, int j) {
		this.nodeType = x;
		this.weight = y;
		this.i = i;
		this.j = j;
	}

	@Override
	public int compareTo(Node other) {
		return this.weight - other.weight;
	}

}
