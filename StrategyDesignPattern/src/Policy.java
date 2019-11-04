
public class Policy {
	

	public BorderStrategy getBorder(int condition) {
		
		BorderStrategy borderStrategy;
		switch (condition) {
		case 0:
			borderStrategy = null;
			break;
		case 1:
			borderStrategy = new DoubleBorder();
			break;
		case 2:
			borderStrategy = new FancyBorder();
			break;
		default:
			borderStrategy = new BasicBorder();
			break;
		}
		return borderStrategy;
	}

}