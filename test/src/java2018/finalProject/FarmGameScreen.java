package java2018.finalProject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;  
import java.awt.Point;  
import java.awt.Toolkit;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JMenu;  
import javax.swing.JMenuBar;  
import javax.swing.JMenuItem;  
import javax.swing.JOptionPane;  
import javax.swing.JPanel;  
import javax.swing.Timer;  
 
 
public class FarmGameScreen extends JPanel implements ActionListener,MouseListener
{  
	private Main mainFrame;
	private WareHouse warehouse;
	private int a = -1;
	private int b = -1;
	private int isHitGrass = -1;
    private int isHitBug = -1;
    private int ranBug;//隨機生成一個0~9(不包括9)的隨機數
    private int ranGrass;
	private int delay = 1000; //延遲時間  
    private int showNumber=0,hitNumber=0, restBugNumber=0, restGrassNumber=0, currentGrades=1;
    private static final long serialVersionUID = 1L;
    private String dir = "../picture/"; //圖片目錄  
    boolean isOver = false;  //設置標記，遊戲是否結束
    private Timer timer;    //時間定時器
    private GuessTimer gt = new GuessTimer();
    private Random random;  //隨機生成蟲蟲位置  
    private JLabel[] jlbBug;//蟲蟲
    private JLabel[] jlbGrass;//草草
    private JLabel showNum,currentGrade,hitNum;
    private JLabel successLabel = new JLabel();
    private JLabel failLabel = new JLabel();
    private JLabel restBugNumberText;
    private JLabel restGrassNumberText;
    private JLabel toolTipText;
    private JLabel needToHit = new JLabel("需擊中數量:");
    private JButton backToFarmBtn = new JButton();
    private JButton backToHomeBtn = new JButton();
    private ImageIcon bugIcon = resizeImage (73,73,new ImageIcon(dir+"bug.png"));
    private ImageIcon grassIcon = resizeImage (65,65,new ImageIcon(dir+"grass1.png"));
    private JLabel bugLabelOnBoard = new JLabel(bugIcon, JLabel.LEFT);
	private JLabel grassLabelOnBoard = new JLabel(grassIcon, JLabel.LEFT);
	
