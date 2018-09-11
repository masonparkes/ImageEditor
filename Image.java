class Image
{
    private Pixel[][] pixels;
    private int height;
    private int width;

    public Image(Pixel[][] p,int h, int w)
    {
        pixels=p;
        height=h;
        width=w;
    }    
    public String toString()
    {
        StringBuilder sb=new StringBuilder(width+" "+height+"\n");
        for(int m=0;m<height;m++)
        {
            for(int n=0;n<width;n++)
            {
                sb.append(pixels[n][m].toString());
            }
        }
        return sb.toString();
    }
}
