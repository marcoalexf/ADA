import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		String line = input.readLine();
		System.out.println("Line read: " + line);
		String param[] = line.split(" ");
		int suspects = Integer.parseInt(param[0]);
		System.out.println("Suspects: " + suspects);
		int nPrecedings = Integer.parseInt(param[1]);
		System.out.println("Preceidings: " + nPrecedings);
		int nConcurent = Integer.parseInt(param[2]);
		System.out.println("Concurent: " + nConcurent);

		Graph g = new Graph(suspects);

		int temp = nPrecedings-1;
		String precedents;
		String paramPrec[];
		while (0 <= temp) {
			precedents = input.readLine();
			paramPrec = precedents.split(" ");
			int orgin = Integer.parseInt(paramPrec[0]);
			int destination = Integer.parseInt(paramPrec[1]);
			g.addEdge(orgin, destination);
			temp--;
		}
		String concurents;
		String paramConcurrent[];
		while(temp<nConcurent) {
			concurents= input.readLine();
			 paramConcurrent= concurents.split(" ");
			
			
			
			
			
			temp++;
		}
	}

}
