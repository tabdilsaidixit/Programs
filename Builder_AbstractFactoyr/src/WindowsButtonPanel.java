import java.util.*;
public class WindowsButtonPanel implements IButtonPanel{

	List<IButton> listOfButtons;
	public WindowsButtonPanel() {
		listOfButtons = new ArrayList<IButton>();
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Windows Button Panel");
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
