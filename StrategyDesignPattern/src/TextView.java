
public class TextView {
	
	private BorderStrategy borderStrategy;
	
	public TextView(BorderStrategy borderStrategy){
		this.borderStrategy =borderStrategy;
	}

	public BorderStrategy getBorderStrategy() {
		return borderStrategy;
	}

	public void setBorderStrategy(BorderStrategy borderStrategy) {
		this.borderStrategy = borderStrategy;
	}

	public void draw() {
		System.out.println("Text View");
		
		if(borderStrategy!=null) {
			borderStrategy.draw();
		}
	}

}
