

class Pixel{

    private int Red;
    private int Green;
    private int Blue;

    public Pixel(int r, int g, int b)
    {
        Red=r;
        Green=g;
        Blue=b;
    }
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append(Red);
        sb.append(" ");
        sb.append(Green);
        sb.append(" ");
        sb.append(Blue);
        sb.append("\n");
        return sb.toString();
    }
    public Pixel pInvert()
    {
        int R=255-Red;
        int G=255-Green;
        int B=255-Blue;
        Pixel p=new Pixel(R,G,B);
        return p;
    }
    public Pixel Avg()
    {
        int avg=Red+Green+Blue;
        avg=avg/3;
        Pixel p=new Pixel(avg,avg,avg);
        return p;
    }
    public int getRed()
    { return Red;}
    public int getGreen()
    { return Green;}
    public int getBlue()
    { return Blue;}
}
