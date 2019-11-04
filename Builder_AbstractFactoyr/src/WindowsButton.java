
public class WindowsButton implements IButton {

	public String name;
	public WindowsButton(String name) {
		// TODO Auto-generated method stub
		this.name = name;

	}
	public void draw(String name) {
		// TODO Auto-generated method stub
		System.out.println("Windows Button -> " +name );
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		draw(name);
	}

}
