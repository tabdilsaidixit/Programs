
public interface IWidgetFactory {
	
	public IMainPanel createMainPanel();
	public ISplitPanel createSplitPanel();
	public IButton createButton(String s);
	public IEmptyPanel createEmptyPanel();
	public IListPanel createListPanel();
	public IButtonPanel createButtonPanel();
}
