import java.util.LinkedList;
import java.util.List;

public class Graph {

	private int nNodes;
	private Node[] graph;

	public Graph(int nNodes) {
		// TODO Auto-generated constructor stub
		this.nNodes = nNodes;
		graph = new Node[nNodes];

	}

	void addEdge(Node value, Node destination) {
		graph[destination.getValue()].addDegree();
		graph[value.getValue()].addSon(destination);
	}

	void removeEdge(Node orign, Node destination) {
		graph[orign.getValue()].removeSon(destination);
	}

	public Node[] getNodes() {
		return graph;
	}

	public LinkedList<Node> getNodeSons(Node n) {
		return graph[n.getValue()].getSons();
	}

	boolean isAcyclic(Graph g) {

		int numProcNodes = 0;
		LinkedList<Node> ready = new LinkedList<>();
		int[] inDegree = new int[g.nNodes];

		for (Node i : g.getNodes()) {
			inDegree[i.getValue()] = i.getInDegree();
			if (inDegree[i.getValue()] == 0) {
				ready.add(i);
			}
		}
		while (!ready.isEmpty()) {
			Node node = ready.remove();
			numProcNodes++;
			for (Node v : g.getNodeSons(node)) {
				inDegree[v.getValue()]--;
				if (inDegree[v.getValue()] == 0)
					ready.add(v);
			}
		}
		return numProcNodes == g.nNodes;

	}
}
