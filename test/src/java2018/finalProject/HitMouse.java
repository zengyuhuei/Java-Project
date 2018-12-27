package java2018.finalProject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;  
import java.awt.Point;  
import java.awt.Toolkit;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
  JLabel showNum,currentGrade,hitNum, restNum;  
  int showNumber=0,hitNumber=0, restNumber=0, currentGrades=1;
  GuessTimer gt = new GuessTimer();
  
  public HitMouse()
  {  
      super("除蟲遊戲");  
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(1200, 675);  
      this.setLocationRelativeTo(null);//設置窗口在畫面中心  
      setbackground();//設置背景  
      this.getContentPane().setLayout(null);//設置框架佈局模式為空（只有這樣，才能知道圖片的真正位置  
      //設置滑鼠游標為錘子圖片
      tk = Toolkit.getDefaultToolkit();
      //image = tk.createImage(dir + "killbug(X).png"); 
      image = tk.createImage(dir + "chui1.png"); 
      myCursor = tk.createCustomCursor(image, new Point(30,30), "xxx");  
      this.setCursor(myCursor);  
      
      setMessage();//設置一些提示訊息
      //在背景圖片的基礎上設置地鼠圖片    
      ImageIcon imageMouse = resizeImage(130, 130, new ImageIcon(dir+"diebug.png"));
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
      //------------------------------------------------------------
      JLabel lblSec = new JLabel("SEC");
  	  JLabel word = new JLabel(": 00");
  	  JLabel lblSecback = new JLabel("secback");
  	  //JLabel successlbl = new JLabel();
  	  //JLabel faultlbl = new JLabel();
  	  
  	  gt.setJLabel(lblSec);
  	  
  	  //傾聽計時器timeout事件(可選的事件，不實作也可以使用timer
	  gt.addListener(new GuessTimer.Listener() {
		  @Override
		  public void timeOut() {
		      //處理TimeOut事件
			  timer.stop();
			  isOver = true;
			  timeMessageAppear();
		  }
		  @Override
		  public void onChange(long sec) {
			 System.out.println("sec=>" + sec);
		  }
	   });
	  gt.startTimer(30);
	  
	  lblSec.setForeground(Color.RED);
	  lblSec.setBounds(963, 15, 58, 65);
	  this.add(lblSec);
	  lblSec.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	  lblSec.setVisible(true);
	  
	  word.setForeground(Color.RED);
	  word.setBounds(1005, 15, 69, 65);
      this.add(word);
	  word.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
      word.setVisible(true);
      
      lblSecback.setBounds(947, 15, 131, 58);
      ImageIcon secback = resizeImage(lblSecback.getWidth(), lblSecback.getHeight(), new ImageIcon(dir+"secBack.png"));
      lblSecback.setIcon(secback);	
	  add(lblSecback);
	  lblSecback.setVisible(true);
	  /*
	  successlbl.setBounds(274, 159, 600, 400);
	  ImageIcon success = resizeImage(successlbl.getWidth(), successlbl.getHeight(), new ImageIcon(dir+"success.png"));
	  
	  faultlbl.setBounds(274, 159, 600, 400);
	  ImageIcon fault = resizeImage(faultlbl.getWidth(), faultlbl.getHeight(), new ImageIcon("../picture/fault.PNG"));
      
	  successlbl.setIcon(success);	
	  add(successlbl);
	  successlbl.setVisible(false);
		
	  faultlbl.setIcon(fault);	
	  add(faultlbl);
	  faultlbl.setVisible(false);
	  */
	  
	  // Math.random 會產生 0 ~ 接近 1 的數字 
      restNumber = (int)(Math.random() * 6);  // 0 ~ 5
      restNumber += 25;  // 25 ~ 30
      System.out.print(restNumber + "  ");  
      
  }  
  
  private void timeMessageAppear()
  {
	  JOptionPane.showMessageDialog(this, "Times Up!");
  }
  
  private void addMenu() 
  {  
      JMenuBar menubar = new JMenuBar();  
      this.setJMenuBar(menubar);  
      JMenu game = new JMenu("除蟲遊戲");
      
      JMenuItem jitemNew = new JMenuItem("新遊戲");  
      jitemNew.setActionCommand("new");  
      jitemNew.addActionListener(this);  
      JMenuItem jitemPause = new JMenuItem("暫停");  
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
      //ImageIcon bgImage = new ImageIcon(dir+"killBugBackground.png");  
      ImageIcon bgImage = resizeImage(1200, 675, new ImageIcon(dir+"killBugBackground.png"));
      JLabel bgLabel = new JLabel(bgImage);  
      bgLabel.setBounds(0, 25, bgImage.getIconWidth(), bgImage.getIconHeight());  
      this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));//設置背景圖片的層次最低  
  }  
     
  private void setMessage() 
  {  
	  JLabel showNumText = new JLabel("出現數量:");
	  showNumText.setBounds(130, 25, 181, 43);
	  this.add(showNumText);
	  showNumText.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	  showNumText.setVisible(true);
	  showNum = new JLabel("0");  
      showNum.setBounds(270, -10, 250, 115);  
      this.getContentPane().add(showNum);
      showNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
      
      JLabel hitNumText = new JLabel("擊中數量:");
      hitNumText.setBounds(320, 25, 181, 43);
	  this.add(hitNumText);
	  hitNumText.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	  hitNumText.setVisible(true);
	  hitNum = new JLabel("0");
      hitNum.setBounds(460, -10, 250, 115);
      this.getContentPane().add(hitNum); 
      hitNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	  
	  JLabel restNumberText = new JLabel("還差數量:");
	  restNumberText.setBounds(500, 25, 181, 43);
	  this.add(restNumberText);
	  restNumberText.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	  restNumberText.setVisible(true);
	  restNum = new JLabel("?");
	  restNum.setBounds(640, -10, 250, 115);
      this.getContentPane().add(restNum); 
      restNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
      
      JLabel currentGradeText = new JLabel("當前等級:");
      currentGradeText.setBounds(700, 25, 181, 43);
	  this.add(currentGradeText);
	  currentGradeText.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	  currentGradeText.setVisible(true);
      currentGrade = new JLabel("1");
      currentGrade.setBounds(850, -10, 250, 115);
      this.getContentPane().add(currentGrade); 
      currentGrade.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
      
      ImageIcon hitNumbBoard = resizeImage(800, 70, new ImageIcon(dir+"billBoard.png"));
      JLabel hitLabel = new JLabel(hitNumbBoard, JLabel.CENTER);  
      hitLabel.setBounds(30, 3, 950, 70);  
      this.getContentPane().add(hitLabel);
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
      //保證每次隨機生成的地鼠圖片都是為沒被打時的圖片  
      ImageIcon imageMouse = resizeImage(130, 175, new ImageIcon(dir+"bug.png"));
      jlbMouse.setIcon(imageMouse);  
      switch(ran){  
      case 0:jlbMouse.setLocation(220, 80);break;  
      case 1:jlbMouse.setLocation(580, 80);break;  
      case 2:jlbMouse.setLocation(920, 80);break;  
      case 3:jlbMouse.setLocation(220, 275);break;  
      case 4:jlbMouse.setLocation(580, 273);break;  
      case 5:jlbMouse.setLocation(950, 277);break;  
      case 6:jlbMouse.setLocation(220, 468);break;  
      case 7:jlbMouse.setLocation(585, 469);break;  
      case 8:jlbMouse.setLocation(980, 468);break;  
      }  
         
      jlbMouse.setVisible(true);  
         
      showNumber++;  
      showNum.setText(""+showNumber);  
         
      if( !gamePlan() ){//判斷遊戲是否結束，並判斷遊戲進程
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
    	  gt.stopoTimer();
          JOptionPane.showMessageDialog(this, "Game Over !");  
          isOver=true;  
          return false;  
      }  
      if(hitNumber > 2){  
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
          ImageIcon imageIconHit = resizeImage(130, 130, new ImageIcon(dir+"diebug.png"));
          jlbMouse.setIcon(imageIconHit);  
          jlbMouse.setVisible(true);  
      }  
         
      hitNumber++;  
      hitNum.setText(""+hitNumber); 
      
      if(restNumber > 0)
      {
    	  restNumber--;
          restNum.setText(""+restNumber);
      }
      
      else {
    	  JOptionPane.showMessageDialog(this, "你成功了!!獲得金幣囉~~");
      }
      
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
  
  public ImageIcon resizeImage(int width, int height, ImageIcon img)
  {
	  Image i = img.getImage();
	  Image new_img = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	  return  new ImageIcon(new_img);
  }
 
}
