import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPanel;
    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;

    //in top panel
    JLabel titleLabel;
    ImageIcon icon;

    // in middle panel
    JTextArea fortuneTextArea;
    JScrollPane scroller;

    // in bottom panel
    JButton readFortuneButton;
    JButton quitButton;


     ArrayList<String> fortunes;
     int lastFortuneIndex = -1;// Track last displayed fortune
     Random rnd = new Random();


    public FortuneTellerFrame() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        // methods
        createTopPanel();
        mainPanel.add(topPanel,BorderLayout.NORTH);
        createMiddlePanel();
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        createBottomPanel();
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);


        // Set frame size to ¾ of the screen and center it
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize((int) (screenSize.width * 0.75), (int) (screenSize.height * 0.75));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Initialize fortunes
        sillyFortunes();

    }
    private void createTopPanel(){

        topPanel = new JPanel();
        icon = new ImageIcon("src/fortune.jpg");
        //Label
        titleLabel = new JLabel("Welcome to The Fortune Teller!", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        //alignment of text with icon
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        topPanel.add(titleLabel);

    }
    private void createMiddlePanel(){

        middlePanel = new JPanel();
        //jTextArea
        fortuneTextArea = new JTextArea(12,25);
        fortuneTextArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        //scroller
        scroller = new JScrollPane(fortuneTextArea);
        middlePanel.add(scroller);



    }
    private void createBottomPanel() {

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2));

        //read fortune button
        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("Arial", Font.BOLD, 20));
        readFortuneButton.addActionListener((ActionEvent ae) -> {
            int newIndex;
            do {
                newIndex = rnd.nextInt(fortunes.size());
            } while (newIndex == lastFortuneIndex);
            lastFortuneIndex = newIndex;
            String fortune = fortunes.get(newIndex);

            fortuneTextArea.append(fortune +"\n");
        });
        //quit button
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 20 ));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));

    }
private void sillyFortunes(){
        fortunes = new ArrayList<>();
        fortunes.add("You will be hungry in the next hour");
        fortunes.add("Hard work pays off..eventually.. maybe?");
        fortunes.add("Error:404 Fortune Teller is not where to be found.");
        fortunes.add("Patience is a virtue. But so is avoiding long lines.");
        fortunes.add("If at first you don't succeed, skydiving is not for you ");
        fortunes.add("A wise person once said..something important. I forgot.");
        fortunes.add("Your secrets are safe with me I forgot.");
        fortunes.add("You will be soon recognized...at a drive-thru.");
        fortunes.add("The fortune you seek is in another cookie.");
        fortunes.add("A closed mouth gathers no food.");
        fortunes.add("You will live a long life if you avoid Mondays.");
        fortunes.add("Help! I can't get out of here!!");


}



}
