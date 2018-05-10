import java.util.ArrayList;
import java.util.HashSet;

public class GraphNode {
	
	HashSet<String> sons;
	String id;
	
	public GraphNode(String id) {
		this.sons = new HashSet<String>();
		this.id = id;
	}
	
	public void addSon(String son) {
		this.sons.add(son);
	}
	
	public String getID() {
		return this.id;
	}

}
