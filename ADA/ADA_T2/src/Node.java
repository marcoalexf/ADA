import java.util.LinkedList;

public class Node {

	private int value ;
	private int inDegre;
	private LinkedList< Node> sons=new LinkedList<Node>();

	public Node (int value){
		 this.value= value;
		 this.inDegre=0;
	}
	
	public void  addSon(Node son) {
		sons.add(son);
	}
	public void removeSon(Node son) {
		sons.remove(son.getValue());
	}
	public LinkedList<Node> getSons(){
		return sons;
		
	}
	//Raise the number of nodes that point to this node
	public void addDegree() {
		this.inDegre++;
	}
	public int getInDegree() {
		return this.inDegre;
	}
	public int getValue() {
		return this.value;
	}
}
