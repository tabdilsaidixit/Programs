
public class WindowsBuilder implements IBuilder {

	IComponent finalComponent;
	IWidgetFactory widgetFactory;
	public WindowsBuilder(){
		widgetFactory = new WindowsWidgetFactory();
	}
	@Override
	public IMainPanel constructMainPanel() {
		// TODO Auto-generated method stub
		IMainPanel imp = widgetFactory.createMainPanel();
		finalComponent = imp;
		return imp;
	}

	@Override
	public ISplitPanel constructSplitPanel(IMainPanel mainPanel) {
		// TODO Auto-generated method stub
		ISplitPanel isp = widgetFactory.createSplitPanel();
		mainPanel.add(isp);
		return isp;
	}

	@Override
	public IButtonPanel coonstructButtonPanel(IMainPanel mainPanel) {
		// TODO Auto-generated method stub
		IButtonPanel ibp = widgetFactory.createButtonPanel();
		mainPanel.add(ibp);
		
		return ibp;
	}

	@Override
	public IEmptyPanel constructEmptyPanel(ISplitPanel splitpanel) {
		// TODO Auto-generated method stub
		IEmptyPanel iep = widgetFactory.createEmptyPanel();
		splitpanel.add(iep);
		return iep;
	}

	@Override
	public IListPanel constructListPanel(ISplitPanel splitpanel) {
		// TODO Auto-generated method stub
		IListPanel ilp = widgetFactory.createListPanel();
		splitpanel.add(ilp);
		return ilp;
	}

	@Override
	public IButton constructButton(String buttonName, IButtonPanel buttonPanel) {
		// TODO Auto-generated method stub
		IButton bu = widgetFactory.createButton(buttonName);
		buttonPanel.add(bu);
		return bu;
	}
	
	@Override
	public IComponent getProduct() {
		return finalComponent;
	}

}
