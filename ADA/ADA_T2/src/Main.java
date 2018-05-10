import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String line = input.readLine();
		String param[]= line.split(" ");
		int suspects = Integer.parseInt(param[0]);
		int nPrecedings = Integer.parseInt(param[1]);
		int nConcurent= Integer.parseInt(param[2]);
		
		int k = 0;
		
		GraphMap graph = new GraphMap();
		
		while(k < nPrecedings) {
			String in = input.readLine();
			String[] in_params = in.split(" ");
			
			graph.addNode(in_params[0]+"e"); // 0e
			graph.addNode(in_params[0]+"s"); // 0s
			graph.addNode(in_params[1]+"e");
			graph.addNode(in_params[1]+"s");
			graph.addSon(in_params[0]+"e", in_params[0]+"s"); // 0e -> 0s
			graph.addSon(in_params[0]+"s", in_params[1]+"e"); // 0e -> 0s -> 1e
			
			
			k++;
		}
		 
		k = 0;
		while(k < nConcurent) {
			String in = input.readLine();
			String[] in_params = in.split(" ");
			
			graph.addSon(in_params[0]+"e", in_params[1]+"s");
			graph.addSon(in_params[1]+"e", in_params[0]+"s");
			k++;
		}
		/*
		graph.getNodes().forEach((n) -> {
			System.out.println(n + " -> " + graph.getSons(n));
		});*/
		
		if(!graph.hasCycle())
			System.out.println("Consistent conjectures");
		else
			System.out.println("Inconsistent conjectures");
	}

}
