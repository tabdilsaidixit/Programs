
public class TestDecoratorPattern {
	public static void main(String[] args) {
		RabbitPictureBox rabbitPictureBox = new RabbitPictureBox();
		IVisualComponent rabbitPBWithSB = new SolidBorder(rabbitPictureBox);
		IVisualComponent rabbitPBWithSBandHB = new  HeaderBar(rabbitPBWithSB);
		
		EmptyTextBox emptyTextBox = new EmptyTextBox();
		IVisualComponent emptyTBWithHB = new HeaderBar(emptyTextBox);
		IVisualComponent emptyTBWithHBandSB = new SolidBorder (emptyTBWithHB);
		
		RabbitTextBox rabbitTextBox = new RabbitTextBox();
		
		ComponentsContainer componentsContainer = new ComponentsContainer();
		componentsContainer.add(rabbitTextBox);
		componentsContainer.add(rabbitPBWithSBandHB);
		
		IVisualComponent componentsContainerWithDecorator = new SolidBorder(componentsContainer);
	
		ComponentsContainer mainComponentsContainer = new ComponentsContainer();
		mainComponentsContainer.add(componentsContainerWithDecorator);
		mainComponentsContainer.add(emptyTBWithHBandSB);
		
		IVisualComponent mainComponentWithSolidBorder = new SolidBorder(mainComponentsContainer);
		IVisualComponent mainComponentWithSolidBorderandHeaderBar = new HeaderBar(mainComponentWithSolidBorder);
		
		mainComponentWithSolidBorderandHeaderBar.draw();
		
	}
}
