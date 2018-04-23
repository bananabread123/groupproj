import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.Date;
import java.util.*;
import javax.swing.event.*;

 public class ToDo extends JPanel {
 private static String curr_user;
 private static String curr_pass;

 public static void main(String[] args) {

  JFrame window = new JFrame("TO DO LIST");
  JPanel content = new JPanel();

  content.setLayout(new GridLayout(1,3));
  JLabel login_instruct = new JLabel("<html><h1>ACCOUNT LOGIN</h1></html>",SwingConstants.CENTER);
  JLabel user1 = new JLabel("<html><h1>USERNAME</h1></html>");
  JLabel pass1 = new JLabel("<html><h1>PASSWORD</h1></html>");
  JTextField u1 = new JTextField("");
  JPasswordField p = new JPasswordField("");
  JLabel user2 = new JLabel("<html><h1>USERNAME</h1></html>");
  JLabel pass2 = new JLabel("<html><h1>PASSWORD</h1></html>");
  JTextField u2 = new JTextField("");
  JTextField newp1 = new JTextField("");
  JButton login = new JButton("<html><h1>LOGIN</h1></html>");
  JButton clear1 = new JButton("<html><h1>CLEAR</h1></html>");
  JButton clear2 = new JButton("<html><h1>CLEAR</h1></html>");
  JLabel newacct = new JLabel("<html><h1>CREATE AN ACCOUNT</h1></html>",SwingConstants.CENTER);
  JButton create = new JButton("<html><h1>CREATE</h1></html>");
  JLabel about = new JLabel("<html><h1>USERNAME AND PASSWORD MUST BE 5-8 LETTERS<html><h1>");
  JLabel blank3 = new JLabel("");
  JTextField text = new JTextField("enter stuff here");
  JButton enter = new JButton("<html><h1>ENTER</h1></html>");
  JLabel logresult1 = new JLabel("");
  JLabel logresult2 = new JLabel("");
	JLabel answer = new JLabel("");
  JLabel error = new JLabel("");
  JLabel memo_text = new JLabel("");
  JButton done = new JButton("<html><h1>I FINISHED EVERYTHING!</h1></html>");
  JLabel todo = new JLabel("<html><h1>TO DO LIST</h1></html>",SwingConstants.CENTER);
  JLabel blank5 = new JLabel("");
  JLabel blank6 = new JLabel("");

  JPanel signup = new JPanel();
  signup.setLayout(new GridLayout(6, 2));
  signup.setBackground(new Color(230,240,250));
  signup.add(newacct);
  signup.add(error);
  signup.add(about);
  signup.add(blank3);
  signup.add(user2);
  signup.add(u2);
  signup.add(pass2);
  signup.add(newp1);
  signup.add(create);
  signup.add(clear2);
  signup.add(logresult2);
  content.add(signup);

  JPanel play = new JPanel();
  play.setLayout(new BorderLayout());
  play.setBackground(new Color(200,240,250));
  play.add(todo,BorderLayout.PAGE_START);
  JPanel center = new JPanel();
  center.setLayout(new GridLayout(1,2));
  center.add(text);
  // put scrolling functionality for long lists -- so isn't always present -Lo
  JScrollPane scroll = new JScrollPane(center);
  scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  center.add(memo_text);
  play.add(scroll,BorderLayout.CENTER); // do not change that it is scroll and not center in param
                                        // center is added to scroll so it will work -Lo

  JPanel end = new JPanel();
  end.setLayout(new GridLayout(2,2));
  String[] colorStrings = {"Black", "Red","Blue", "Green"};
  SpinnerListModel colorModel = new SpinnerListModel(colorStrings);
  JSpinner spinner = new JSpinner(colorModel);
  String[] fontStrings = { "Times New Roman", "Helvetica", "Comic Sans MS", "Marker Felt", "Lucida" };
  JComboBox fontList = new JComboBox(fontStrings);
  fontList.setSelectedIndex(2);
  end.add(fontList);
  end.add(spinner);
  end.add(blank6);
  end.add(enter);
  end.add(done);
  play.add(end,BorderLayout.PAGE_END);
  content.add(play);
  Data.init();

  JPanel signin = new JPanel();
  signin.setLayout(new GridLayout(5, 2));
  signin.setBackground(new Color(230,240,250));
  signin.add(login_instruct);
  signin.add(blank5);
  signin.add(user1);
  signin.add(u1);
  signin.add(pass1);
  signin.add(p);
  signin.add(login);
  signin.add(clear1);
  signin.add(logresult1);
  content.add(signin);

  spinner.addChangeListener(new ChangeListener(){
      @Override
      public void stateChanged(ChangeEvent e){
        JSpinner spinner = (JSpinner) e.getSource();
        String listColor = (String)spinner.getValue();
        if(listColor.equals("Black")){
          String words = Data.readFile(curr_user, curr_pass);
          memo_text.setText("<html>"+words+"</h1></html> ");
          memo_text.setForeground(Color.BLACK);
        }
        if(listColor.equals("Red")){
          String words = Data.readFile(curr_user, curr_pass);
          memo_text.setText("<html>"+words+"</h1></html>");
          memo_text.setForeground(Color.RED);
        }
        if(listColor.equals("Blue")){
          String words = Data.readFile(curr_user, curr_pass);
          memo_text.setText("<html>"+words+"</h1></html>");
          memo_text.setForeground(Color.BLUE);
        }
        if(listColor.equals("Green")){
          String words = Data.readFile(curr_user, curr_pass);
          memo_text.setText("<html>"+words+"</html>");
          memo_text.setForeground(Color.GREEN);
        }
      }
    });

    fontList.addActionListener(new ActionListener(){
      @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String fontName = (String)cb.getSelectedItem();

        if(fontName.equals("Times New Roman")){
          String words = Data.readFile(curr_user, curr_pass);
          memo_text.setText("<html>"+words+"</h1></html> ");
          memo_text.setFont(new Font("Times New Roman", Font.PLAIN,14));
        }
        if(fontName.equals("Helvetica")){
          String words = Data.readFile(curr_user, curr_pass);
          memo_text.setText("<html>"+words+"</h1></html>");
          memo_text.setFont(new Font("Helvetica", Font.PLAIN,14));
        }
        if(fontName.equals("Comic Sans MS")){
          String words = Data.readFile(curr_user, curr_pass);
          memo_text.setText("<html>"+words+"</h1></html>");
          memo_text.setFont(new Font("Comic Sans MS", Font.PLAIN,14));
        }
        if(fontName.equals("Marker Felt")){
          String words = Data.readFile(curr_user, curr_pass);
          memo_text.setText("<html>"+words+"</html>");
          memo_text.setFont(new Font("Marker Felt", Font.PLAIN,14));
        }
        if(fontName.equals("Lucida")){
          String words = Data.readFile(curr_user, curr_pass);
          memo_text.setText("<html>"+words+"</html>");
          memo_text.setFont(new Font("Lucida Handwriting", Font.PLAIN,14));
        }
      }
    });

  clear1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent event) {
    u1.setText("");
    p.setText("");
   }
  });

  clear2.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent event) {
    u2.setText("");
    newp1.setText("");

   }
  });

  login.addActionListener(new ActionListener() {
   String found = "";
   String notfound = "";
   String words = "";
   public void actionPerformed(ActionEvent event) {
    String username = u1.getText();
    String password = p.getText();
    if (Data.checkUser(username, password)) {
     found = "Login succesful";
     logresult1.setText(found);
     words = Data.readFile(username, password);
     memo_text.setText("<html>"+words+"</h1></html>");
     curr_user=username;
     curr_pass=password;
    } else {
     notfound = "Login unsuccesful.Try again.";
     logresult1.setText(notfound);
    }
   }
  });

  create.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent event) {
    String saved = "";
    String notsaved = "";
    String username = u2.getText();
    String password = newp1.getText();
    if (StoreInfo.checkInfo(username, password)) {
     saved = "Your account has been created";
     logresult2.setText(saved);
     Data.addUser(new StoreInfo(username, password));
     Data.writeTo(new StoreInfo(username, password));
    } else {
     notsaved = "Incorrect password or username. Please reenter";
     logresult2.setText(notsaved);
    }
   }
  });

  enter.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent event) {
     String memo = text.getText();
     Data.writeResults(memo, curr_user, curr_pass);
     String words = Data.readFile(curr_user, curr_pass);
     memo_text.setText("<html>"+words+"</h1></html>");
    }
  });

  done.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent event) {
     Data.removeMemo(curr_user,curr_pass);
     memo_text.setText("");
    }
  });

  window.setContentPane(content);
  window.pack();
  window.setLocation(100, 100);
  window.setSize(1200,600);
  window.setVisible(true);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 }

}
