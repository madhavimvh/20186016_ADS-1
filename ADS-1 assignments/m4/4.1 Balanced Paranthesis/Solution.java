import java.util.Scanner;

public class Solution {
	private Solution() {
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		while (sc.hasNext()) {
			String input = sc.nextLine();
		Balanceparens paren = new Balanceparens(input);
			System.out.println(input);
			paren.checkbraces();
		}
	}
}
class Stack {
	private int top;
	private char[] items;
	public Stack() {
		top = 0;
		items = new char[100];
	}
	public void push(char x) {
		if (top == 99) {
			System.out.println("Stack is full");			
		} else {
			items[top++] = x;
		}
	}
	public char pop() {
		char element = '\0';
		if (top == 0) {
			System.out.println("Underflow error");
			return '\0';
		} else {
			element = items[--top];
		}
		return element;
	}
	public boolean isEmpty() {
		if (top == 0) {
			return true;
		} else {
			return false;
		}
	}
}
class Balanceparens {
	private String input;
	private Stack stack;
	public Balanceparens(String input1) {
		this.input = input1;
		this.stack = new Stack();
	}
	public boolean checkbraces() {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
				stack.push(input.charAt(i));
			}
			if (input.charAt(i) == ')' || input.charAt(i) == '}' || input.charAt(i) == ']') {
				if (stack.isEmpty()) {
					return false;
				} else {
					return matching(stack.pop(), input.charAt(i));
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean matching(char char1, char char2) {
		if (char1 == '(' && char1 == ')') {
			return true;
		} else if (char1 == '[' && char1 == ']') {
			return  true;
		} else if (char1 == '{' && char1 == '}') {
			return true;
		} else {
			return false;
		}
	}
}