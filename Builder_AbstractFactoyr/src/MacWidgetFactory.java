
public class MacWidgetFactory implements IWidgetFactory {

	@Override
	public IMainPanel createMainPanel() {
		// TODO Auto-generated method stub
		return new MacMainPanel();
	}

	@Override
	public ISplitPanel createSplitPanel() {
		// TODO Auto-generated method stub
		return new MacSplitPanel();
	}

	@Override
	public IButton createButton(String s) {
		// TODO Auto-generated method stub
		return new MacButton(s);
	}

	@Override
	public IEmptyPanel createEmptyPanel() {
		// TODO Auto-generated method stub
		return new MacEmptyPanel();
	}

	@Override
	public IListPanel createListPanel() {
		// TODO Auto-generated method stub
		return new MacListPanel();
	}

	@Override
	public IButtonPanel createButtonPanel() {
		// TODO Auto-generated method stub
		return new MacButtonPanel();
	}

}
