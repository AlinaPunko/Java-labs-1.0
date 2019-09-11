package by.belstu.it.punko;
/*
*@Author Alina
* @Version 1.0
 */
import static java.lang.Math.*;
public class Main {
/*
* @return void
* @throws divide by zero
 * @param String[] args
*/
    public static void main(String[] args) {
	TextFunction obj = new TextFunction();
        obj.onCreate();
        int varint =5;
        String varstring = "Hello";             /*инициализируем переменные*/
        char varchar = 't';
        short varshort = 45;
        boolean varboolean = true;
        boolean varboolean1 = false;
        long varlong = 452345;
        byte varbyte = 10;
        double vardouble = 10;
        System.out.println( varstring+varint);
        System.out.println( varstring+varchar);
        System.out.println( varstring+vardouble);
        //byte result = varbyte+varint;
        //int result1=vardouble+varlong;
        long long1=varint+2147483647;
        System.out.println(long1);
        System.out.println( varboolean&&varboolean1);             /*работаем с boolean*/
        System.out.println( varboolean^varboolean1);
        //System.out.println( varboolean+varboolean1);
        //long var1= 9223372036854775807.0;
        char ch1='a',ch2= '\u0061', ch3=78;
        System.out.println( ch1 +" "+ ch2 +" "+ch3);
        System.out.println( ch1 +ch2 +ch3);
        System.out.println(sit);
        System.out.println(3.45/2.4);
        System.out.println(1.0/0.0);
        System.out.print(log(-345));
        System.out.println(Float.intBitsToFloat(0x7F800000));                 /*преобразуем данные*/
        System.out.println(Float.intBitsToFloat(0xFF800000));
        System.out.println(Math.PI);
        System.out.println(Math.E);
        System.out.println(Math.min(Math.round(Math.PI),Math.round(Math.E)));  /*работаем с классом Math*/
        double math1=Math.random();
        System.out.println(math1);
        String s34 = "2345";
        String s35 = "2345";
        System.out.println(Integer.parseInt(s34));
        Integer i1 = new Integer("2345");
        System.out.println(i1);
        Integer i2 = Integer.valueOf(s34);
        System.out.println(i2);
        exE();
        exF();
        exG();
    }
    static int sit;
    static public void exE() {
        System.out.println("Exercise E");                       /*работаем с ссылочными типами*/

        Character oChar   = new Character('a');
        Integer   oInt    = new Integer(10);
        Short     oShort  = new Short((short)-2);
        Long      oLOng   = new Long (12345678901l);
        Double    oDouble = new Double(123.456);

        int nInt = ~oInt;
        System.out.println("~Integer=" + nInt);

        char ze = 'b';
        ze += oChar;
        System.out.println("+Char=" + ze);

        int ne = oShort >> 2;
        System.out.println(ne);
        int be = oShort >>> 2;
        System.out.println(be);

        long lo = oLOng&111;
        System.out.println("Long&111=" + lo);

        System.out.println("longMIN=" + oLOng.MIN_VALUE);
        System.out.println("longMAX=" + oLOng.MAX_VALUE);
        System.out.println("doubleMIN=" + oDouble.MIN_VALUE);
        System.out.println("doubleMAX=" + oDouble.MAX_VALUE);

        Integer zint = new Integer(123);
        int zu = zint;
        Byte zbyte = new Byte((byte)255);
        byte zer = zbyte;
        int x = Integer.parseInt("9");
        System.out.println(x);
        System.out.println(Integer.toHexString(10)) ;
        System.out.println(Integer.compare(10, 2));//сравнение
        System.out.println(Integer.toString(123, 2));
        System.out.println(Integer.bitCount(123));
    }

    static public void exF(){
        System.out.println("Exercise F");
        String s34 = "2345";
        System.out.println(Integer.valueOf(s34));
        Integer kek = new Integer(s34);
        System.out.println(kek);

        byte[] nen = s34.getBytes();
        System.out.println(nen);
        String news34 = new String(nen);
        System.out.println(news34);

        System.out.println(Boolean.valueOf(s34));
        System.out.println(Boolean.getBoolean(s34));


        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("-------------");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2));
        //str2 = null;
        System.out.println(str1 == str2);
        System.out.println(str2.equals(str1));
        //System.out.println(str1.compareTo(str2));

        String str = new String("hello my dear friends");
        for(String retval : str.split(" ")){
            System.out.println(retval);
        }
        System.out.println(str.contains("my"));
        System.out.println(str.hashCode());
        System.out.println(str.indexOf("my"));                  /*работаем со строковыми функциями*/
        System.out.println(str.length());
        System.out.println(str.replace("friends", "frd"));
    }

    static public void exG(){                   /*работаем с массивами*/
        System.out.println("Exercise G");
        char[][] c1;
        int[] c2[];
        int c3[][];

        int ze[] = new int[0];

        //System.out.println(ze[2]);

        c1 = new char[3][];
        c1[0] = new char[0];
        c1[1] = new char[1];
        c1[2] = new char[2];
        System.out.println(c1.length);
        System.out.println(c1[0].length);
        System.out.println(c1[1].length);
        System.out.println(c1[2].length);

        c2 = new int[][]{ {1,2,3}, {1,2,3}, {1,2,3}};
        c3 = new int[][]{ {1,2,3}, {1,2,3}, {1,2,3}};
        boolean comRez = c2==c3;
        System.out.println(comRez);
        c2 = c3;

        for (int[] z2 : c2)
        {
            for (int z: z2)
            {
                System.out.println(z);
            }
        }
    }
}
