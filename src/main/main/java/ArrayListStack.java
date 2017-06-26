import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 17-4-26.
 */
public class ArrayListStack {
    private List<String> list = new ArrayList<String>();
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public String pop(){
        if(list.isEmpty())
            return null;
        String result = list.get(list.size()-1);
        list.remove(result);
        return result;
    }
    public void push(String value){
        list.add(value);
    }
    public static void main(String[] args){
        ArrayListStack stack = new ArrayListStack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
