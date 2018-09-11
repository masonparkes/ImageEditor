

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

}
