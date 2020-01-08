package collection;

import java.util.Stack;
import static java.lang.System.out;

public class StackTest {

	public static void main(String[] args) {
		String[] groupA = {"���Ű��ź", "�����Ʈ", "����", "���ѹα�"};
		Stack<String> stack = new Stack<String>();
		
		for(int i=0; i<groupA.length; i++) {
			stack.push(groupA[i]);
		}
		
		while(!stack.isEmpty())
			out.println(stack.pop());
	}
}
