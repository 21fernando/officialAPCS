import java.lang.reflect.Array;
import java.util.ArrayList;

public class StringCoder {

    private String masterString;

    public StringCoder(String master) {
        masterString = master;
    }

    public String decodeString(ArrayList<StringPart> parts){
        String returnString = "";
        for(StringPart part : parts){
            returnString+= masterString.substring(part.getStart(), part.getStart() + part.getLength());
        }
        return returnString;
    }

    private StringPart findPart(String str){
        return new StringPart(0,0);
    }

    public ArrayList<StringPart> encodeString(String word){
        ArrayList<StringPart> returnList = new ArrayList<StringPart>();
        while (word.length()>0) {
            StringPart part = findPart(word);
            returnList.add(part);
            word = word.substring(part.getLength());
        }
        return returnList;
    }

}
