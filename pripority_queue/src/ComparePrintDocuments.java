import java.util.Comparator;


public class ComparePrintDocuments implements Comparator<PrintDocument>
{

	private static final double P1 = 0.8;
	private static final double P2 = 0.2;
	
	@Override
	public int compare(PrintDocument left, PrintDocument right)
	{
		return Double.compare(orderValue(left), orderValue(right));
	}
	
	private double orderValue(PrintDocument pd)
	{
		return P1 * pd.getDocLength() + P2 * pd.getTimeStamp();
	}
	
	public static void main (String [] args)
	{
		PrintDocument left = new PrintDocument("Left", 10, 5);
		PrintDocument right = new PrintDocument("Right", 8, 2);
		ComparePrintDocuments comparing = new ComparePrintDocuments(); 
		int order = comparing.compare(left, right);
		System.out.println(order);
		//Should print 1 to indicate left's priority is higher than right's priority
		
		PrintDocument newLeft = new PrintDocument("newLeft", 10, 5);
		PrintDocument newRight = new PrintDocument("newRight",1000, 2);
		int newOrder = comparing.compare(newLeft, newRight);
		System.out.println(newOrder);
		//Should print -1 to indicate newRight's priority is higher than newLeft's priority	
	}

}
