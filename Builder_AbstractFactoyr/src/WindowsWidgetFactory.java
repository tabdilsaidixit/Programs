
public class WindowsWidgetFactory implements IWidgetFactory {

	@Override
	public IMainPanel createMainPanel() {
		// TODO Auto-generated method stub
		
		return new WindowsMainPanel();
	}

	@Override
	public ISplitPanel createSplitPanel() {
		// TODO Auto-generated method stub
		return new WindowsSplitPanel();
	}

	@Override
	public IButton createButton(String s) {
		// TODO Auto-generated method stub
		return new WindowsButton(s);
	}

	@Override
	public IEmptyPanel createEmptyPanel() {
		// TODO Auto-generated method stub
		return new WindowsEmptyPanel();
	}

	@Override
	public IListPanel createListPanel() {
		// TODO Auto-generated method stub
		return new WindowsListPanel();
	}

	@Override
	public IButtonPanel createButtonPanel() {
		// TODO Auto-generated method stub
		return new WindowsButtonPanel();
	}

}
