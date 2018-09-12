import java.lang.*;

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
        StringBuilder sb=new StringBuilder(width+" "+height+"\n"+255+"\n");
        for(int m=0;m<height;m++)
        {
            for(int n=0;n<width;n++)
            {
                sb.append(pixels[n][m].toString());
            }
        }
        return sb.toString();
    }
    public Image Invert()
    {
        Pixel[][] newpixels=new Pixel[width][height];
        for(int m=0;m<height;m++)
        {
            for(int n=0;n<width;n++)
            {
                newpixels[n][m]=pixels[n][m].pInvert();
            }
        }
        return new Image(newpixels,height,width);
    }
    public Image Grayscale()
    {
        Pixel[][] newpixels=new Pixel[width][height];
        for(int m=0;m<height;m++)
        {
            for(int n=0;n<width;n++)
            {
                newpixels[n][m]=pixels[n][m].Avg();
            }
        }
        return new Image(newpixels,height,width);        
    }
    public Image Emboss()
    {
        Pixel[][] newpixels=new Pixel[width][height];
        for(int m=0;m<height;m++)
            {
                for(int n=0;n<width;n++)
                {
                    
                    newpixels[n][m]=new Pixel(128,128,128);
                }
            }
        for(int m=height-1;m>0;m--)
        {
            for(int n=width-1;n>0;n--)
            {
                int redDiff=pixels[n][m].getRed()-pixels[n-1][m-1].getRed();
                int blueDiff=pixels[n][m].getBlue()-pixels[n-1][m-1].getBlue();
                int greenDiff=pixels[n][m].getGreen()-pixels[n-1][m-1].getGreen();

                int maxDiff=redDiff;
                if(Math.abs(greenDiff)>Math.abs(maxDiff)){maxDiff=greenDiff;}
                if(Math.abs(blueDiff)>Math.abs(maxDiff)){maxDiff=blueDiff;}
                int v=128+maxDiff;
                if(v<0){v=0;}
                if(v>255){v=255;}
                newpixels[n][m]=new Pixel(v,v,v);
            }
        }
        return new Image(newpixels,height,width);   
     }
    public Image MotionBlur(int toblur)
    {
        Pixel[][] newpixels=new Pixel[width][height];
        for(int m=height-1;m>=0;m--)
        {
            for(int n=width-1;n>=0;n--)
            {
                if(n+toblur<width)//then we don't have to worry about the right edge
                {
                    int redtotal=0;
                    int bluetotal=0;
                    int greentotal=0;
                    for(int i=n;i<n+toblur;i++)
                    {
                        redtotal+=pixels[i][m].getRed();
                        bluetotal+=pixels[i][m].getBlue();
                        greentotal+=pixels[i][m].getGreen();
                    }
                    int redavg=redtotal/(toblur);
                    int blueavg=bluetotal/(toblur);
                    int greenavg=greentotal/(toblur);
                    newpixels[n][m]=new Pixel(redavg,greenavg,blueavg);
                 }
                 else
                 {
                    int redtotal=0;
                    int bluetotal=0;
                    int greentotal=0;
                    for(int i=n-toblur;i<width;i++)
                    {
                       redtotal+=pixels[i][m].getRed();
                       bluetotal+=pixels[i][m].getBlue();
                       greentotal+=pixels[i][m].getGreen();
                    }
                    int redavg=redtotal/(width-n);
                    int blueavg=bluetotal/(width-n);
                    int greenavg=greentotal/(width-n);
                    newpixels[n][m]=new Pixel(redavg,greenavg,blueavg);
                 }
            }
                
        }
    
        return new Image(newpixels,height,width);
    }
}
