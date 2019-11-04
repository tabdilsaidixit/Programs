
public class Director {
	
	IBuilder builder;
	public Director(IBuilder builder) {
		this.builder = builder;
	}
	
	public void constructProduct() {
		IMainPanel imp = builder.constructMainPanel();
		ISplitPanel isp = builder.constructSplitPanel(imp);
		IButtonPanel ibp = builder.coonstructButtonPanel(imp);
		builder.constructEmptyPanel(isp);
		builder.constructListPanel(isp);
		builder.constructButton("B1", ibp);
		builder.constructButton("B2", ibp);
		builder.constructButton("B3", ibp);
	}

}
