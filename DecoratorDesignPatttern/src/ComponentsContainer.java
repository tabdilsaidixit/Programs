
import java.util.ArrayList;
import java.util.List;

class ComponentsContainer implements IVisualComponent
{ 
	private List<IVisualComponent> componentsList = new ArrayList<IVisualComponent>(); 
	
	public void removeComponent(IVisualComponent component) 
	{ 
		componentsList.remove(component); 
	}

	@Override
	public void draw() {
		
		System.out.println("Component Container draw ===> Draws all components in container");
		for(IVisualComponent component:componentsList) 
		{ 
			component.draw(); 
		} 
	}
	public void add(IVisualComponent ivc) {
		// TODO Auto-generated method stub
		componentsList.add(ivc);
	}

	public IVisualComponent getChild(int num) {
		if(componentsList.size()>num) {
			return componentsList.get(num);
		}
		return null;
	}

	public void remove(IVisualComponent ivc) {
		if(componentsList.contains(ivc)) {
			componentsList.remove(ivc);
		}
	} 
} 