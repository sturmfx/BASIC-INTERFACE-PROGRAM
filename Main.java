import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main
{
    public static JFrame gui = new JFrame();
    public static JButton load = new JButton("LOAD PICTURE");

    public static JFrame image = new JFrame();
    public static JLabel picLabel;
    public static BufferedImage myPicture;
    static String image_path = "";
    final static JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    public static void main(String[] args)
    {
        load.addActionListener(e ->
        {
            int returnValue = fc.showOpenDialog(null);
            image_path = fc.getSelectedFile().getAbsolutePath();
            try
            {
                load_image();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        });
        gui.setSize(new Dimension(200, 500));
        gui.add(load);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void load_image() throws IOException
    {
        image.dispose();
        myPicture = ImageIO.read(new File(image_path));
        image = new JFrame();
        image.setSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));
        picLabel = new JLabel(new ImageIcon(myPicture));
        image.add(picLabel);
        image.setVisible(true);
    }

}
