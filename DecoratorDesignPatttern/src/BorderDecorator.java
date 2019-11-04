
public class BorderDecorator extends Decorator {

	public BorderDecorator(IVisualComponent decoratedVisualComponent) {
		super(decoratedVisualComponent);
	}
	public void draw() {
		super.draw();
		drawBorder();
	}
	
	public void drawBorder() {
		System.out.println("Normal Border added");
	}

}
