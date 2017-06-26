

/**
 * Created by hadoop on 17-4-2.
 */
public class Test {

     public int get(String s){

         aaaaaaaaa();
         return s.length()*2;

     }

    public void aaaaaaaaa( ){

        System.out.println("aaaaaaaaaa");

    }

    public static void  bbbbb(){
        System.out.println("bb");
    }

     public static void main(String[] args) {

         Test hehehe = new Test();
         String str = "abc";
         hehehe.get(str);
         //Test.get(str);   //  wrong  !!!!


         hehehe.bbbbb();
         Test.bbbbb();

     }
}
