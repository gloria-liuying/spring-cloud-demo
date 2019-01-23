package SerialTest;

import java.io.*;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/19
 */
public class SerialzableTest {
    public static void main(String[] args)throws Exception {
        serializeFlyPig();
      //  FlyPig flyPig = deserializeFlyPig();
       // System.out.println(flyPig.toString());
    }
    //序列化
    private static void serializeFlyPig() throws IOException {
        FlyPig flyPig = new FlyPig();
        flyPig.setAge(333);
        flyPig.setName("zhuzhu");
        //对象输出流。。
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("f:/xiaozhuzhu")));

//        ObjectOutputStream oos = new ObjectInputStream(new FileInputStream(new File("f:/xiaozhuzhu")));
        oos.writeObject(flyPig);
        System.out.println("success");
        oos.close();
    }
    //反序列化
    private static FlyPig  deserializeFlyPig() throws Exception{
//        ObjectOutputStream ois = new ObjectInputStream(new FileInputStream(new File("f:/xiaozhuzhu")));
        //FlyPig p = (FlyPig)ois.readObject();
        return null;
    }
}
