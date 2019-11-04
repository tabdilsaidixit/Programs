
public class SolidBorder extends BorderDecorator{

	public SolidBorder(IVisualComponent decoratedVisualComponent) {
		super(decoratedVisualComponent);
	}
	
	public void drawBorder() {
		System.out.println("Solid Border added");
	}


}
