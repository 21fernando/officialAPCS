public class AdditionPattern {

    private int startNum;
    private int increment;
    private int num;
    public AdditionPattern(int startNum, int increment){
        this.startNum = startNum;
        this.increment = increment;
        this.num = this.startNum;
    }

    public int currentNumber(){
        return num;
    }

    public void next(){
       num+= increment;
    }

    public void prev(){
        num-= (num>startNum)? increment:0;
    }

}
