public class Android extends Robot	{
    private int servoCount;

    public Android(int initVal)	{
        setServoCount(initVal);
    }

    public int getServoCount()	{
        return super.getServoCount();
    }

    public int getLocal()	{
        return servoCount;
    }

    public void setServoCount(int in)	{
        super.setServoCount(in);
    }

    public void setLocal(int in)	{
        servoCount = in;
    }

    public static void main(String[] args) {
        Android a = new Android(5);
        System.out.println(a.getServoCount());
    }
}