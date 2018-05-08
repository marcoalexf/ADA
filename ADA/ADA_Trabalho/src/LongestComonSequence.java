
public class LongestComonSequence {

	private int maxSeq;
	private char[] longestCSeq;

	public LongestComonSequence(char[] x, char[] y) {

		int[][] maxLength = new int[x.length][y.length];
		String[][] seqs = new String[x.length][y.length];
		compMaxLenth(x, y, maxLength, seqs);

		int xLength = x.length - 1;
		int yLength = y.length - 1;
		// Temos de devolver
		this.maxSeq = maxLength[xLength][yLength];

		this.longestCSeq = new char[maxSeq];
		compLongestCSeq(maxLength, x, y, xLength, yLength, this.longestCSeq, this.maxSeq - 1);
	}

	public void compMaxLenth(char[] seqX, char[] seqY, int[][] maxLenth, String[][] seqs) {

		for (int j = 0; j < seqY.length; j++) {
			maxLenth[0][j] = 0;
			seqs[0][j] = "";
		}
		for (int i = 0; i < seqX.length; i++) {
			maxLenth[i][0] = 0;
			seqs[i][0] = "";
		}

		for (int i = 1; i < seqX.length; i++) {
			for (int j = 1; j < seqY.length; j++) {

				if (seqX[i] == seqY[j]) {
					maxLenth[i][j] = 1 + maxLenth[i - 1][j - 1];
						System.err.println("POS: "+i+" + "+j+" "+seqs[i][j]);
					seqs[i][j] = (seqs[i - 1][j - 1]).concat(String.valueOf(seqX[i]));
				} else if (maxLenth[i - 1][j] >= maxLenth[i][j - 1]) {
					maxLenth[i][j] = maxLenth[i - 1][j];
					seqs[i][j] = seqs[i - 1][j];
				} else {
					maxLenth[i][j] = maxLenth[i][j - 1];
					seqs[i][j] = seqs[i][j - 1];
				}
			}
		}
	}

	public void compLongestCSeq(int[][] maxLength, char[] seqX, char[] seqY, int row, int col, char[] lcs, int pos) {

		while (pos >= 0) {

			if (seqX[row] == seqY[col]) {
				lcs[pos] = seqX[row];
				row--;
				col--;
				pos--;

			} else if (maxLength[row - 1][col] == maxLength[row][col - 1]) {
				String rowS = String.valueOf(seqX);
				String colS = String.valueOf(seqY);
				if (rowS.compareTo(colS) <= 0)
					row--;
				else
					col--;

			} else if (maxLength[row - 1][col] > maxLength[row][col - 1])

				row--;
			else
				col--;

		}
	}

	public int getMaxSeq() {
		return maxSeq;
	}

	public char[] getLongestCSeq() {
		return longestCSeq;
	}

}
