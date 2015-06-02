/**
 * @author (Walker Smith) 
 * @version (1.1)
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
