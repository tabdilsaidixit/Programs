
public class BasicBorder extends BorderDecorator{

	public BasicBorder(IVisualComponent decoratedVisualComponent) {
		super(decoratedVisualComponent);
		// TODO Auto-generated constructor stub
	}
	
	public void drawBorder() {
		System.out.println("Basic Border added");
	}


}
