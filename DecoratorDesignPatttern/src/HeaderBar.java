
public class HeaderBar extends Decorator {

	public HeaderBar(IVisualComponent decoratedVisualComponent) {
		super(decoratedVisualComponent);
	}
	public void draw() {
		super.draw();
		drawHeaderBar();
	}
	public void drawHeaderBar() {
		System.out.println("Header Bar added");
	}
}
