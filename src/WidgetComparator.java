import java.util.*;
public class WidgetComparator implements Comparator<Widget>  {
    private boolean asc;
    public WidgetComparator(){
        asc = true;
    }
    public WidgetComparator(boolean a ){
        asc = a;
    }

    public int compare(Widget w1, Widget w2){
        //return (asc) ? w1.getName().compareTo(w2.getName()): -w1.getName().compareTo(w2.getName());
        int diff = w1.getName().compareTo(w2.getName());
        if(diff==0){
            diff = w1.getId()-w2.getId();
            if(diff==0){
                diff = new Double(w1.getCost()).compareTo(w2.getCost());
            }
        }
        return (asc)? diff: -diff;
    }
}
