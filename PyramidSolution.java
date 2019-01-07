import java.util.*;
import java.io.*;
public class PyramidSolution {
	private static String res = "";
	public static String pyramid(Map<Integer, List<Integer>> map, int target) {
		StringBuilder sb = new StringBuilder();
		helper(map, target, sb, 0, 0, 1);
		return res;
	}

	private static void helper(Map<Integer, List<Integer>> map, int target, 
		                       StringBuilder sb, int x, int y, int cur) {
		if (x >= map.size()) {
			if (cur == target) {
				res = sb.substring(0, sb.length() - 1);
			}
			return;
		}
		if (cur > target) {
			return;
		}
		int val = map.get(x).get(y);

		sb.append('L');
		helper(map, target, sb, x + 1, y, cur * val);
		sb.deleteCharAt(sb.length() - 1);

		sb.append('R');
		helper(map, target, sb, x + 1, y + 1, cur * val);
		sb.deleteCharAt(sb.length() - 1);
	} 

	public static void main(String[] args) throws IOException {
		File file = new File("pyramid_sample_input.txt");
		Scanner sc = new Scanner(file);
		// while (sc.hasNextLine()) {
		// 	System.out.println(sc.nextLine());
		// }
		int start = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		String[] t = sc.nextLine().split(" ");
		int target = Integer.parseInt(t[1]);
		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().split(",");
			map.putIfAbsent(start, new ArrayList<>());
			List<Integer> l = map.get(start);
			for (String s : line) {
				l.add(Integer.parseInt(s));
			}
			start++;
		}
		System.out.println(PyramidSolution.pyramid(map, target));
	}
}