import java.util.ArrayList;
import java.util.List;

public class Problem {

	String [][] map;
	int w, h;

	public Problem(String [][] map, int w, int h) {
		this.map = map;
		this.w = w - 1;
		this.h = h - 1;
	}

	public boolean isLit(int x, int y) {
		// In java the first coordinate is y then x, so it runs the matrix top to bottom, then changes column
		// Therefore the code now will look weird, blame it on java

		//the position itself is a light or a lantern
		if(!map[y][x].equals("0"))
			return true;

		// last row
		if(y == h)
			if(!map[y - 1][x].equals("0") || !map[y][x - 1].equals("0") || !map[y][x + 1].equals("0")) // above, left and right
				return true;

		// first row
		if(y == 0)
			if(!map[y + 1][x].equals("0") || !map[y][x - 1].equals("0") || !map[y][x + 1].equals("0")) // below, left and right
				return true;

		// last column
		if(x == w)
			if(!map[y - 1][x].equals("0") || !map[y + 1][x].equals("0") || !map[y][x - 1].equals("0")) // left, above and below
				return true;

		// first column
		if(x == 0)
			if(!map[y - 1][x].equals("0") || !map[y + 1][x].equals("0") || !map[y][x + 1].equals("0")) // above left and right
				return true;

		// general case

		if(x != 0 && x != w && y != 0 && y != h)
			if(!map[y - 1][x].equals("0") || !map[y + 1][x].equals("0") || !map[y][x - 1].equals("0") || !map[y][x + 1].equals("0")) // above left right below
				return true;

		return false;
	}

	public boolean isDestiny(int x, int y) {
		return x == w - 1 && y == h - 1;
	}
	
	public void generateStates() {
		State initial = new State(0, 0, 0, 0);
		List<State> state_list = new ArrayList<State>();
		
		solve(map, initial, state_list);
		
		//return solve(map, initial).getD();
	}

	public int solve(String [][] map, State s, List<State> state_list) {
		// lets where he can walk
		
		if(isDestiny(s.getX(), s.getY()))
			return s.getD();
		
		// generate new states and recursion on top of them mofos
		
		//first lets see where we can walk
		
		state_list.add(s);
		if(s.getX() - 1 > 0) { // can go left
			// is left lit?
			if(isLit(s.getX() - 1, s.getY()))
				solve(map, new State(s.getX()-1, s.getY(), s.getL(), s.getD()+1), state_list);
			else if(s.getL() > 0) // does he have a lantern? then he can go, but uses lantern
				solve(map, new State(s.getX()-1, s.getY(), s.getL() - 1, s.getD()+1), state_list);
		}
		if(s.getX() + 1 < w) { // can go right
			if(isLit(s.getX() + 1, s.getY()))
				solve(map, new State(s.getX()+1, s.getY(), s.getL(), s.getD()+1), state_list);
			else if(s.getL() > 0)
				solve(map, new State(s.getX()+1, s.getY(), s.getL() - 1, s.getD()+1), state_list);
		}
		if(s.getY() - 1 > 0) { // can go up
			if(isLit(s.getX(), s.getY() - 1))
				solve(map, new State(s.getX(), s.getY() - 1, s.getL(), s.getD()+1), state_list);
			else if(s.getL() > 0)
				solve(map, new State(s.getX(), s.getY() - 1, s.getL() - 1, s.getD()+1), state_list);
		}
		if(s.getY() + 1 < h) { // can go up
			if(isLit(s.getX(), s.getY() + 1))
				solve(map, new State(s.getX(), s.getY() + 1, s.getL(), s.getD()+1), state_list);
			else if(s.getL() > 0)
				solve(map, new State(s.getX(), s.getY() + 1, s.getL() - 1, s.getD()+1), state_list);
		}
		
		s.getD();
	}
}
