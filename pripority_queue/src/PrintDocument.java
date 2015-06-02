
public class PrintDocument<E> implements Comparable<E>
{
	private E fileName;
	private int timeStamp;
	private int docLength;
	
	public PrintDocument(E file, int timeStamp, int length)
	{
		fileName = file;
		this.timeStamp = timeStamp;
		docLength = length;
	}

	@Override
	public int compareTo(E fileName) {
		// TODO Auto-generated method stub
		if( fileName == this.fileName)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	public E getFileName()
	{
		return fileName;
	}
	
	public int getTimeStamp()
	{
		return timeStamp;
	}
	
	public int getDocLength()
	{
		return docLength;
	}
}
