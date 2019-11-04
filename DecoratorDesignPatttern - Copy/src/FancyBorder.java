
public class FancyBorder extends BorderDecorator{

	public FancyBorder(IVisualComponent decoratedVisualComponent) {
		super(decoratedVisualComponent);
		// TODO Auto-generated constructor stub
	}
	
	
	public void drawBorder() {
		System.out.println("Fancy Border added");
	}


}
