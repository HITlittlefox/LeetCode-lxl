package class07;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
public class MyTest {
	@Test
	public void name() {

		// TODO Auto-generated method stub
		LinkedList<Integer> s = new LinkedList<>();
		s.addLast(1);
		s.addLast(2);
		s.addLast(3);
		while (!s.isEmpty()) {
			System.out.println(s.pollLast());
		}

		int[] sta = new int[100];
		int index = 0;
		sta[index++] = 1;
		sta[index++] = 2;
		sta[index++] = 3;
		System.out.println(sta[--index]);
		System.out.println(sta[--index]);
		System.out.println(sta[--index]);
	}

}
