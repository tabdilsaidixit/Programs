
public interface IBuilder {
	public IMainPanel constructMainPanel();
	public ISplitPanel constructSplitPanel(IMainPanel mainPanel);
	public IButtonPanel coonstructButtonPanel(IMainPanel mainPanel);
	public IEmptyPanel constructEmptyPanel(ISplitPanel splitpanel);
	public IListPanel constructListPanel(ISplitPanel splitpanel);
	public IButton constructButton(String buttonName, IButtonPanel buttonPanel);
	public IComponent getProduct();

}
