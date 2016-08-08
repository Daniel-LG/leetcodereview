package com.lg.leetcode.array;

public class GameOfLife289 {
	public void gameOfLife(int[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				int lives = countNeighborLive(board, i, j);
				if (((board[i][j] & 1) == 1) && (lives == 2 || lives == 3))
					board[i][j] |= 2;
				if ((board[i][j] & 1) == 0 && lives == 3)
					board[i][j] |= 2;
				
			}
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				board[i][j] >>= 1;
	}
	
	private int countNeighborLive(int[][] board, int i , int j) {
		int lives = 0;
		int m = board.length;
		int n = board[0].length;
		for (int ii = Math.max(i - 1, 0); ii <= Math.min(i + 1, m - 1); ii++)
			for (int jj = Math.max(j - 1, 0); jj <= Math.min(j + 1, n - 1); jj++) {
				lives += board[ii][jj] & 1;
			}
		lives -= board[i][j] & 1;
		return lives;
	}
}
