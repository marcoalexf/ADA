import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem {

	String [][] map;
	int w, h;

	public Problem(String [][] map, int w, int h) {
		this.map = map;
		this.w = w - 1;
		this.h = h - 1;
	}

	public boolean isLit(int x, int y, int dx, int dy) {
		if(map[y][x].equals("*") || map[dy][dx].equals("*"))
			return true;

		return false;
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
		return x == w && y == h;
	}

	public boolean isDestiny(State s) {
		return s.getX() == w && s.getY() == h;
	}

	public State solve() throws Exception {
		State initial = new State(0,0,0,0);

		Queue<State> explored = new LinkedList<>();

		explored.add(initial);

		return solve(explored);
	}

	public State solve(Queue<State> explored) throws Exception {

		//generate and put in explored
		while(!explored.isEmpty()) {
			if(isDestiny(explored.peek()))
				return explored.poll();

			explored.addAll(generate(explored.poll()));
		}

		throw new Exception();
	}

	public List<State> generate(State s){
		List<State> generated = new ArrayList<>();

		//is the current lantern better then mine?
		if(!map[s.getY()][s.getX()].equals("0") && !map[s.getY()][s.getX()].equals("*"))
			if(Integer.parseInt(map[s.getY()][s.getX()]) > s.getL())
				s.setL(Integer.parseInt(map[s.getY()][s.getX()]));

		// move up
		if(s.getY() - 1 >= 0)
			if(isLit(s.getX(), s.getY(), s.getX(), s.getY() - 1))
				generated.add(new State(s.getX(), s.getY() - 1, s.getL(), s.getD() + 1));
			else if(s.getL() > 0)
				generated.add(new State(s.getX(), s.getY() - 1, s.getL() - 1, s.getD() + 1));

		// move down
		if(s.getY() + 1 <= h)
			if(isLit(s.getX(), s.getY(), s.getX(), s.getY() + 1))
				generated.add(new State(s.getX(), s.getY() + 1, s.getL(), s.getD() + 1));
			else if(s.getL() > 0)
				generated.add(new State(s.getX(), s.getY() + 1, s.getL() - 1, s.getD() + 1));

		// move left
		if(s.getX() - 1 >= 0)
			if(isLit(s.getX(), s.getY(), s.getX() - 1, s.getY()))
				generated.add(new State(s.getX() - 1, s.getY(), s.getL(), s.getD() + 1));
			else if(s.getL() > 0)
				generated.add(new State(s.getX() - 1, s.getY(), s.getL() - 1, s.getD() + 1));


		// move rigth
		if(s.getX() + 1 <= w)
			if(isLit(s.getX(), s.getY(), s.getX() + 1, s.getY()))
				generated.add(new State(s.getX() + 1, s.getY(), s.getL(), s.getD() + 1));
			else if(s.getL() > 0)
				generated.add(new State(s.getX() + 1, s.getY(), s.getL() - 1, s.getD() + 1));	

		return generated;
	}
}
