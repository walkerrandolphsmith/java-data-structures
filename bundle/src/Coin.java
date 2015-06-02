
/**
 * Write a description of class Coin here.
 * 
 * @author (Walker Smith) 
 * @version (1.0)
 */
public class Coin
{
    private int value;

    public Coin()
    {
        this(1);
    }

    public Coin (int newValue)
    {
        value = newValue;
    }
    
    public int getValue()
    {
        return value;
    }
}
