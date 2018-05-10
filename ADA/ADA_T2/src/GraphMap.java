import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GraphMap {

	Map<String, HashSet<String>> graph;

	public GraphMap() {
		this.graph = new HashMap<String, HashSet<String>>();
	}


	public void addSon(String father, String son) {
		this.graph.get(father).add(son);
	}


	public void addNode(String node) {
		this.graph.putIfAbsent(node, new HashSet<String>());
	}

	public boolean hasCycle() {
		Stack<String> visited = new Stack<String>();

		for(String node : this.graph.keySet()) {
			if(hasCycle(node, visited)) {
				return true;
			}
		}

		return false;
	}

	private boolean hasCycle(String node, Stack<String> visited) {

		if (visited.contains(node)) {
			return true;
		}
		visited.add(node);

		for (String nextNode : this.graph.get(node)) {
			if (hasCycle(nextNode, visited)) {
				return true;
			}
		}

		visited.pop();
		return false;
	}


	public Set<String> getNodes(){
		return this.graph.keySet();
	}

	public HashSet<String> getSons(String node){
		return this.graph.get(node);
	}
}
