package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

	private static char ME = 'X';
	private static char OP = 'O';
	private static final Optimal opt = new Optimal(ME, OP);
	static String txtFile = "";

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Select file to process
		txtFile = args[0];

		// Verify args
		if (args.length > 1) {
			System.out.println("Usage: java -cp classes vttp.batch5.sdf.task02.Main [<directory>\\/<fileName>]");
		}

		File filePath = new File(txtFile);

		// Print as shown in example
		System.out.println("Processing: " + txtFile);
		System.out.println("\nBoard:");
		char[][] board = readFile(filePath);
		Board gameBoard = new Board(board);
		gameBoard.printBoard();

		System.out.println("----------------------");

		int[] bestMove = opt.getMove(gameBoard);
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col <3; col++) {
				System.out.println("y=" + bestMove[0] + ", x=" + bestMove[1] + ", utility=" + bestMove[2]); 
			}
		}

	}

	private static char[][] readFile(File file) throws FileNotFoundException, IOException {
		char[][] board = new char[3][3];
		BufferedReader br = new BufferedReader(new FileReader(txtFile));
		for (int row = 0; row < 3; row++) {
			String line = br.readLine();
			board[row] = line.toCharArray();
		}
		br.close();
		return board;
	}
}
