import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GraphMap {
	
	Map<String, ArrayList<String>> graph;
	Map<String, Boolean> nodes;
	boolean cycleDetected = false;
	
	public GraphMap() {
		this.graph = new HashMap<String, ArrayList<String>>();
		this.nodes = new HashMap<String, Boolean>();
	}

	
	public void addSon(String father, String son) {
		if(!this.graph.containsKey(father)) {
			addNode(father);
		}
		else
			this.graph.get(father).add(son);
	}
	
	public void addNode(String node) {
		this.graph.put(node, new ArrayList<String>());
		this.nodes.put(node, false);
	}
	
	public boolean hasCycle() {
		Stack<String> checked = new Stack<String>();
		
		this.graph.keySet().forEach((n) -> {
			if(!this.nodes.get(n)) {
				this.nodes.put(n, true);
				if(checked.contains(n)) {
					this.cycleDetected = true;
					return;
				}else {
					checked.push(n);
				}
			}
		});
		return this.cycleDetected;
	}
}
