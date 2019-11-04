
import java.util.ArrayList;
import java.util.List;
public class MacSplitPanel implements ISplitPanel {
	List<IPanel> listOfPanels;
	
	public MacSplitPanel() {
		listOfPanels = new ArrayList<IPanel>();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Mac Split Panel");
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
