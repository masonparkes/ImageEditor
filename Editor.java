import java.io.*;
import java.util.*;
class Editor
{
    public static void main(String args[])throws Exception
    {
        int size=args.length;
        for (int i=0; i<size; i+=3)  
        {
            try
            {
                Integer.parseInt(args[i]);
                i++;
            }
            catch (NumberFormatException e)
            {
                
            }
            File infile=new File(args[i]);
            String outfile=args[i+1];
            BufferedReader br= new BufferedReader(new FileReader(infile));

            //So, for every file we have to find the sizes, and ignore everything else there
            int h=0;
            int w=0;
            while (h==0&&w==0)
            {
                String st=br.readLine();
                System.out.println(st);
                String[] words=st.split(" ",8);
                for (int j=0;j<words.length;j++)
                {
                    System.out.println(words[j]);
                    try
                    {
                        w=Integer.parseInt(words[j]);
                        h=Integer.parseInt(words[j+1]);
                        //break;
                    }
                    catch (NumberFormatException e) {}
                    catch (ArrayIndexOutOfBoundsException e2){}
                }
            }
            //Get the pixels
            ArrayList<Integer> vals=new ArrayList<Integer>(1);
            System.out.println("Height: "+h);
            System.out.println("Width: "+w);
            int maxsize=h*w*3;System.out.println("maxsize: "+maxsize);
            while (vals.size()!=maxsize)
            {

                    String line=br.readLine();
                   String[] parts=line.split(" ",-1);
                   for (int j=0;j<parts.length;j++)
                    {
                    System.out.println(parts[j]);
                        try
                        {
                            vals.add(Integer.parseInt(parts[j]));
                        }
                        catch(NumberFormatException e){}
                    }
            }
             // create an image
            //Image img=new Image(h,w,pixels);  
            System.out.print("You collected: ");
            System.out.print(vals.size());
            System.out.println(" values");
            
            Pixel[][] pixels=new Pixel[w][h];
            int k=0;
            for(int m=0;m<h;m++)
            {
                for(int n=0;n<w;n++)
                {
                     int R=vals.get(k);k++;
                     int G=vals.get(k);k++;
                     int B=vals.get(k);k++;
                     pixels[n][m]=new Pixel(R,G,B);
                }
            }
            Image original=new Image(pixels,h,w);
            save(original,outfile);
            /*
            if (args[i+2].equals("grayscale"))
            {

            }
            else if (args[i+2].equals("invert"))
            {

            }
            else if (args[i+2].equals("emboss"))
            {

            }
            else if (args[i+2].equals("motionblur"))
            {
                int blurlength=Integer.parseInt(args[i+3]);
            }


            String st=br.readLine();
            //System.out.println(st);
            writer.write(st);
            writer.close();
*/
        }
    }

    public static void save(Image im,String filename) throws Exception
    {
System.out.println("Saving image to file: "+filename);
        BufferedWriter writer= new BufferedWriter(new FileWriter(filename));
        writer.write("P3");
        writer.newLine();
        writer.write(im.toString());
        System.out.println(im.toString());
    }
}