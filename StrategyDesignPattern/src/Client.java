
public class Client {
	public static void main(String[] args) {
		Policy policy = new Policy();
		int situation =1;
		TextView textViewInstance =  new TextView(policy.getBorder(situation));
		textViewInstance.draw();
		System.out.println("=======");
		
		situation = 2;
		
		textViewInstance.setBorderStrategy(policy.getBorder(situation));
		textViewInstance.draw();
		
		System.out.println("=======");
		
	}

}
