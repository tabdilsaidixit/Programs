import java.util.ArrayList;
import java.util.List;

public class MacMainPanel implements IMainPanel{
	List<IComponent> listOfComponents;
	
	public MacMainPanel() {
		// TODO Auto-generated constructor stub
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
		System.out.println("Mac Main Panel");
		for(IComponent current: listOfComponents) {
			current.draw();
		}	
	}

}
