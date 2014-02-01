package com.ockey.pcc;

public class ProgramingContest02 {
	public static void main (String[] args) {
		int N = 4;
		int[] A = { 4, 5, 10, 20};
		int MaxLen = 0;
		int CurLen = 0;
		if (N < 3 || N > 10) {
			System.out.println("N: Domain error. Must be (1 <= N <= 50).");
			return;
		}
		for (int i = 0; i < N; i++ ){
			if (A[i] < 1 || A[i] > Math.pow(10, 6)) {
				System.out.println("A: Domain error. Must be (1 <= K <= 10^6). " + A[i] + " has been detected.");
				return;
			}
		}
		for (int i = 0; i < N; i++ ){
			for (int j = (i + 1); j < N; j++ ){
				for (int k = (j + 1); k < N; k++ ){
					if (2*Math.max(A[i], Math.max(A[j], A[k])) > (A[i] + A[j] + A[k])) {
						CurLen = 0;
					} else {
						CurLen = A[i] + A[j] + A[k];
					}
					if (MaxLen < CurLen) {
						MaxLen = CurLen;
					}
				}
			}
		}
		System.out.println("Max Length = " + MaxLen);
		return;
	}
}
