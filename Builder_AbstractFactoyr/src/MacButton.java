
public class MacButton implements IButton{

	private String name;
	public MacButton(String name){
		this.name = name;
	}
	
	public void draw(String name) {
		// TODO Auto-generated method stub
		System.out.println("Mac Button -> "+name);
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		draw(name);
	}

}
