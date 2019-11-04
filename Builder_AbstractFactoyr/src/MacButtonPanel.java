import java.util.ArrayList;
import java.util.List;
public class MacButtonPanel implements IButtonPanel{

	List<IButton> listOfButtons;
	public MacButtonPanel() {
		listOfButtons = new ArrayList<IButton>();
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Mac Button Panel");
		for(IButton b:listOfButtons) {
			b.draw();
		}
	}

	@Override
	public void add(IButton button) {
		// TODO Auto-generated method stub
		listOfButtons.add(button);
	}

}
