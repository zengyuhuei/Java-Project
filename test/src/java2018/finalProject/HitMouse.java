package java2018.finalProject;

import java.awt.Cursor;  
import java.awt.Image;  
import java.awt.Point;  
import java.awt.Toolkit;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;  
import java.util.Random;  
 
import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JMenu;  
import javax.swing.JMenuBar;  
import javax.swing.JMenuItem;  
import javax.swing.JOptionPane;  
import javax.swing.JPanel;  
import javax.swing.Timer;  
 
 
public class HitMouse extends JFrame implements ActionListener,MouseListener
{  
  
  private static final long serialVersionUID = 1L;
  boolean isOver = false;  //設置標記，遊戲是否結束
  private String dir = "../picture/"; //圖片目錄  
  JLabel jlbMouse;//地鼠  
  Timer timer;    //時間定時器
  Random random;  //隨機生成地鼠位置  
  int delay = 1000; //延遲時間
  Toolkit tk;  
  Image image;  
  Cursor myCursor;  
  JLabel showNum,currentGrade,hitNum;  
  int showNumber=0,hitNumber=0,currentGrades=1;  
     
  public HitMouse()
  {  
      super("打地鼠");  
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(500, 300);  
      this.setLocationRelativeTo(null);//設置窗口在畫面中心  
      setbackground();//設置背景  
      this.getContentPane().setLayout(null);//設置框架佈局模式為空（只有這樣，才能知道圖片的真正位置  
      //設置滑鼠游標為錘子圖片
      tk = Toolkit.getDefaultToolkit();
      image = tk.createImage(dir + "chui1.png");  
      myCursor = tk.createCustomCursor(image, new Point(30,30), "xxx");  
      this.setCursor(myCursor);  
      
      setMessage();//設置一些提示訊息
      //在背景圖片的基礎上設置地鼠圖片  
      ImageIcon imageMouse = new ImageIcon(dir+"datou.png");  
      jlbMouse = new JLabel(imageMouse);  
      jlbMouse.setSize(100,100);  
      this.getContentPane().add(jlbMouse);  
      jlbMouse.setVisible(false);  
      jlbMouse.addMouseListener(this);//添加滑鼠游標監聽  
      //定時器 
      timer = new Timer(delay,this);  
      random = new Random();  
      timer.start();  
         
      addMenu();//添加下拉選單 
         
      this.setResizable(false);//設置視窗大小不能改變
      this.setVisible(true);  
  }  
     
  private void addMenu() 
  {  
      JMenuBar menubar = new JMenuBar();  
      this.setJMenuBar(menubar);  
      JMenu game = new JMenu("打地鼠遊戲");
      
      JMenuItem jitemNew = new JMenuItem("新游戏");  
      jitemNew.setActionCommand("new");  
      jitemNew.addActionListener(this);  
      JMenuItem jitemPause = new JMenuItem("暂停");  
      jitemPause.setActionCommand("pause");  
      jitemPause.addActionListener(this);  
      JMenuItem jitemExit = new JMenuItem("退出");  
      jitemExit.setActionCommand("exit");  
      jitemExit.addActionListener(this);  
    /*  JMenuItem jitemEasy= new JMenuItem("简单");  
      jitemExit.setActionCommand("easy");  
      jitemExit.addActionListener(this); 
      JMenuItem jitemYiban= new JMenuItem("中等");  
      jitemExit.setActionCommand("yiban");  
      jitemExit.addActionListener(this); 
      JMenuItem jitemKunnan= new JMenuItem("困难");  
      jitemExit.setActionCommand("kunnan");  
      jitemExit.addActionListener(this)*/ 
      game.add(jitemNew);  
      game.add(jitemPause);  
      game.addSeparator();//下拉選單裡設置分隔線
      game.add(jitemExit);  
      game.addSeparator();//下拉選單裡設置分隔線
     /* game.add(jitemEasy);  
      game.add(jitemYiban);  
      game.add(jitemKunnan);  */
      menubar.add(game);  
  }  
     