    public FarmGameScreen(Main mainFrame, WareHouse warehouse)
    {  
    	this.random = new Random();  
    	this.ranBug=random.nextInt(9);
    	do
    	{
    		this.ranGrass=random.nextInt(9);
    	}while(ranBug == ranGrass);
    		
    	this.mainFrame = mainFrame;
    	this.warehouse = warehouse;
        this.setSize(1200, 675);    
        this.setLayout(null);//設置框架佈局模式為空（只有這樣，才能知道圖片的真正位置  
      
        // Math.random 會產生 0 ~ 接近 1 的數字 
        restBugNumber = (int)(20+Math.random() * 6);  // 25 ~ 30
        restGrassNumber = (int)(20+Math.random() * 6);
        
        
        //-------------------------滑鼠游標透明---------------------
      
        // Transparent 16 x 16 pixel cursor image.
        //BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

	    // Create a new blank cursor.
	    //Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    //cursorImg, new Point(0, 0), "blank cursor");

	    // Set the blank cursor to the JFrame.
	    //this.setCursor(blankCursor);
	
	    //-----------------------圖片跟著透明游標走--------------------
	  
        toolTipText = new JLabel();
        toolTipText.setLocation(0, 0);
        toolTipText.setIcon(new ImageIcon("..\\picture\\killBug(X).png"));
        toolTipText.setSize(323, 491);
        this.addMouseListener(this);
        add(toolTipText);
        this.addMouseMotionListener(new MouseMotionAdapter() {
		    @Override
			public void mouseMoved(MouseEvent e) {
				//toolTipText.setLocation((int)e.getPoint().getX()-30, (int)e.getPoint().getY()-250);
		    	toolTipText.setLocation((int)e.getPoint().getX()-30, (int)e.getPoint().getY()-190);
			}
			
		});
       //--------------------------------------------------------------------
      
        setMessageOnBoard();//設置一些提示訊息
        
        //在背景圖片的基礎上設置蟲蟲圖片 
        jlbBug = new JLabel[9];
        ImageIcon imageBug = resizeImage(130, 130, new ImageIcon(dir+"diebug.png"));
        for(int i=0; i<9; i++)
        {
            jlbBug[i] = new JLabel(imageBug);
            jlbBug[i].setSize(100,100); 
            switch(i)
            {
                case 0: jlbBug[0].setLocation(220,  80); break; 
                case 1: jlbBug[1].setLocation(580,  80); break; 
                case 2: jlbBug[2].setLocation(920,  80); break; 
                case 3: jlbBug[3].setLocation(220, 275); break; 
                case 4: jlbBug[4].setLocation(580, 273); break; 
                case 5: jlbBug[5].setLocation(950, 277); break; 
                case 6: jlbBug[6].setLocation(220, 468); break; 
                case 7: jlbBug[7].setLocation(585, 469); break; 
                case 8: jlbBug[8].setLocation(980, 468); break; 
            }
            this.add(jlbBug[i]);  
            jlbBug[i].setVisible(false);  
            jlbBug[i].addMouseListener(this);//添加滑鼠游標監聽  
        }
        
        jlbGrass = new JLabel[9];
        ImageIcon imageGrass = resizeImage(130, 130, new ImageIcon(dir+"grass1.png"));
        for(int i=0; i<9; i++)
        {
        	jlbGrass[i] = new JLabel(imageGrass);
        	jlbGrass[i].setSize(100,100); 
            switch(i)
            {
                case 0: jlbGrass[0].setLocation(220,  80); break; 
                case 1: jlbGrass[1].setLocation(580,  80); break; 
                case 2: jlbGrass[2].setLocation(920,  80); break; 
                case 3: jlbGrass[3].setLocation(220, 275); break; 
                case 4: jlbGrass[4].setLocation(580, 273); break; 
                case 5: jlbGrass[5].setLocation(950, 277); break; 
                case 6: jlbGrass[6].setLocation(220, 468); break; 
                case 7: jlbGrass[7].setLocation(585, 469); break; 
                case 8: jlbGrass[8].setLocation(980, 468); break; 
            }
            this.add(jlbGrass[i]);  
            jlbGrass[i].setVisible(false);  
            jlbGrass[i].addMouseListener(this);//添加滑鼠游標監聽  
        }

        //定時器 
        timer = new Timer(delay,this);  
        
        timer.start();  
         
        addMenu();//添加下拉選單 
         
        this.setVisible(true);  
      
        //--------------------------------------倒數計時器--------------------------------------

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
			   //System.out.println("sec=>" + sec);
		    }
	    });
	    gt.startTimer(30);
	  
	    JLabel word = new JLabel("00 : ");
        JLabel lblSec = new JLabel(Integer.toString(gt.getSec()));
  	    JLabel lblSecback = new JLabel("secback");
  	    gt.setJLabel(lblSec);
	    word.setForeground(Color.RED);
	    word.setBounds(965, 12, 70, 65);
        this.add(word);
	    word.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
        word.setVisible(true);
      
	    lblSec.setForeground(Color.RED);
	    lblSec.setBounds(1020, 12, 69, 65);
	    this.add(lblSec);
	    lblSec.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	    lblSec.setVisible(true);
      
        lblSecback.setBounds(947, 15, 131, 58);
        ImageIcon secback = resizeImage(lblSecback.getWidth(), lblSecback.getHeight(), new ImageIcon(dir+"secBack.png"));
        lblSecback.setIcon(secback);	
	    this.add(lblSecback);
	    lblSecback.setVisible(true);

  		//------------------------------------遊戲結束回農場button-----------------------------------
 	    backToFarmBtn.setBounds(510, 369, 137, 55);
   		ImageIcon backToFarm = resizeImage(130, 50, new ImageIcon("../picture/backToFarm.PNG"));
   		backToFarmBtn.setIcon(backToFarm);	
   		this.add(backToFarmBtn);
   		backToFarmBtn.setVisible(false);
   		backToFarmBtn.setOpaque(false);
   		backToFarmBtn.setContentAreaFilled(false);
   		backToFarmBtn.setFocusPainted(false);
   		backToFarmBtn.setBorder(null);
   		
   		backToFarmBtn.addMouseListener(new MouseAdapter() {
   			@Override
   			public void mouseClicked(MouseEvent e) {
   				mainFrame.changeToFarmScreen();
   			}
               public void mouseEntered(MouseEvent arg0) {
             	  backToFarmBtn.setIcon(resizeImage(backToFarmBtn.getIcon().getIconWidth()+10,backToFarmBtn.getIcon().getIconHeight()+10,(ImageIcon)backToFarmBtn.getIcon()));
   				buttonSound();
   			}
               @Override
               public void mouseExited(MouseEvent arg0) {
             	  backToFarmBtn.setIcon(resizeImage (118, 37,new ImageIcon("../picture/backToFarm.png")));
               } 
   		});
   		
   	    //-------------------------------------完成任務與任務失敗----------------------------------
        successLabel.setBounds(274, 159, 600, 400);
	    ImageIcon success = resizeImage(successLabel.getWidth(), successLabel.getHeight(), new ImageIcon(dir+"success.png"));
	    successLabel.setIcon(success);	
	    this.add(successLabel);
	    successLabel.setVisible(false);
	  
      
	    failLabel.setBounds(274, 159, 600, 400);
	    ImageIcon fault = resizeImage(failLabel.getWidth(), failLabel.getHeight(), new ImageIcon(dir+"fault.png"));
	    failLabel.setIcon(fault);	
	    this.add(failLabel);
	    failLabel.setVisible(false);
	    
	    //------------------------------------------回到主畫面---------------------------------------------
	    
	    backToHomeBtn.setFont(new Font("Dialog", Font.BOLD, 20));	
		buttonOFF(backToHomeBtn);
		backToHomeBtn.setIcon(new ImageIcon("..\\picture\\HOME.png"));
		backToHomeBtn.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		backToHomeBtn.setBounds(1050, 0, 176, 114);
		backToHomeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.changeToMainScreen();
			}
			@Override
	        public void mouseEntered(MouseEvent arg0) {
				backToHomeBtn.setIcon(resizeImage(backToHomeBtn.getIcon().getIconWidth()+10,backToHomeBtn.getIcon().getIconHeight()+10,(ImageIcon)backToHomeBtn.getIcon()));
				buttonSound();
			} 
	        @Override
	        public void mouseExited(MouseEvent arg0) {
	        	backToHomeBtn.setIcon(new ImageIcon("..\\picture\\HOME.png"));
	        } 
			
		});
		this.add(backToHomeBtn);
		
		
	    //-------------------------------------------------------------------------
	    setbackground();//設置背景 
    }  

    //----------------------------------去除按鈕背景-----------------------------
    
	public void buttonOFF(JButton btn) 
	{
    	btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setBorder(null);
    }
	//----------------------------------------------------------------------------

	private void timeMessageAppear()
    {
	    //JOptionPane.showMessageDialog(this, "Times Up!");
	    if(restBugNumber == 0 && restGrassNumber == 0)
	    {
	    	for(int i=0; i<9; i++)
	    		jlbBug[i].setVisible(false);
	    	
	    	for(int i=0; i<9; i++)
	    		jlbGrass[i].setVisible(false);	    	
	    	//JOptionPane.showMessageDialog(this, "Times Up! 完成任務owo");

		    successLabel.setVisible(true);
		    backToFarmBtn.setVisible(true);
	    }
	    else
	    {
	    	for(int i=0; i<9; i++)
	    		jlbBug[i].setVisible(false);
	    	
	    	for(int i=0; i<9; i++)
	    		jlbGrass[i].setVisible(false);
		    //JOptionPane.showMessageDialog(this, "Times Up! 任務失敗ouq");

		    failLabel.setVisible(true);
		    backToFarmBtn.setVisible(true);
	    }
    }
  
    private void addMenu() 
    {  
        JMenuBar menubar = new JMenuBar();  
        this.add(menubar);  
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

        game.add(jitemNew);  
        game.add(jitemPause);  
        game.addSeparator();//下拉選單裡設置分隔線
        game.add(jitemExit);  
        game.addSeparator();//下拉選單裡設置分隔線
  
        menubar.add(game);  
    }  
     
    private void setbackground() 
    {  
        this.setOpaque(false);//如果為 true，則該組件繪製其邊界內的所有像素。否則該組件可能不繪製部分或所有像素，從而允許其底層像素透視出来。   
    
        ImageIcon bgImage = resizeImage(1200, 675, new ImageIcon(dir+"killBugBackground.png"));
        JLabel bgLabel = new JLabel(bgImage);  
        bgLabel.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight()); 
        this.add(bgLabel, new Integer(Integer.MIN_VALUE));//設置背景圖片的層次最低  
    }  
     
    private void setMessageOnBoard() 
    {  
	    JLabel showNumText = new JLabel("出現數量:");
	    showNumText.setBounds(130, 25, 181, 43);
	    this.add(showNumText);
	    showNumText.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	    showNumText.setVisible(false);
	    showNum = new JLabel("0");  
        showNum.setBounds(270, -10, 250, 115); 
        showNum.setVisible(false);
        add(showNum);
        showNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
        
        JLabel hitNumText = new JLabel("擊中數量:");
        hitNumText.setBounds(320, 25, 181, 43);
	    this.add(hitNumText);
	    hitNumText.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	    hitNumText.setVisible(false);
	    hitNum = new JLabel("0");
        hitNum.setBounds(460, -10, 250, 115);
        hitNum.setVisible(false);
        this.add(hitNum); 
        hitNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	    
        needToHit.setBounds(250, 25, 200, 43);
		this.add(needToHit);
		needToHit.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		needToHit.setVisible(true);
		
		/*
		restBugNumberText = new JLabel("剩餘蟲數量:"+Integer.toString(restBugNumber));
		restBugNumberText.setBounds(700, 25, 200, 43);
		this.add(restBugNumberText);
		restBugNumberText.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		restBugNumberText.setText(" X "+(int)restBugNumber);
		restBugNumberText.setVisible(true);
		*/
		bugLabelOnBoard.setBounds(440, 25, 200, 38);
		this.add(bugLabelOnBoard);
	    restBugNumberText = new JLabel(" X "+Integer.toString(restBugNumber));
	    restBugNumberText.setBounds(500, 25, 200, 43);
	    add(restBugNumberText);
	    restBugNumberText.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	    restBugNumberText.setVisible(true);
	    /*
	    restNum = new JLabel();
	    restNum.setBounds(640, -10, 250, 115);
	    System.out.println(Integer.toString(restBugNumber));
	    //restNum.setText();
	    restNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
        add(restNum); 
        */
	    grassLabelOnBoard.setBounds(650, 20, 200, 43);
		this.add(grassLabelOnBoard);
	    restGrassNumberText = new JLabel(" X "+Integer.toString(restGrassNumber));
	    restGrassNumberText.setBounds(700, 25, 200, 43);
	    add(restGrassNumberText);
	    restGrassNumberText.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
	    restGrassNumberText.setVisible(true);
	    
      
        JLabel currentGradeText = new JLabel("當前等級:");
        currentGradeText.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
        currentGradeText.setBounds(700, 25, 181, 43);
        currentGradeText.setVisible(false);
	    add(currentGradeText);
        currentGrade = new JLabel("1");
        currentGrade.setBounds(850, -10, 250, 115);
        currentGrade.setVisible(false);
        currentGrade.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
        add(currentGrade); 
      
      
        ImageIcon hitNumbBoard = resizeImage(800, 70, new ImageIcon(dir+"billBoard.png"));
        JLabel hitLabel = new JLabel(hitNumbBoard, JLabel.CENTER);  
        hitLabel.setBounds(30, 3, 950, 70);  
        this.add(hitLabel);
    }  
     
    public void actionPerformed(ActionEvent e) 
    {   
        //對下拉選單註冊事件監聽  
        if(e.getSource() instanceof JMenuItem)
        {  
            menuItemFun(e);  
        }  
        
        //a=-1, b=-1
        //System.out.printf("out : a=%d, b=%d%n", a, b);
        //System.out.printf("action : ranBug=%d, ranGrass=%d%n", ranBug, ranGrass);
        while(ranBug == a || ranGrass == b) //不要重複在同一個洞出現
        {
        	//System.out.printf("in : a=%d, b=%d%n", a, b);
        	if(ranBug == a)
        	{
        		do {
        			ranBug = random.nextInt(9);
            		//System.out.printf("if(ranBug == a) : ranBug=%d, ranGrass=%d%n", ranBug, ranGrass);
        		}while(ranBug == ranGrass);
        	}
        	if(ranGrass == b)
        	{		
        		do {
        			ranGrass = random.nextInt(9);
        			//System.out.printf("if(ranGrass == b) : ranBug=%d, ranGrass=%d%n", ranBug, ranGrass);
        		}while(ranBug == ranGrass);
        	}
        }
        
        
        // 保證每次隨機生成的蟲蟲圖片都是為沒被打時的圖片 
        ImageIcon imageBug = resizeImage(130, 175, new ImageIcon(dir+"bug.png"));
        jlbBug[ranBug].setIcon(imageBug);  
        jlbBug[ranBug].setVisible(true);
       
        ImageIcon imageGrass = resizeImage(130, 130, new ImageIcon(dir+"grass1.png"));
        jlbGrass[ranGrass].setIcon(imageGrass);  
        jlbGrass[ranGrass].setVisible(true);
        
        
       
        showNumber++;  
        //showNum.setText(""+showNumber);  
         
        if( !gamePlan() ){//判斷遊戲是否結束，並判斷遊戲進程
    	    timer.stop();  
            //JOptionPane.showMessageDialog(this, "Game Over ! 打不到8隻蟲蟲 再掛機阿=w=");
            for(int i=0; i<9; i++)
                jlbBug[i].setVisible(false);

            for(int i=0; i<9; i++)
                jlbGrass[i].setVisible(false);
            
            
            failLabel.setVisible(true);  
            backToFarmBtn.setVisible(true);
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
            //showNum.setText(""+showNumber);  
            //hitNum.setText(""+hitNumber);  
            currentGrade.setText(""+currentGrades);  
            timer = new Timer(delay,this);  
            timer.start();  
        }  
        
        if (e.getActionCommand().equalsIgnoreCase("exit")) {//退出  
            isOver=true;
        }  
         
        if (e.getActionCommand().equalsIgnoreCase("pause")) {//暂停  
            timer.stop();  
            //JOptionPane.showMessageDialog(this, "繼續請按“確定”");  
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
	    /*
        if(showNumber-hitNumber > 8){  
    	    gt.stopoTimer();  
            isOver=true;  
            return false;  
        } 
      	*/
        if(hitNumber > 1){  
            hitNumber=0;  
            showNumber=0;  
            currentGrades++;  
            if(delay>100){  
                delay-=50;  
            }else if(delay>=500){  
                delay=500;  
            }  
            timer.setDelay(delay); 
            //hitNum.setText(""+hitNumber);  
            //showNum.setText(""+showNumber);  
            currentGrade.setText(""+currentGrades);  
        } 
        
        return true;  
    }  
    
    public void mouseReleased(MouseEvent e) 
    {  
    	//當滑鼠游標放開之後，滑鼠游標變回原来沒按下時的圖片
        if(isOver){  
            return ;  
        }  
        int i = e.getButton();
        if(i == MouseEvent.BUTTON1){
        	//System.out.println("mousedReleased : 釋放滑鼠左鍵");
        	toolTipText.setIcon(new ImageIcon(dir+"harvest1.png"));
        	
        	if(isHitGrass != -1)
        	{
        		//System.out.printf("released-isHit : ranGrass=%d, isHitGrass=%d%n", ranGrass, isHitGrass);
        		
        		if(e.getSource()==jlbGrass[isHitGrass])
        		{
        			jlbGrass[isHitGrass].setVisible(false);
        		}
        	}
        }
        else if(i == MouseEvent.BUTTON2) {
        	//System.out.println("mousedReleased : 釋放滑鼠滾輪");
        }
        else if(i == MouseEvent.BUTTON3) {
        	//System.out.println("mousedReleased : 釋放滑鼠右鍵");
        	toolTipText.setIcon(new ImageIcon(dir+"killBug(X).png"));
        	
        	if(isHitBug != -1)
        	{
        		if(e.getSource()==jlbBug[isHitBug])
        		{
        			jlbBug[isHitBug].setVisible(false);
        		}
        	}
        }
    }  
    
    @Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) { //鼠標按下但還沒有釋放
		
		int i = e.getButton();
        if(i == MouseEvent.BUTTON1) 
        {
        	//System.out.println("mousePressed : 按下滑鼠左鍵");
        	toolTipText.setIcon(resizeImage(200,200,new ImageIcon(dir+"harvest1.png")));
        	
            //System.out.println("mouseClicked : 單擊滑鼠左鍵");
            toolTipText.setIcon(resizeImage(200,200,new ImageIcon(dir+"harvest2.png")));
                
            if(isOver){  
                return ;  
            }  
            if(e.getSource()==jlbGrass[ranGrass])
            {  
                if(b != ranGrass)
                {
                	//System.out.printf("b : ranBug=%d, ranGrass=%d%n", ranBug, ranGrass);
                	ImageIcon imageIconHit = resizeImage(130, 130, new ImageIcon(dir+"grass2.png"));
                    jlbGrass[ranGrass].setIcon(imageIconHit); 
                    jlbGrass[ranGrass].setVisible(true); 
  
                    hitNumber++;  
                    hitNum.setText(Integer.toString(hitNumber)); 
                    
                    win();
                    if(restGrassNumber >= 0)
                    {
                    	isHitGrass = ranGrass;
                    	//System.out.printf("isHit : ranGrass=%d%n", ranGrass);
                    	
                    	//jlbGrass[ranGrass].setVisible(false); // 暫時false!!!!!!!!!!!!!!!!!
                    	if(restGrassNumber!=0) restGrassNumber-= 1;
                    	restGrassNumberText.setText(" X "+Integer.toString(restGrassNumber));
                    	
                    	String name1 = "bubble";
    					Sound(name1);
    					
                    	if(restGrassNumber == 0)
                        {
                    		String name2 = "wrong";
        					Sound(name2);
                    		/*
                        	for(int j=0; j<9; j++)
                        	{
                        		jlbGrass[j].setVisible(false);
                        	}
                        	
                        	timer.stop();
                            gt.stopoTimer();
                            //isOver=true; 
                            //JOptionPane.showMessageDialog(this, "finish ! 完成任務拿錢錢囉ouo");
                            successLabel.setVisible(true);
                            backToFarmBtn.setVisible(true);
                            */
                            
                        }
                        
                     } 
                     b = ranGrass;
                     
                } 
            } 
            else // 用右鍵打蟲
            {
            	 String name3 = "wrong";
				Sound(name3);
            }
        }   
        else if(i == MouseEvent.BUTTON2) {
        	//System.out.println("mousePressed : 按下滑鼠滾輪");
        }	
        else if(i == MouseEvent.BUTTON3) 
        {
        	//System.out.println("mousePressed : 按下滑鼠右鍵");
        	toolTipText.setIcon(new ImageIcon(dir+"killBug(O).png"));

            if(isOver){  
                return ;  
            }  
            if(e.getSource()==jlbBug[ranBug])
            {   
                if(a != ranBug)
                {
                	//System.out.printf("a : ranBug=%d, ranGrass=%d%n", ranBug, ranGrass);
                	ImageIcon imageIconHit = resizeImage(130, 130, new ImageIcon(dir+"diebug.png"));
                    jlbBug[ranBug].setIcon(imageIconHit); 
                    jlbBug[ranBug].setVisible(true); 
 
                    hitNumber++;  
                    hitNum.setText(Integer.toString(hitNumber)); 

                    win();
                    if(restBugNumber >= 0)
                    {
                    	isHitBug = ranBug;
                    	
                    	//jlbBug[ranBug].setVisible(false); // 暫時false!!!!!!!!!!!!!!!!!
                        if(restBugNumber!=0) restBugNumber-= 1;
                        restBugNumberText.setText(" X "+Integer.toString(restBugNumber));
                        String name1 = "bubble";
    					Sound(name1);
                        
                        if(restBugNumber == 0)
                        {     
                        	String name2 = "wrong";
        					Sound(name2);
                        	/*
                        	for(int j=0; j<9; j++)
                        	{
                        		jlbBug[j].setVisible(false);
                        	}
                            timer.stop();
                            gt.stopoTimer();
                            //isOver=true; 
                            //JOptionPane.showMessageDialog(this, "finish ! 完成任務拿錢錢囉ouo");

                            successLabel.setVisible(true);
                            backToFarmBtn.setVisible(true);
                            // 任務成功但還是可以打蟲蟲
                            */
                        }
                        
                    } 
                     a=ranBug;
                }
            }
            else // 用左鍵打草
            {
            	 String name3 = "wrong";
				Sound(name3);
            }
        }
	}
	public void win()
	{
		if(restGrassNumber == 0 && restBugNumber == 0)
		{
			for(int j=0; j<9; j++)
        	{
        		jlbGrass[j].setVisible(false);
        	}
			for(int j=0; j<9; j++)
        	{
        		jlbBug[j].setVisible(false);
        	}
        	timer.stop();
            gt.stopoTimer();
            //isOver=true; 
            //JOptionPane.showMessageDialog(this, "finish ! 完成任務拿錢錢囉ouo");
            successLabel.setVisible(true);
            backToFarmBtn.setVisible(true);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) { // 鼠標按下並且釋放
		
	}
	
    public ImageIcon resizeImage(int width, int height, ImageIcon img)
    {
	    Image i = img.getImage();
	    Image new_img = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    return  new ImageIcon(new_img);
    }
    
    public void buttonSound()
	{
	    try {           
            File soundFile = new File("..\\sound\\button.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
    
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
	}
    
    public void Sound(String name)
	{
    	 try {           
	            File soundFile = new File("..\\sound\\"+name+"Sound.wav");
	            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioIn);
	            clip.start();
	    
	        } catch (UnsupportedAudioFileException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (LineUnavailableException e) {
	            e.printStackTrace();
	        }
	}
}