
public class State {
	
	int x, y, l, d;
	
	public State(int x, int y, int l, int d) {
		this.x = x;
		this.y = y;
		this.l = l;
		this.d = d;
	}

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getL() {
		return this.l;
	}
	
	public int getD() {
		return this.d;
	}
	
	public void setL(int l) {
		this.l = l;
	}
}
