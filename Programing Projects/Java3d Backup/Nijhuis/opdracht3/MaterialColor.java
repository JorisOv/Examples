package opdracht3;

import java.util.Hashtable;

public class MaterialColor {

  private static Hashtable ht = new Hashtable();

  public MaterialColor()
  {
  }

  public static void put(Object key, Object content)
  {
    ht.put(key, content);
  }

  public static Object get(Object key)
  {
    return ht.get(key);
  }

  public static void main(String[] args)
  {
    MaterialColor mc = new MaterialColor();
    mc.put(new String("Test"), new String("TestString"));

    System.out.println(mc.get(new String("Test")));

  }

} 