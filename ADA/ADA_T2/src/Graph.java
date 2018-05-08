import java.util.LinkedList;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.PGPData;

public class Graph {

	private int nNodes;
	private LinkedList<Node> graph;

	public Graph(int nNodes) {
		// TODO Auto-generated constructor stub
		this.nNodes = nNodes;
		graph = new LinkedList<Node>();

	}

	void addEdge(int orign, int destination) {
		if (graph.get(orign) == null) {
			graph.add(new Node(orign));
		}
		if (graph.get(destination) == null) {
			graph.add(new Node(destination));
		}

		graph.get(destination).addDegree();
		graph.get(orign).addSon(graph.get(destination));
	}

	void removeEdge(int orign, int destination) {
		graph.get(orign).removeSon(destination);

	}

	public LinkedList<Node> getNodes() {
		return graph;
	}

	public LinkedList<Node> getNodeSons(int n) {
		return graph.get(n).getSons();
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
			for (Node v : g.getNodeSons(node.getValue())) {
				inDegree[v.getValue()]--;
				if (inDegree[v.getValue()] == 0)
					ready.add(v);
			}
		}
		return numProcNodes == g.nNodes;

	}
}
