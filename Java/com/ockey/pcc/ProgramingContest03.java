package com.ockey.pcc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramingContest03 {
	public static void main (String[] args) {
		int n = 10;
		int max_value = 0;
		int min_value = 0;
		List<Integer> x = Arrays.asList(2, 6, 7);
		List<String> max = Arrays.asList("Right", "Right", "Right");
		List<String> min = Arrays.asList("Right", "Right", "Right");
		if (n < 1 || n > 50) System.out.println("n: Domain error. Must be (1 <= n <= 50).");
		for(int obj : x) {
			if (obj < 1 || obj > n) System.out.println("x: Domain error. Must be (1 <= x <= " + n + ").");
		}
		for (int i = 0; i < x.size(); i++) {
			if (x.get(i) < (n - x.get(i))) {
				min.set(i, "Left");
				if (max_value < (n - x.get(i))){
					max_value = (n - x.get(i));
				}
				if (min_value == 0 ||  min_value < x.get(i)){
					min_value = x.get(i);
				}
			} else {
				max.set(i, "Left");
				if (max_value < x.get(i)){
					max_value = x.get(i);
				}
				if (min_value == 0 || min_value < (n - x.get(i))){
					min_value = (n - x.get(i));
				}
			}
		}
		PrintArray("Max  " + max_value + " : ", max);
		PrintArray("Min  " + min_value + " : ", min);
	}
	public static void PrintArray (String str, List<String> list) {
		System.out.print(str);
		for(String obj : list) {
			System.out.print(obj + ",");
		}
		System.out.println();
	}
}
