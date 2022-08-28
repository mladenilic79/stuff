package d_external;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

// component enables us to manual draw of elements
public class GuiSwing extends Component {

    GregorianCalendar calendar;
    int sec, minute, hour;

    public GuiSwing() {
        // return date/time based on your time zone and locale
        calendar = (GregorianCalendar) GregorianCalendar.getInstance();
    }

    // default method paint for drawing
    @Override
    public void paint(Graphics g) {

        /*
        overriding older method for possible adding of more functionality???
        not mandatory to call.. depends
        */
        super.paint(g);

        calendar = (GregorianCalendar) GregorianCalendar.getInstance();

        sec = calendar.get(GregorianCalendar.SECOND);
        minute = calendar.get(GregorianCalendar.MINUTE);
        hour = calendar.get(GregorianCalendar.HOUR);

        double secan = ((360 / 60) * sec) - 180;
        double houran = ((360 / 12) * hour) - 180;
        double minutean = ((360 / 60) * minute) - 180;

        // casting of extra option from 2d class
        Graphics2D g2 = (Graphics2D) g;

        // set width of stroke
        g2.setStroke(new BasicStroke(10));
        
        // set overall color
        g2.setColor(Color.blue);
        Color boja = new Color(125, 50, 200);
        g2.setColor(boja);

        // input image
        Image img = null;
        try {
            img = ImageIO.read(new URL(
                    "https://img.squareyards.com/secondaryPortal/637908895199164539-1506221131593159.jpg?d=244x145"));
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        g2.drawImage(img, 0, 0, this);

        // moves coordinate system
        g2.translate(200, 200);

        // coordinates, dimensions
        g2.drawOval(-50, -50, 100, 100);

        // affine transformations
        // set
        AffineTransform savedTransform = g2.getTransform();

        // rotate
        g2.rotate(Math.toRadians(secan));
        g2.fillRect(0, 0, 1, 50);

        // reset
        g2.setTransform(savedTransform);
        // rotate
        g2.rotate(Math.toRadians(minutean));
        g2.fillRect(0, 0, 1, 50);

        // reset
        g2.setTransform(savedTransform);
        // rotate
        g2.rotate(Math.toRadians(houran));
        g2.fillRect(0, 0, 1, 50);

        // manual call every second for update of paint method
        repaint(1000);
    }
    
    public static void main(String[] args) throws InterruptedException {

        // class call
        JFrame frame1 = new JFrame();
        frame1.setTitle("clock class");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(450, 450);
        frame1.setLocation(1050, 50);

        // set font object
        Font font = new Font("Lucida Grande",Font.BOLD,34);

        // html tags makes <br> available inside jlabel
        String sstring1 = "<html>Embark on a journey full of conspiracies,<br>"
                + "trickery and secrets where you can never tell<br>"
                + "a friend from foe.<br>"
                + "Along the way, you will encounter diverse allies<br>"
                + "who will fight alongside you.</html>";
        
        // jlabel
        JLabel label1 = new JLabel(sstring1);
        label1.setFont(font);
        frame1.add(label1);
        
        // class call
        GuiSwing clock = new GuiSwing();
        frame1.add(clock);

        // set backgroud color in the pane
        frame1.getContentPane().setBackground(Color.yellow);
        
        /*
        should always be last after all have been added
        repeat set visible after every modification
        */
        frame1.setVisible(true);

        // sets this window permanently on top of others
        frame1.setAlwaysOnTop(true); 
        // to front brings window to front of all jvm and set focus to her
        frame1.toFront();
        // request focus from platform
        frame1.requestFocus();
        
        // border layout (border layout is default)
        JFrame frame2 = new JFrame();
        frame2.setTitle("border layout");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(450, 450);
        frame2.setLocation(50, 50);

        // border layout extension (input in border layout)
        BorderLayout bl = new BorderLayout();
        JPanel pn1 = new JPanel(bl);
        pn1.add(new JButton("inner page start"), BorderLayout.PAGE_START);
        pn1.add(new JButton("inner page start"), BorderLayout.PAGE_END);
        pn1.add(new JButton("inner page start"), BorderLayout.CENTER);
        pn1.add(new JButton("inner page start"), BorderLayout.WEST);
        pn1.add(new JButton("inner page start"), BorderLayout.EAST);
        frame2.add(pn1, BorderLayout.PAGE_START);

        // border layout
//        f.add(new JButton("page start"),BorderLayout.PAGE_START);
        frame2.add(new JButton("page start"), BorderLayout.PAGE_END);
        frame2.add(new JButton("page start"), BorderLayout.CENTER);
        frame2.add(new JButton("page start"), BorderLayout.WEST);
        frame2.add(new JButton("page start"), BorderLayout.EAST);

        frame2.setVisible(true);

        // box layout
        JFrame frame3 = new JFrame();
        frame3.setTitle("box layout");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(450, 450);
        frame3.setLocation(550, 50);

        BoxLayout boxLayout = 
                new BoxLayout(frame3.getContentPane(), BoxLayout.PAGE_AXIS);
        frame3.setLayout(boxLayout);

        // creates an invisible component that's always the specified size
        frame3.add(Box.createRigidArea(new Dimension(20, 20)));
        frame3.add(new JButton("hello"));
        frame3.add(Box.createRigidArea(new Dimension(20, 20)));
        frame3.add(new JButton("hello"));
        /*
        Creates an invisible "glue" component that can be useful in a Box
        whose visible components have a maximum width (for a horizontal box)
        or height (for a vertical box)
        */
        frame3.add(Box.createGlue());
        frame3.add(new JButton("world"));

        frame3.setVisible(true);

        // spring layout
        JFrame frame4 = new JFrame();
        frame4.setTitle("spring layout");
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setSize(450, 450);
        frame4.setLocation(50, 550);

        SpringLayout springLayout = new SpringLayout();
        frame4.setLayout(springLayout);

        JButton btn1 = new JButton("hello");
        JButton btn2 = new JButton("world");
        frame4.add(btn1);
        frame4.add(btn2);
        springLayout.putConstraint(SpringLayout.WEST, 
                btn1, 50, SpringLayout.WEST, frame4.getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, 
                btn1, 50, SpringLayout.NORTH, frame4.getContentPane());

        frame4.setVisible(true);

        // grid layout
        JFrame frame5 = new JFrame();
        frame5.setTitle("grid layout");
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setSize(450, 450);
        frame5.setLocation(550, 550);

        GridLayout grid = new GridLayout(2, 2);
        grid.setHgap(5);
        grid.setVgap(5);
        // or on one line
//        GridLayout grid = new GridLayout(2, 2, 5, 5);
        frame5.setLayout(grid);

        frame5.add(new JButton("1"));
        frame5.add(new JButton("2"));
        frame5.add(new JButton("3"));
        frame5.add(new JButton("4"));

        frame5.setVisible(true);

        /*
        nesting layout
        regular outer frame
        */
        JFrame frame6 = new JFrame();
        frame6.setTitle("nesting layout");
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame6.setSize(450, 450);
        frame6.setLocation(1050, 550);

        // nested inner panel frame
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.LINE_AXIS));
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton("Button" + i);
            // ??????????????????????????????? size setting ???????????????
            btn.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
            btn.setMinimumSize(new Dimension(1, 0));
            pnl.add(btn);
        }

        frame6.add(pnl, BorderLayout.PAGE_START);
        frame6.add(new JButton("Button1"), BorderLayout.CENTER);

        frame6.setVisible(true);

        Thread.sleep(2000);
        frame1.dispose();
        Thread.sleep(100);
        frame2.dispose();
        Thread.sleep(100);
        frame3.dispose();
        Thread.sleep(100);
        frame4.dispose();
        Thread.sleep(100);
        frame5.dispose();
        Thread.sleep(100);
        frame6.dispose();
        
        System.out.println("executed");
    }
}
