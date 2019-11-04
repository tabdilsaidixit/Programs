import java.util.*;
public class WindowsSplitPanel implements ISplitPanel {
	List<IPanel> listOfPanels;
	
	public WindowsSplitPanel() {
		listOfPanels = new ArrayList<IPanel>();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Windows Split Panel");
		for(IPanel i:listOfPanels) {
			i.draw();
		}
		
	}

	@Override
	public void add(IPanel ip) {
		// TODO Auto-generated method stub
		if(listOfPanels.size()<2) {
			listOfPanels.add(ip);
		}
	}

}
