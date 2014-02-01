package com.ockey.pcc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramingContest04 {
	public static void main(String[] args) {
		Structure04 field = new Structure04();
		System.out.println(detectPoolSum(field));
	}
	
	public static int detectPoolSum(Structure04 field) {
		List<String> errorMessages = new ArrayList<String>();
		if (field.n < 1 || field.n > 100) errorMessages.add("n: Domain error. Must be (1 <= n <= 100).");
		if (field.m < 1 || field.m > 100) errorMessages.add("m: Domain error. Must be (1 <= m <= 100).");
		
		return detectPool(field, 0);
	}
	
	private static int detectPool(Structure04 field, int sum) {
		for (int i = 0; i < field.n; i++) {
			for (int j = 0; j < field.m; j++) {
				if (field.intArray[i][j] == 1) {
					field.intArray[i][j] = 2;
					sum++;
					int pos[] = {i, j};
					sum = searchPoolChain(field, pos, sum);
				}
			}
		}
		return sum;
	}
	
	private static int searchPoolChain(Structure04 field, int[] pos, int sum) {
		for (int i = (pos[0] - 1); i <= (pos[0] + 1); i++) {
			for (int j = (pos[1] - 1); j <= (pos[1] + 1); j++) {
				if (i < 0 || field.n <= i) continue;
				if (j < 0 || field.m <= j) continue;
				if (field.intArray[i][j] == 1) {
					field.intArray[i][j] = 2;
					pos[0] = i;
					pos[1] = j;
					sum = searchPoolChain(field, pos, sum);
				}
			}
		}
		return sum;
	}
}
