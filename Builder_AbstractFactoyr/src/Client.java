
public class Client {
	public static void main(String[] args) {
		IBuilder builder = new MacBuilder(); 
		Director dir = new Director(builder);
		dir.constructProduct();
		IComponent ic = builder.getProduct();
		ic.draw();
	}
}
