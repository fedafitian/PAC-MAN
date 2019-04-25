import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class PathFinder {

	public static void solveMaze(String inputFile, String outputFile) {
		String line = null;

		try {
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			FileWriter fileWriter = new FileWriter(outputFile);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			int width;
			int height;

			String[] dimensions = bufferedReader.readLine().split(" ");
			height = Integer.parseInt(dimensions[0]);
			width = Integer.parseInt(dimensions[1]);

			Node maze[][] = new Node[height][width];

			Node start = null;
			Node goal = null;
			// Takes in each new line and increments to 1
			for (int i = 0; (line = bufferedReader.readLine()) != null; i++) {
				for (int j = 0; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case 'X':
						maze[i][j] = null;
						break;
					case ' ':
						maze[i][j] = new Node(line.charAt(j), Integer.MAX_VALUE, i, j); // infinity value
						break;
					case 'S':
						maze[i][j] = new Node(line.charAt(j), 0, i, j);
						start = maze[i][j];
						break;
					case 'G':
						maze[i][j] = new Node(line.charAt(j), Integer.MAX_VALUE, i, j);
						goal = maze[i][j];
						break;
					}
				}

			}
			
			//edges up down left right
			int[] x = { 0, 1, 0, -1 };
			int[] y = { 1, 0, -1, 0 };

			PriorityQueue<Node> p = new PriorityQueue<>();
			p.add(start);
			while (!p.isEmpty()) {
				Node curr = p.poll();
				if (curr != goal) {
					for (int k = 0; k < 4; k++) {
						Node temp = maze[curr.i + x[k]][curr.j + y[k]];
						// temp != null makes sure path doesn't go over or through walls
						// other part of &&, makes sure we take the shortest path
						if (temp != null && temp.weight > curr.weight + 1) {
							temp.weight = curr.weight + 1;
							p.add(temp);
						}
					}
				}
			}
			
			//Traverses maze from goal to start
			//Also makes path
			for (Node current = goal; goal.weight != Integer.MAX_VALUE && current != start;) {
				for (int k = 0; k < 4; k++) {
					Node temp = maze[current.i + x[k]][current.j + y[k]];
					if (temp != null && (current.weight - 1) == temp.weight) {
						if (temp == start) {
							current = temp;
							break;
						}
						temp.nodeType = '.';
						current = temp;
					}
				}
			}

			//Writer; writes the file
			printWriter.println(height + " " + width + " ");
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if(maze[i][j] == null) {
						printWriter.print('X');
					} else {
						printWriter.print(maze[i][j].nodeType);
					}
				}
				printWriter.println();
			}
			
			bufferedReader.close();
			printWriter.close();

		} catch (FileNotFoundException ex) {
			System.err.println("Unable to open file '" + inputFile + "'");
		} catch (IOException ex) {
			System.err.println("Err reading file '" + inputFile + "'");
		}
	}
}