  private void setbackground() {  
      ((JPanel)(this.getContentPane())).setOpaque(false);//如果為 true，則該組件繪製其邊界內的所有像素。否則該組件可能不繪製部分或所有像素，從而允許其底層像素透視出来。   
      ImageIcon bgImage = new ImageIcon(dir+"beijing.jpg");  
      JLabel bgLabel = new JLabel(bgImage);  
      bgLabel.setBounds(0, 25, bgImage.getIconWidth(), bgImage.getIconHeight());  
      this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));//設置背景圖片的層次最低  
  }  
     
  private void setMessage() 
  {  
      ImageIcon showNumb = new ImageIcon(dir+"chuxiancishu.png");  
      JLabel showLabel = new JLabel(showNumb);  
      showLabel.setBounds(8, 8, 92, 80);  
      this.getContentPane().add(showLabel);  
      showNum = new JLabel("0");  
      showNum.setBounds(8, 8, 92, 80);  
      this.getContentPane().add(showNum);  
         
      ImageIcon hitNumb = new ImageIcon(dir+"chuxiancishu.png");  
      JLabel hitLabel = new JLabel(hitNumb);  
      hitLabel.setBounds(148, 8, 92, 80);  
      this.getContentPane().add(hitLabel);  
      hitNum = new JLabel("0");  
      hitNum.setBounds(148, 8, 92, 80);  
      this.getContentPane().add(hitNum);  
         
      ImageIcon grade = new ImageIcon(dir+"dangqiandengji.png");  
      JLabel gradeLabel = new JLabel(grade);  
      gradeLabel.setBounds(288, 8, 92, 80);  
      this.getContentPane().add(gradeLabel);  
      currentGrade = new JLabel("1");  
      currentGrade.setBounds(288, 8, 92, 80);  
      this.getContentPane().add(currentGrade);  
  }  
 
 
  public static void main(String[] args) {  
      new HitMouse();  
  }  
     
  public void actionPerformed(ActionEvent e) {   
      //對下拉選單註冊事件監聽  
      if(e.getSource() instanceof JMenuItem){  
          menuItemFun(e);  
      }  
         
      int ran=random.nextInt(9);//隨機生成一個0~9(不包括9)的隨機數
      ImageIcon imageMouse = new ImageIcon(dir+"dishu.png");//保證每次隨機生成的地鼠圖片都是為沒被打時的圖片  
      jlbMouse.setIcon(imageMouse);  
      switch(ran){  
      case 0:jlbMouse.setLocation(70, 40);break;  
      case 1:jlbMouse.setLocation(185, 35);break;  
      case 2:jlbMouse.setLocation(315,40);break;  
      case 3:jlbMouse.setLocation(55,95);break;  
      case 4:jlbMouse.setLocation(190,95);break;  
      case 5:jlbMouse.setLocation(315,90);break;  
      case 6:jlbMouse.setLocation(50, 155);break;  
      case 7:jlbMouse.setLocation(190, 160);break;  
      case 8:jlbMouse.setLocation(320, 160);break;  
      }  
         
      jlbMouse.setVisible(true);  
         
      showNumber++;  
      showNum.setText(""+showNumber);  
         
      if( !gamePlan() ){//判断游戏是否结束，并显示游戏进程  
          timer.stop();  
      }  
         
  }  
  //監聽下拉選單功能  
  private void menuItemFun(ActionEvent e) 
  {  
      if (e.getActionCommand().equalsIgnoreCase("new")) {//新遊戲
          timer.stop();  
          showNumber=0;  
          hitNumber=0;  
          currentGrades=1;  
          delay=1000;  
          isOver=false;  
          showNum.setText(""+showNumber);  
          hitNum.setText(""+hitNumber);  
          currentGrade.setText(""+currentGrades);  
          timer = new Timer(delay,this);  
             timer.start();  
      }  
      if (e.getActionCommand().equalsIgnoreCase("exit")) {//退出  
          isOver=true;
          System.exit(EXIT_ON_CLOSE);  
      }  
         
      if (e.getActionCommand().equalsIgnoreCase("pause")) {//暂停  
          timer.stop();  
          JOptionPane.showMessageDialog(this, "繼續請按“確定”");  
          timer.start();  
      }  
      
    /*  if (e.getActionCommand().equalsIgnoreCase("easy")) {  
          timer.stop();  
          showNumber=0;  
          hitNumber=0;  
          currentGrades=1; 
          delay=2500;
          isOver=false;  
          showNum.setText(""+showNumber);  
          hitNum.setText(""+hitNumber);
          currentGrade.setText(""+currentGrades); 
          timer = new Timer(delay,this);  
          timer.start(); 
      }  
      
      
      if (e.getActionCommand().equalsIgnoreCase("yiban")) {
          timer.stop();  
          showNumber=0;  
          hitNumber=0;  
          currentGrades=1; 
          delay=1000;
          isOver=false;  
          showNum.setText(""+showNumber);  
          hitNum.setText(""+hitNumber);
          currentGrade.setText(""+currentGrades);
          timer = new Timer(delay,this);  
          timer.start(); 
      }  
   
      if (e.getActionCommand().equalsIgnoreCase("kunnan")) {  
          timer.stop();  
          showNumber=0;  
          hitNumber=0;  
          currentGrades=1; 
          delay=100;
          isOver=false;  
          showNum.setText(""+showNumber);  
          hitNum.setText(""+hitNumber);
          currentGrade.setText(""+currentGrades);
             timer = new Timer(delay,this); 
             timer.start(); 
            
     } */
      
  }  
 
  private boolean gamePlan() 
  {  
      if(showNumber-hitNumber > 8){  
          JOptionPane.showMessageDialog(this, "Game Over !");  
          isOver=true;  
          return false;  
      }  
      if(hitNumber > 5){  
          hitNumber=0;  
          showNumber=0;  
          currentGrades++;  
          if(delay>100){  
              delay-=50;  
          }else if(delay>=500){  
              delay=500;  
          }  
          timer.setDelay(delay); 
          hitNum.setText(""+hitNumber);  
          showNum.setText(""+showNumber);  
          currentGrade.setText(""+currentGrades);  
      }  
      return true;  
  }  
 
  public void mouseClicked(MouseEvent e) {  
         
  }  
 
  public void mousePressed(MouseEvent e) 
  {  
      if(isOver){  
          return ;  
      }  
      image = tk.createImage(dir+"chui2.png");  
      myCursor = tk.createCustomCursor(image, new Point(10,10), "xxx");  
      this.setCursor(myCursor);//滑鼠游標按下時，游標顯示打下去的圖片，模擬打的動作 
      //如果打中地鼠，則地鼠換成被打中的圖片，模擬地鼠被打  
      if(e.getSource()==jlbMouse){  
          ImageIcon imageIconHit = new  ImageIcon(dir+"datou.png");  
          jlbMouse.setIcon(imageIconHit);  
          jlbMouse.setVisible(true);  
      }  
         
      hitNumber++;  
      hitNum.setText(""+hitNumber);  
  }  
 
  public void mouseReleased(MouseEvent e) 
  {  
      if(isOver){  
          return ;  
      }  
      //當滑鼠游標放開之後，滑鼠游標變回原来沒按下時的圖片
      image = tk.createImage(dir+"chui1.png");  
      myCursor = tk.createCustomCursor(image, new Point(10,10), "xxx");  
      this.setCursor(myCursor);  
  }  
 
  public void mouseEntered(MouseEvent e) {  
         
  }  
 
  public void mouseExited(MouseEvent e) {  
         
  }  
 
 
}
