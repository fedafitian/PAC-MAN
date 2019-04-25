public class PathFinderTester {

	public static void main(String[] args) {
		PathFinder pathFinder = new PathFinder();
		pathFinder.solveMaze("tinyOpen.txt", "tinyOpenSolution.txt");
		pathFinder.solveMaze("bigMaze.txt", "bigMazeSolution.txt");
		pathFinder.solveMaze("classic.txt", "classicSolution.txt");
		pathFinder.solveMaze("demoMaze.txt", "demoMazeSolution.txt");
		pathFinder.solveMaze("mediumMaze.txt", "mediumMazeSolution.txt");
		pathFinder.solveMaze("randomMaze.txt", "randomMazeSolution.txt");
		pathFinder.solveMaze("straight.txt", "straightMazeSolution.txt");
		pathFinder.solveMaze("tinyMaze.txt", "tinyMazeSolution.txt");
		pathFinder.solveMaze("turn.txt", "turnSolution.txt");
		pathFinder.solveMaze("unsolvable.txt", "unsolvableSolution.txt");
	}

}
