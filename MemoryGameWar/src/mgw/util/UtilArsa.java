package mgw.util;

/**
 *
 * @author mejap
 */

import java.util.ArrayList;
import java.util.Random;

public class UtilArsa 
{
    static Random rnd = new Random();
    
    public static <T> void shuffle(T[] arr)
    {
        for(int i = arr.length-1; i > 0; --i)
        {
            int id = rnd.nextInt(i+1);
            T temp = arr[id];
            arr[id] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static <T> void shuffle(ArrayList<T> arr)
    {
        for(int i = arr.size()-1; i > 0; --i)
        {
            int id = rnd.nextInt(i+1);
            T temp = arr.get(id);
            arr.set(id,arr.get(i));
            arr.set(i,temp);
        }
    }
    
    public static boolean within(int value, int lowerBound, int upperBound) //lower bound is implicit, upper bound is explicit
    {
        return value >= lowerBound &&  value < upperBound;
    }
    
    public static boolean roll(int chance, int bound)
    {
        return nextRandom(0,bound) < chance;
    }
    
    public static int nextRandom(int origin, int bound)
    {
        return rnd.nextInt(origin, bound);
    }
    
    public static int clamp(int value, int min, int max)
    {
        return Math.max(min, Math.min(value, max));
    }
    
    public static String padLeft(String value, char ch, int size)
    {
        String temp = "";
        for(int i = 0; i < size - value.length(); ++i)
        {
            temp += ch;
        }
        return temp + value;
    }
    
    public static String padLeft(String value, int size) 
    {
        return String.format("%"+size+"s",value);
    }
    
    public static String padRight(String value, char ch, int size)
    {
        String temp = value;
        for(int i = 0; i < size - value.length(); ++i)
        {
            temp += ch;
        }
        return temp;
    }
    
    public static String padRight(String value, int size) 
    {
        return String.format("%-"+size+"s",value);
    }
}
