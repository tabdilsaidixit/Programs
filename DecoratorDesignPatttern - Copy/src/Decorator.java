public abstract class Decorator implements IVisualComponent {
	private IVisualComponent decoratedVisualComponent;
	public Decorator(IVisualComponent decoratedVisualComponent) {
		this.decoratedVisualComponent = decoratedVisualComponent;
	}
	public void draw() {
		decoratedVisualComponent.draw();
	}

}

