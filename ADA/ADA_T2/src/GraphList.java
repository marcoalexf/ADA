import java.util.LinkedList;
import java.util.List;

public class GraphList {
	
	List<String> [] array;
	
	public GraphList(int suspects) {
		this.array = new LinkedList[2 * suspects];
		for(List l : array)
			l = new LinkedList<String>();
	}
	
	// 0s    0 -> 0e
	public void addSon(int first, int second) {
		this.array[2 * first].add(first+"s");
		this.array[2 * first + 1].add(second+"e");
		this.array[2 * second].add(second+"s");
	}
	
	
}
