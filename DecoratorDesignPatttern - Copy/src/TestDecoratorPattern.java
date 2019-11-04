
public class TestDecoratorPattern {
	public static void main(String[] args) {
		IVisualComponent texView = new TextView();
		IVisualComponent textViewWithScrollbar =
				new DoubleBorder(new  BasicBorder( new  FancyBorder(texView)));
		textViewWithScrollbar.draw();
	}
}
