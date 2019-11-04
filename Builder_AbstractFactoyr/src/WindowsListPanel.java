import java.util.ArrayList;
import java.util.List;

public class WindowsListPanel implements IListPanel{

	List<IComponent> listOfComponents;
	public WindowsListPanel() {
		listOfComponents = new ArrayList<IComponent>();
	}
	@Override
	public void add(IComponent ic) {
		// TODO Auto-generated method stub
		listOfComponents.add(ic);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Windows List Panel");
		for(IComponent i:listOfComponents) {
			i.draw();
		}
	}

}
