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

		String [][] map = new String [h][w];
		
		for(int i = 0; i < h; i++) {
			String params [] = input.readLine().split(" ");
			for(int k = 0; k < w; k++) {
				map[i][k] = params[k];
			}
		}
		
		Problem p = new Problem(map, w ,h);
		
		
		try {
			System.out.println(p.solve().getD());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
