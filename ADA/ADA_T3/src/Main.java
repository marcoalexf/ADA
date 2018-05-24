import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String dimensions_input = input.readLine();
		String [] dimensions = dimensions_input.split(" ");
		
		int w = Integer.parseInt(dimensions[0]);
		int h = Integer.parseInt(dimensions[1]);

		String [][] map = new String [w][h];
		
		for(int i = 0; i < h; i++) {
			String params [] = input.readLine().split(" ");
			for(int k = 0; k < params.length; k++) {
				map[i][k] = params[k]; // reverse it so the matrix does x THEN y
			}
		}
		Problem p = new Problem(map, w ,h);
		
		
		System.out.println("At " + map[4][3] + " (3, 4), is there a light? ->" + p.isLit(3, 4));
	}

}
