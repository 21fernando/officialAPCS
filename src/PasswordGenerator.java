public class PasswordGenerator{

    private int count = 0;
    private String prefix;
    private int numDigits;

    public PasswordGenerator(int numDigits, String prefix){
        this.prefix = prefix;
        this.numDigits = numDigits;
    }

    public PasswordGenerator(int numDigits){
        this.prefix = "A";
        this.numDigits = numDigits;
    }

    public int pwCount(){
        return count;
    }

    public String gen(){
        String password = prefix + ".";
        for(int i=0; i<numDigits; i++){
            password+= String.valueOf((int)(Math.random()*10));
        }
        count++;
        return password;
    }

}