import java.util.*;
public class WindowsMainPanel implements IMainPanel {

	List<IComponent> listOfComponents;
	public WindowsMainPanel(){
		listOfComponents = new ArrayList<IComponent>();
	}
	@Override
	public void add(IComponent component) {
		// TODO Auto-generated method stub
		listOfComponents.add(component);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Windows Main Panel");
		for(IComponent current: listOfComponents) {
			current.draw();
		}		
	}

}
