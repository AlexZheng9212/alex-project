/**
 * Game of Life https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */
package com.interview.leetcode;

class Solution289 {
    int m;
    int n;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = currentLiveNeighbour(board, i, j);
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                }

            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    /**
     * @param board
     * @param row
     * @param col
     * @return
     */

    private int currentLiveNeighbour(int[][] board, int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j > board[0].length) {
                    count += board[i][j] & 1;
                }
            }
        }
        count -= board[row][col] & 1;
        return count;
    }

    public static void main(String[] args) {
        Solution289 s = new Solution289();
        int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        s.gameOfLife(board);
    }
}