package clock01;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SClock extends JFrame {

	//shutdown 
	private int time=0; //shutdown �ð�
	String word=null; //shutdown �۾�
	private JTextField shutdowntime = new JTextField("�ð�(��)�Է� ex)300-> 5���� ����");//�˴ٿ� ��ɾ ����� �ð��� �޴� �ؽ�Ʈ�ʵ�
	private JTextField shutdownstring = new JTextField("�ƹ� ���ڳ� �Է�(�Է����� �ʾƵ� ��)");//�˴ٿ� ��ɾ ����� ���ڸ� �޴� �ؽ�Ʈ �ʵ�
	private JButton shutdownSet = new JButton("Set");//�Է��� ������ �˴ٿ��� �����ϴ� ��ư
	private JButton shutdownunSet = new JButton("UnSet");//�Է��� ������ �˴ٿ��� �����ϴ� ��ư
	private JButton shutdown = new JButton();//�˴ٿ�� ���õȰ��� ���̰��ϰ� �������� ������ �ʰ� ���ִ� ��ư
	//Alarm
	private int Alarm1,Alarm2,Alarm3; //�˶��� �ʿ��� �������� ���������� ����
	private int count=0; //�˶����� ����ϸ� �˶������ while���� ���ԵǾ��־� �˶��� �Ҹ��� ������������� �ʵ��� �ϱ����ؼ� ����
	private JTextField a1 = new JTextField("����=0 ����=1");//�˶��� �ʿ��� ������ �Է¹޾� �ٸ� ������ ����
	private JTextField a2 = new JTextField("�ð��� �Է��Ͻÿ�");//�˶��� �ʿ��� ������ �Է¹޾� �ٸ� ������ ����
	private JTextField a3 = new JTextField("���� �Է��Ͻÿ�");//�˶��� �ʿ��� ������ �Է¹޾� �ٸ� ������ ����
	private JButton Alarm = new JButton(); //�˶��� ���õȰ��� ���̰��ϰ� �������� ������ �ʰ� ���ִ� ��ư
	private JButton Set = new JButton("Set");//�Էµ� ������ �˶��� �����ϴ� ��ư
	//Clock
	private JLabel Lstopwatch = new JLabel();//1�ʸ��� 1�������� �����ġ�� ���ڸ� ǥ�����ش�.
	private JLabel first = new JLabel(); //��,��,���� ǥ�����ش�.
	private JLabel second = new JLabel(); //����/����, ��,��,�ʸ� ǥ�����ش�.
	private JLabel Alarmlabel=new JLabel();//
	private String one;//��,��,���� ���ڿ��� ����� 
	private String two;//����/����, ��, ��, �ʸ� ���ڿ��� �����.
	private int mouseX, mouseY; //x�� y�� ��ġ�� ����
	private JButton exitbutton = new JButton(new ImageIcon(Main.class.getResource("../images/exitButtonU.png")));//��ܸ޴��� �������ư
	//��ž��ġ
	private int i=0; //�����ġ���� ����ϸ� 0�϶��� �����ġ�� �������� �ʰ� 1�϶� �����Ѵ�.
	int stop=0; //�����ġ�� ����� ����  msec(1�ڸ�)
	int ssec=0;//�����ġ�� ����� ����  ��
	int smin=0;//�����ġ�� ����� ����  ��
	int shour=0;//�����ġ�� ����� ���� �ð�
	private JButton stopstart = new JButton();//�����ġ ���۹�ư
	private JButton swstop = new JButton();//�����ġ ������ư
	private JButton stopwatch = new JButton();//��ž��ġ�� ���õȰ͵��� ���̰Ը���� �������� ������ �ʰ� �����.
	private JButton stopreset = new JButton("reset");//��ž��ġ ����
	private JTextArea list=new JTextArea(1,2);
	private String listnum;//�����ġ�� ���ڿ��� ǥ���� �� �ְ� ���ش�.
	private JScrollPane scroll=new JScrollPane(list);//////////////////////////////////////////
	//Ÿ�̸�
	int k=0;//k�� 1�϶� Ÿ�̸� ����
	int tmsec;//Ÿ�̸ӿ��� ����� msec����
	int tsec;//Ÿ�̸ӿ��� ����� sec����
	int tmin;//Ÿ�̸ӿ��� ����� min����
	int thour;//Ÿ�̸ӿ��� ����� hour����
	private JButton timer = new JButton("Timer");//�����ġ �޴����۹�ư
	private JButton setTimer = new JButton("Set");//�����ġ ���۹�ư
	private JButton Timerreset = new JButton("Reset");//�����ġ ���۹�ư
	private JTextField timerh= new JTextField("�ð��� �Է��Ͻÿ�");//Ÿ�̸ӿ� �ʿ��� ������ �Է¹޾� �ٸ� ������ ����
	private JTextField timerm = new JTextField("���� �Է��Ͻÿ�");//Ÿ�̸ӿ� �ʿ��� ������ �Է¹޾� �ٸ� ������ ����
	private JTextField timers = new JTextField("�ʸ� �Է��Ͻÿ�");//Ÿ�̸ӿ� �ʿ��� ������ �Է¹޾� �ٸ� ������ ����
	private JLabel dTimer = new JLabel(); //��,��,���� ǥ�����ش�.
	//�� ��
	private JButton homebutton = new JButton();//ó�� ȭ������ ���ư���.(ó�����̴��͸� ���̰�)
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu.png")));//��ܸ޴�
	private ImageIcon exitprImage = new ImageIcon(Main.class.getResource("../images/exitButtonP.png"));//�������ư ������ �� �̹���
	private ImageIcon exitunImage = new ImageIcon(Main.class.getResource("../images/exitButtonU.png"));//�������ư ������ �ʾ����� �̹���
	
	private Image screenImage; // 
	private Graphics screenGraphic;//
	private Image background = new ImageIcon(Main.class.getResource("../images/background.png")).getImage();//����̹���

	public SClock() //������
{
		// TODO �ڵ� ������ ������ ����
		set(); //JFrame�� ����ϱ� ���� ���� �ڵ���� �������
		
        setTextfield(); //�ؽ�Ʈ�ʵ�� ������ ��κ��� �ڵ���� ������� �����ڰ� �����Ŵ
      
		action(); //���콺�̺�Ʈ�� �ڵ���� ��������� �����ڿ����� �����
		buttonset();//��ư�� ������ ��κ��� ������� �����ڰ� �����Ŵ
		menu();
		//stopwatch();
		setlabel();//�󺧰��� �ڵ���� ��������� �����ڰ� �����Ŵ
		//new Clock().start();	 
		gettime();//�ð��� ������ �˶��̳� �����ġ���� ����� �ϴ� �ڵ���� ����ְ� �����ڰ� ������
		
}
	public void setTextfield() {//�ؽ�Ʈ�ʵ��� ����
		Font nfont = new Font("�������", Font.BOLD, 15);//font����3(������ �ʿ���)
		list.setFont(nfont);//��Ʈ����
		list.setEditable(false);// textArea�� �����Է� �Ұ�
		a1.setFont(nfont);//��Ʈ����
		a2.setFont(nfont);//��Ʈ����
		a3.setFont(nfont);//��Ʈ����
		timerh.setFont(nfont);//��Ʈ����
		timerm.setFont(nfont);//��Ʈ����
		timers.setFont(nfont);//��Ʈ����
		shutdowntime.setFont(nfont);//��Ʈ����
		shutdownstring.setFont(nfont);//��Ʈ����
		
		timerh.setBounds(70,130,250,30);//timerh��� �ؽ�Ʈ �ʵ��� ��ġ�� ũ������
		timerm.setBounds(70,160,250,30);//timerm�̶�� �ؽ�Ʈ�ʵ��� ��ġ�� ũ������
		timers.setBounds(70,190,250,30);//timers��� �ؽ�Ʈ�ʵ��� ��ġ�� ũ������
		
		list.setBounds(40,120,300,80);//��ġ�� ũ������
		
        a1.setBounds(70, 110, 250, 30);//a1�̶�� �ؽ�Ʈ�ʵ��� ��ġ�� ũ������
        a2.setBounds(70, 145, 250, 30);//a2�̶�� �ؽ�Ʈ�ʵ��� ��ġ�� ũ������
        a3.setBounds(70, 180, 250, 30);//a3�̶�� �ؽ�Ʈ�ʵ��� ��ġ�� ũ������
        shutdowntime.setBounds(80, 100, 250, 30);//shutdowntime�̶�� �ؽ�Ʈ�ʵ��� ��ġ�� ũ������
        shutdownstring.setBounds(80, 130, 250, 30);//shutdownstring�̶�� �ؽ�Ʈ�ʵ��� ��ġ�� ũ������
        shutdowntime.setVisible(false);//shutdowntime�� ������ �ʰ� �����س���
        shutdownstring.setVisible(false);//shutdownstring�� ������ �ʰ� �����س���
        a1.setVisible(false);//a1�� ������ �ʰ� ����
        a2.setVisible(false);//a2�� ������ �ʰ� ����
        a3.setVisible(false);//a3�� ������ �ʰ� ����
        list.setVisible(false);//list�� ������ �ʰ� ����
        timerh.setVisible(false);//timerh �� ������ �ʰ� ����
        timerm.setVisible(false);//timerm �� ������ �ʰ� ����
        timers.setVisible(false);//timers �� ������ �ʰ� ����
        
        
        add(scroll);//�����ӿ� ��ũ�� �߰�
        add(list);//�����ӿ� ����Ʈ �߰�
        add(timerh);//�����ӿ� timerh�߰�
        add(timerm);//�����ӿ� timerm�߰�
        add(timers);//�����ӿ� timers�߰�
        add(a1);//�����ӿ� a1�߰�
        add(a2);//�����ӿ� a2�߰�
        add(a3);//�����ӿ� a3�߰�
        add(shutdowntime);//�����ӿ� shutdowntime�߰�
        add(shutdownstring);//�����ӿ�shutdownstring�߰�
      }//setTextfield()�� ��
	
	public void gettime() {//�ð�����
		String Timerr;
		String stopwatch;//�����ġ�� ����� ���ڿ� ����
		String sday=null;//���������� ���� ������ ���ڷ� ����
		Lstopwatch.setVisible(false);//Lstopwatch�� ������ �ʰ� �Ѵ�.
		dTimer.setVisible(false);//��ư�� ������ �ʰ� ����
		while(true) {//������ ����
			
			Calendar t=Calendar.getInstance();
			int year = t.get(Calendar.YEAR); //������ ����
			int month = t.get(Calendar.MONTH);//���� ����
			int date = t.get(Calendar.DATE);//���� ����
			int amPm = t.get(Calendar.AM_PM);//����/���ı����� ����
			int hour = t.get(Calendar.HOUR);//�ø� ����
			int min = t.get(Calendar.MINUTE);//���� ����
			int sec = t.get(Calendar.SECOND);//�ʸ� ����
			int msec = t.get(Calendar.MILLISECOND);//msec�� ���� but.�������� ����.
			String ampm=amPm==Calendar.AM? "PM":"AM";//���ؼ� pm�̳� am�� ampm�� ����
			int day= t.get(Calendar.DAY_OF_WEEK);//������ ���������� ����1=��~7����
			switch(day) {//����ġ�� ������ day�� �޴´�.
			case 1: //1�϶� 
				sday="Sun";//sun���� ����(�Ͽ���)
				break;//break;
			case 2://2�϶�
				sday="Mon"; //Mon���� ����(��)
				break;//break;
			case 3://3�ϋ�
				sday="Tus";//ȭ����
				break;//break;
			case 4://4�϶�
				sday="Wed";//������
				break;//break;
			case 5://5�϶�
				sday="Thu";//�����
				break;//break;
			case 6://6�϶�
				sday="Fri";//�ݿ���
				break;//break;
			case 7://7�϶�
				sday="Sat";//�����
				break;//break;
			}
			one= (year+"."+month+"."+date+"."+sday+" day");//one�̶�� ���ڿ��� ����
			two=(ampm+" "+hour+":"+min+":"+sec+" sec");//two��� ���ڿ��� ����
			//System.out.println(year+"�� "+month+"�� "+date+"�� "+ampm+hour+"�� "+min+"�� "+sec+"."+msec+"��");//�������� Ȯ���� ���
			first.setText(one);//first�� ������ one(string)���� �����Ѵ�
			second.setText(two);//second�� ������ two(string)���� �����Ѵ�.
			if(amPm==Alarm1&&hour==Alarm2&&min==Alarm3) {//�˶���� �ؽ�Ʈ�ʵ�� �Է¹��� �����͸� ����ð��� ���Ѵ�.
				if(count!=0) {//���ѷ����̱⿡ 0.1�ʿ� �ѹ��� �뷡�� ����ǹǷ� ī��Ʈ��� ������ �̿��� 1���� ���డ���ϰ� �ߴ�.
					Music Alarmsong = new Music("introMusic.mp3");//Music.class���
					Alarmsong.start();//����
					count--;		//�����ϸ� ī��Ʈ�� ������ 0���� �����.
			}}
			if(i>=1) {//������� �������� �����ġ�� �۵����� �ʰ� �ϱ� ���ؼ� i�� �����ߴ�.
				stop++;//msec�� ��� ���Ѵ�.(sleep�� 100�̱⶧���� 10������ ī��Ʈ�Ѵ�.)
				if(stop>=10) { //10�̻��̸� ���� (10������ ī��Ʈ)
					stop=stop-10; //10�� �Ѿ�� �ٽ� 0���� �����.
					ssec++;} //�ʸ� �ϳ� �ø���.	
				if(ssec>=60) {//60�̻��̸� ����(60������ ī��Ʈ)
					ssec=ssec-60;//60�̻��̸� 60�� ���� �ٽ� 0���� ������ش�.
					smin++;}//���� �ø���.
				if(smin>=60) {//60�̻��̸� ����(60������ ī��Ʈ)
					smin=smin-60;//60�̻��̸� 60�� ���� �ٽ� 0���� ������ش�.
					shour++;}//�ð��� �ø���. ��ǻ� ��ð��̻� ��������� ���ٰ� �Ǵ��ؼ� �ð��� ������ �����ʾҴ�.
			}
			stopwatch=(shour+":"+smin+":"+ssec+"."+stop+" Sec");//�����ġ�� ����Ʈ�� ���ڿ��� �����
			Lstopwatch.setText(stopwatch);//Lstopwatch�� stopwatch(string)���� �������ش�.
			if(k>=1) {//k�� 1���� ũ�� ����
				--tmsec;//while������ 0.1�ʸ��� �����ϹǷ� msec
				if(tmsec<=0) {//msec�� 0�̵Ǹ� 

						if(tsec>0||tmin>0||thour>0) {	//sec,min,hour�� �ϳ��� 0�� �ƴϸ�	
							tmsec=tmsec+10;//msec�� 10���� ��������
							tsec--;//sec--����
							}
						if(tmsec<=0&&tsec<=0 &&tmin<=0 &&thour<=0) {//�� 0�̸�
							tmsec=0;//0���� ����
							tsec=0;//0���� ����
							tmin=0;//0���� ����
							thour=0;//0���� ����
							Music buttonExit = new Music("introMusic.mp3");//�˶�����
							buttonExit.start();//�˶�����
							k--;}//k�� 1���ָ鼭 ��������
						
				}
				if(tsec<=0) {//sec�� 0�̸� 
					if(tmin>0||thour>0) {//min,hour�� 0���� ũ��
					tsec=tsec+60;//�ʰ� 60�ö�
					tmin--;}//�п��� 1��
					else
						tsec=0;//�ƴϸ� 0���� ����
				}
				if(tmin<=0) {//���� 0�̸�
					if(thour>0) {//�ð��� 0�̻��϶�
						tmin=tmin+60;//����60���� �ǰ�
						thour--;}//�ð��ϳ� ���̳ʽ�
					else
						tmin=0;//�ƴϸ� ���� 0
					
				}
				if(thour<=0) {//�ð��� 0�̸�
					thour=0;//�״�� 0
				}
				}
			
			Timerr=(thour+":"+tmin+":"+tsec+"."+tmsec+" Sec");//�� �� �� msec
			dTimer.setText(Timerr);//timerr�� ������ �־��ش�.
			add(dTimer);//�����ӿ� �߰�
			add(Lstopwatch);//Lstopwatch�� �����ӿ� �߰��Ѵ�.
			add(first);//first�� �����ӿ� �߰��Ѵ�.
			add(second);//second�� �����ӿ� �߰��Ѵ�.
			try { //Ʈ���� 
				Thread.sleep(100);//0.1��
		    } catch(Exception e) {} //����ó��
		}//while�� ��
	}//gettime()��
	public void setlabel() {//�ð��� ����,�˶� ���� ��
		
		Font font = new Font("digital-7", Font.BOLD, 40);//font����1(������ �ʿ���)
		Font mfont = new Font("Dot Matrix", Font.BOLD, 20);//font����2(������ �ʿ���)
		
		homebutton.setText("Home");//��ư�� Home�̶�� ���ڸ� �����Ѵ�.
		homebutton.setFont(mfont);//mfont�� �����Ѵ�.
		homebutton.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		homebutton.setForeground(Color.white);//���ڻ��� �Ͼ������ �����Ѵ�.
		
		shutdown.setText("OFF");//��ư�� off��� ���ڸ� �����Ѵ�.
		shutdown.setFont(mfont);//mfont�� �����Ѵ�.
		shutdown.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		shutdown.setForeground(Color.white);//���ڻ��� �Ͼ������ �����Ѵ�.
		
		Alarm.setText("Alarm");//��ư�� Alarm�̶�� ���ڸ� �����Ѵ�.
		Alarm.setFont(mfont);//mfont�� �����Ѵ�.
		Alarm.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		Alarm.setForeground(Color.white);//���ڻ��� �Ͼ������ �����Ѵ�.
		
		swstop.setText("stop");//��ư�� stop�̶�� ���ڸ� �����Ѵ�.
		swstop.setFont(mfont);//mfont�� �����Ѵ�.
		swstop.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		swstop.setForeground(Color.white);//���ڻ��� �Ͼ������ �����Ѵ�.
		
		stopwatch.setText("Stopwatch");//��ư�� stopwatch��� ���ڸ� �����Ѵ�.
		stopwatch.setFont(mfont);//mfont�� �����Ѵ�.
		stopwatch.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		stopwatch.setForeground(Color.white);//���ڸ� �Ͼ������ �����Ѵ�.
		
		stopreset.setFont(mfont);//mfont�� �����Ѵ�.
		stopreset.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		stopreset.setForeground(Color.white);//���ڸ� �Ͼ������ �����Ѵ�.
		
		Timerreset.setFont(mfont);//mfont�� �����Ѵ�.
		Timerreset.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		Timerreset.setForeground(Color.white);//���ڸ� �Ͼ������ �����Ѵ�.
		
		shutdownunSet.setFont(mfont);//mfont�� �����Ѵ�.
		shutdownunSet.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		shutdownunSet.setForeground(Color.white);//���ڸ� �Ͼ������ �����Ѵ�.
		
		setTimer.setFont(mfont);//mfont�� �����Ѵ�.
		setTimer.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		setTimer.setForeground(Color.white);//���ڸ� �Ͼ������ �����Ѵ�.
		
		timer.setFont(mfont);//mfont�� �����Ѵ�.
		timer.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		timer.setForeground(Color.white);//���ڸ� �Ͼ������ �����Ѵ�.
		
		Set.setFont(mfont);//mfont�� �����Ѵ�.
		Set.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		Set.setForeground(Color.white);//���ڸ� �Ͼ������ �����Ѵ�.
		
		shutdownSet.setFont(mfont);//mfont�� �����Ѵ�.
		shutdownSet.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		shutdownSet.setForeground(Color.white);//���ڸ� �Ͼ������ �����Ѵ�.
		
		stopstart.setText("start");//��ư�� start��� ���ڸ� �����Ѵ�.
		stopstart.setFont(mfont);//mfont�� �����Ѵ�.
		stopstart.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		stopstart.setForeground(Color.white);//���ڻ��� �Ͼ������ �����Ѵ�.
		
		second.setOpaque(true);//���� �������ϰ� ����
		second.setFont(font);//font�� �����Ѵ�.
		second.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		second.setBounds(85,170,300,50);//��ġ�� ũ�⸦ �����Ѵ�.
		second.setForeground(Color.white);//���ڻ��� �Ͼ������ �����Ѵ�.
		
		Lstopwatch.setOpaque(true);//���� �������ϰ� ����
		Lstopwatch.setFont(font);//font�� �����Ѵ�.
		Lstopwatch.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		Lstopwatch.setBounds(80,70,200,50);//��ġ�� ũ�⸦ �����Ѵ�.
		Lstopwatch.setForeground(Color.white);//���ڻ��� �Ͼ������ �����Ѵ�.
		
		dTimer.setOpaque(true);//���� �������ϰ� ����
		dTimer.setFont(font);//font�� �����Ѵ�.
		dTimer.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		dTimer.setBounds(80,60,320,50);//��ġ�� ũ�⸦ �����Ѵ�.
		dTimer.setForeground(Color.white);//���ڻ��� �Ͼ������ �����Ѵ�.
		
		first.setOpaque(true);//���� �������ϰ� ����
		first.setFont(font);//font�� �����Ѵ�.
		first.setBackground(new Color(0,0,0,0));//��׶��带 0,0,0,0���� �����Ѵ�.
		first.setBounds(60,120,320,50);//��ġ�� ũ�⸦ �����Ѵ�.
		first.setForeground(Color.white);//���ڻ��� �Ͼ������ �����Ѵ�.

	}
	public void buttonset() {//������� ��ư����
		Alarm.setBorderPainted(false);//��ư �׵θ� ���� ����
		Alarm.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		Alarm.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		Timerreset.setBorderPainted(false);//��ư �׵θ� ���� ����
		Timerreset.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		Timerreset.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		timer.setBorderPainted(false);//��ư �׵θ� ���� ����
		timer.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		timer.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		setTimer.setBorderPainted(false);//��ư �׵θ� ���� ����
		setTimer.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		setTimer.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		stopstart.setBorderPainted(false);//��ư �׵θ� ���� ����
		stopstart.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		stopstart.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		stopreset.setBorderPainted(false);//��ư �׵θ� ���� ����
		stopreset.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		stopreset.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		stopwatch.setBorderPainted(false);//��ư �׵θ� ���� ����
		stopwatch.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		stopwatch.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		Set.setBorderPainted(false);//��ư �׵θ� ���� ����
		Set.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		Set.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		shutdownunSet.setBorderPainted(false);//��ư �׵θ� ���� ����
		shutdownunSet.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		shutdownunSet.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		homebutton.setBorderPainted(false);//��ư �׵θ� ���� ����
		homebutton.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		homebutton.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		
		shutdownSet.setBorderPainted(false);//��ư �׵θ� ���� ����
		shutdownSet.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		shutdownSet.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		shutdown.setBorderPainted(false);//��ư �׵θ� ���� ����
		shutdown.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		shutdown.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		swstop.setBorderPainted(false);//��ư �׵θ� ���� ����
		swstop.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		swstop.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		exitbutton.setBorderPainted(false);//��ư �׵θ� ���� ����
		exitbutton.setContentAreaFilled(false);//�̹��� �׵θ� ȿ���� ����
		exitbutton.setFocusPainted(false);//�����ߴ� ��ưǥ�� ����
		
		//��ư��ġ ����
		Timerreset.setBounds(100,230,100,50);//��ưũ��,��ġ����
		setTimer.setBounds(200,230,100,50);//��ưũ��,��ġ����
		timer.setBounds(320,20,100,40);//��ưũ��,��ġ����
		swstop.setBounds(50,200,100,50);//��ưũ��,��ġ����
		stopstart.setBounds(220,200,130,50);//��ưũ��,��ġ����
		Alarm.setBounds(60,20,100,40);//��ưũ��,��ġ����
		Set.setBounds(150,220,80,50);//��ưũ��,��ġ����
		shutdownSet.setBounds(100,200,80,50);//��ưũ��,��ġ����
		shutdownunSet.setBounds(200,200,110,50);//��ưũ��,��ġ����
		shutdown.setBounds(140,20,70,40);//��ưũ��,��ġ����
		exitbutton.setBounds(380, 0, 20, 20);//��ưũ��,��ġ����
		homebutton.setBounds(-10, 20, 90,40);//��ưũ��,��ġ����
		stopwatch.setBounds(190,20,150,40);//��ưũ��,��ġ����
		stopreset.setBounds(120,200,130,50);//��ưũ��,��ġ����
		//����(Ȯ�ι�ư)
		Timerreset.setVisible(false);//������ �ʰ��ϱ�
		shutdownSet.setVisible(false);//������ �ʰ��ϱ�
		swstop.setVisible(false);//������ �ʰ��ϱ�
		stopstart.setVisible(false);//������ �ʰ��ϱ�
		Set.setVisible(false);//������ �ʰ��ϱ�
		shutdownunSet.setVisible(false);//������ �ʰ��ϱ�
		stopreset.setVisible(false);//������ �ʰ��ϱ�
		setTimer.setVisible(false);//������ �ʰ��ϱ�
		//��ư�߰�
		add(Timerreset);//JFrame�� �߰�
		add(setTimer);//JFrame�� �߰�
		add(timer);//JFrame�� �߰�
		add(stopreset);//JFrame�� �߰�
		add(shutdownunSet);//JFrame�� �߰�
		add(swstop);//JFrame�� �߰�
		add(Alarm);//JFrame�� �߰�
		add(stopstart);//JFrame�� �߰�
		add(Set);//JFrame�� �߰�
		add(stopwatch);//JFrame�� �߰�
		add(shutdown);//JFrame�� �߰�
		add(shutdownSet);//JFrame�� �߰�
		add(exitbutton);//JFrame�� �߰�
		add(homebutton);//JFrame�� �߰�
	}
	public void action() {		//���콺 �������� �÷����� ��������
		exitbutton.addMouseListener(new MouseAdapter() { //������
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺 ������
				exitbutton.setIcon(exitprImage); //�̹��� ����
				exitbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//�뷡 
				buttonEnter.start();}//�뷡 ����
			@Override
			public void mouseExited(MouseEvent e) { //���콺 �������� 
				exitbutton.setIcon(exitunImage);//���콺 �������� �̹��� ����
				exitbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺 ��������
				Music buttonExit = new Music("open.mp3");//���콺 �������� �Ҹ�
				buttonExit.start();//�Ҹ� ����
				try {//����ó����
					Thread.sleep(1000);//1��
				} catch (InterruptedException ex) {//����ó��
					ex.printStackTrace();}//����ó��
				System.exit(0);}});//���α׷� ����
		//
		homebutton.addMouseListener(new MouseAdapter() { //�˴ٿ�
			@Override
			public void mouseEntered(MouseEvent e) { //���콺 ������ 		
				homebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//���콺 ������ �Ҹ�
				buttonEnter.start();}//�Ҹ� ����
			@Override
			public void mouseExited(MouseEvent e) {//���콺 �������� 		
				homebutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ�� ����
			@Override
			public void mousePressed(MouseEvent e) {//���콺 ��������
				Music buttonExit = new Music("open.mp3");//�뷡����
				buttonExit.start();//���ǽ���
				first.setVisible(true);//��ư�� ���̰�
				second.setVisible(true);//��ư�� ���̰�
				shutdowntime.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        shutdownstring.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        shutdownSet.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        a1.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        a2.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        a3.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        Set.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        swstop.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        stopstart.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        shutdownunSet.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        stopreset.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        setTimer.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        Timerreset.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        timerh.setVisible(false);//timerh �� ������ �ʰ� ����
		        timerm.setVisible(false);//timerm �� ������ �ʰ� ����
		        timers.setVisible(false);//timers �� ������ �ʰ� ����
		        dTimer.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        list.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
			}});
		stopwatch.addMouseListener(new MouseAdapter() { //�˴ٿ�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��������
				stopwatch.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//���� ����
				buttonEnter.start();}//���� ����
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� ��������
				stopwatch.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺�̺�Ʈ
				Music buttonExit = new Music("open.mp3");//�˸����Ǽ���
				buttonExit.start();//���ǽ���
				first.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
				second.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
				shutdowntime.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        shutdownstring.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        shutdownSet.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        a1.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        a2.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        a3.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        Set.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        Lstopwatch.setVisible(true);//��ư�� ���̰� ���ش�.
		        stopstart.setVisible(true);//��ư�� ���̰� ���ش�.
		        swstop.setVisible(true);//��ư�� ���̰� ���ش�.
		        shutdownunSet.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        stopreset.setVisible(true);//��ư�� ������ �ʰ� ���ش�.
		        setTimer.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        Timerreset.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        timerh.setVisible(false);//timerh �� ������ �ʰ� ����
		        timerm.setVisible(false);//timerm �� ������ �ʰ� ����
		        timers.setVisible(false);//timers �� ������ �ʰ� ����
		        dTimer.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        list.setVisible(true);//��ư�� ���̰� ���ش�.
			}});
		//////
		stopstart.addMouseListener(new MouseAdapter() { //�˴ٿ�
			@Override
			public void mouseEntered(MouseEvent e) { // 	���콺 ������			
				stopstart.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//���� ����
				buttonEnter.start();}//���� ����
			@Override
			public void mouseExited(MouseEvent e) {//���콺 �������� 				
				stopstart.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺 ��������
				Music buttonExit = new Music("open.mp3");//���� ����
				buttonExit.start();//���� ����
				i=1;}});//i�� 1�� ����
		//////
		shutdown.addMouseListener(new MouseAdapter() { //�˴ٿ� ���콺 �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) { // 		���콺 ������	
				shutdown.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3"); //���� ����
				buttonEnter.start();}//���� ����
			@Override
			public void mouseExited(MouseEvent e) {//���콺 �������� 				
				shutdown.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺 ��������
				Music buttonExit = new Music("open.mp3");//���콺 �������� �Ҹ� ����
				buttonExit.start();//�Ҹ� ����
				first.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
				second.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
				shutdowntime.setVisible(true);//��ư�� ���̰� �Ѵ�.
		        shutdownstring.setVisible(true);//��ư�� ���̰� �Ѵ�.
		        shutdownSet.setVisible(true);//��ư�� ���̰� �Ѵ�.
		        a1.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        a2.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        a3.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        Set.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        Lstopwatch.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        swstop.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        stopstart.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        shutdownunSet.setVisible(true);//��ư�� ���̰� �Ѵ�.
		        stopreset.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        setTimer.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        Timerreset.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        timerh.setVisible(false);//timerh �� ������ �ʰ� ����
		        timerm.setVisible(false);//timerm �� ������ �ʰ� ����
		        timers.setVisible(false);//timers �� ������ �ʰ� ����
		        dTimer.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
		        list.setVisible(false);//��ư�� ������ �ʰ� ���ش�.
			}});
		/////////
		Alarm.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) { // 	���콺�� ������			
				Alarm.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//���Ǽ���
				buttonEnter.start();}//������ ���� ����
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� ��������
				Alarm.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				Music buttonExit = new Music("open.mp3");//���Ǽ���
				buttonExit.start();//������ ���� ����
				Alarmlabel.setVisible(true);//��ư�� ���̰� �Ѵ�.
				first.setVisible(false);//��ư�� ������ �ʰ� �Ѵ�.
				second.setVisible(false);//��ư�� ������ �ʰ� �Ѵ�.
			    a1.setVisible(true);//��ư�� ���̰� �Ѵ�.
		        a2.setVisible(true);//��ư�� ���̰� �Ѵ�.
		        a3.setVisible(true);//��ư�� ���̰� �Ѵ�.
				Set.setVisible(true);//��ư�� ���̰� �Ѵ�.
				shutdowntime.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        shutdownstring.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        shutdownSet.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        Lstopwatch.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        swstop.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        stopstart.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        shutdownunSet.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        stopreset.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        setTimer.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        Timerreset.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        timerh.setVisible(false);//timerh �� ������ �ʰ� ����
		        timerm.setVisible(false);//timerm �� ������ �ʰ� ����
		        timers.setVisible(false);//timers �� ������ �ʰ� ����
		        dTimer.setVisible(false);//��ư�� ���̰� �Ѵ�.
		        list.setVisible(false);//��ư�� ���̰� �Ѵ�.
			}});
		///
		timer.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ������				
				timer.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//���� ����
				buttonEnter.start();}//������ �����Ѵ�.
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� ��������
				timer.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				Music buttonExit = new Music("open.mp3");//���� ����
				buttonExit.start();//���� ����
				Alarmlabel.setVisible(false);//������ �ʰ� �ϱ�
				first.setVisible(false);//������ �ʰ� �ϱ�
				second.setVisible(false);//������ �ʰ� �ϱ�
			    a1.setVisible(false);//������ �ʰ� �ϱ�
		        a2.setVisible(false);//������ �ʰ� �ϱ�
		        a3.setVisible(false);//������ �ʰ� �ϱ�
				Set.setVisible(false);//������ �ʰ� �ϱ�
				shutdowntime.setVisible(false);//������ �ʰ� �ϱ�
		        shutdownstring.setVisible(false);//������ �ʰ� �ϱ�
		        shutdownSet.setVisible(false);//������ �ʰ� �ϱ�
		        Lstopwatch.setVisible(false);//������ �ʰ� �ϱ�
		        swstop.setVisible(false);//������ �ʰ� �ϱ�
		        stopstart.setVisible(false);//������ �ʰ� �ϱ�
		        shutdownunSet.setVisible(false);//������ �ʰ� �ϱ�
		        stopreset.setVisible(false);//������ �ʰ� �ϱ�
		        setTimer.setVisible(true);//��ư�� ���̰� �Ѵ�.
		        timerh.setVisible(true);//timerh �� ������ �ʰ� ����
		        timerm.setVisible(true);//timerm �� ������ �ʰ� ����
		        timers.setVisible(true);//timers �� ������ �ʰ� ����
		        dTimer.setVisible(true);//��ư�� ���̰� �Ѵ�.
		        Timerreset.setVisible(true);//��ư�� ���̰� �Ѵ�.
		        list.setVisible(false);//������ �ʰ� �ϱ�
			}});
		//
		swstop.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺 ������			
				swstop.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺 Ŀ�� ����
				Music buttonEnter = new Music("�÷�����.mp3");//��ư�� ����
				buttonEnter.start();}//��ư�� ����
			@Override
			public void mouseExited(MouseEvent e) { 				//���콺 ��������
				swstop.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//���콺 Ŀ�� ����
			@Override
			public void mousePressed(MouseEvent e) {//���콺 ��������
				Music buttonExit = new Music("open.mp3");//��ư�� ����
				buttonExit.start(); //��ư�� ����
				if(i>=1)//i�� 1���� Ŭ��
					i--;//���Ѵ�� ������� �ʰ� ����
				
				listnum=(shour+":"+smin+":"+ssec+"."+stop+"\n");//listnum���� ��Ƽ� ��Ʈ������ �ٲ�
				list.append(listnum);//list�� listnum�� ������ �߰�
				}});
		//
		stopreset.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) { // 	���콺 ��������			
				stopreset.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺 Ŀ��
				Music buttonEnter = new Music("�÷�����.mp3");//���� ����
				buttonEnter.start();}//���� ����
			@Override
			public void mouseExited(MouseEvent e) { 				//���콺 ��������
				stopreset.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺 ��������
				Music buttonExit = new Music("open.mp3");//��ư���Ǽ���
				buttonExit.start();//���� ����
				if(i>=1)//i�� 1���� ũ�� ������
					i--;//0���� ���� ���Ѵ�� ���ư��� �ʰ� ����
				stop=0; //�����ġ�� ����� ����  msec(1�ڸ�)
				ssec=0;//�����ġ�� ����� ����  ��
				smin=0;//�����ġ�� ����� ����  ��
				shour=0;//�����ġ�� ����� ���� �ð�
				list.setText("");//list�� ������ ��ĭ���� �������ش�.
				}});
		Timerreset.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) { // 	���콺 ������			
				Timerreset.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//��ư ������
				buttonEnter.start();}//��ư ������
			@Override
			public void mouseExited(MouseEvent e) { 				//���콺 ��������
				Timerreset.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺 ��������
				Music buttonExit = new Music("open.mp3");//���� ����
				buttonExit.start();//���� ����
				if(k>=1)//���̰� 1���� ũ�� ����
					k--;//k--�� �ؼ� �����ġ�� ������������� �ʰ� ����
				tmsec=0; //�����ġ�� ����� ����  msec(1�ڸ�)
				tsec=0;//�����ġ�� ����� ����  ��
				tmin=0;//�����ġ�� ����� ����  ��
				thour=0;//�����ġ�� ����� ���� �ð�
				}});
		//
		setTimer.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) { // 				���콺 ��������
				setTimer.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//���Ǽ���
				buttonEnter.start();}//���ǽ���
			@Override
			public void mouseExited(MouseEvent e) { 	//���콺 ��������			
				setTimer.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺 ��������
				Music buttonExit = new Music("open.mp3");//��ư�� ����
				buttonExit.start();//��ư�� ���
				k++;//k++�ؼ� �����ġ�� ����ϴ��ϰ� ����
				tsec=Integer.parseInt(timers.getText());//�����ġ�� ����� ����  ��
				tmin=Integer.parseInt(timerm.getText());//�����ġ�� ����� ����  ��
				thour=Integer.parseInt(timerh.getText());//�����ġ�� ����� ���� �ð�
				
				}});
		//
		Set.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ �߰�
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��������
				
				Set.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//��ư�� ����
				buttonEnter.start();}//��ư�� ����
			@Override
			public void mouseExited(MouseEvent e) { 			//���콺�� ��ư���� ��������	
				Set.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				Music buttonExit = new Music("open.mp3");//�ݺ����� �ʰ� ��ư���� ����Ѵ�.
				buttonExit.start();//��ư�� ����
				first.setVisible(false);//������ �ʰ� ���ش�.
				second.setVisible(false);//������ �ʰ� ���ش�.
				count++; //ī��Ʈ�� �÷��� �˶��� ������ �� �ְ� ���ش�.
				Alarm1=Integer.parseInt(a1.getText());//������������ �޾Ƽ� ����
				Alarm2=Integer.parseInt(a2.getText());//������������ �޾Ƽ� ����
				Alarm3=Integer.parseInt(a3.getText());//������������ �޾Ƽ� ����
				}});
		//
		shutdownSet.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) { // ��ư�� ��������				
				shutdownSet.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//��ư�� ����
				buttonEnter.start();}//��ư�� ����
			@Override
			public void mouseExited(MouseEvent e) {//���콺�� ��ư���� �������� 				
				shutdownSet.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺 ��������
				Music buttonExit = new Music("open.mp3");//��ư�� ����
				buttonExit.start();//��ư�� ����
				first.setVisible(false);//�Ⱥ��̰�
				second.setVisible(false);		//�Ⱥ��̰�
				time=Integer.parseInt(shutdowntime.getText());//�ؽ�Ʈ�ʵ忡 �ִ� ������ �������� �ٲ㼭 time�� ����
				word=shutdownstring.getText(); //���ڿ����޾Ƽ� word�� ����
				computeroff();}});//��ǻ�͸� �����ϴ� �޼ҵ带 �ҷ��´�.
		//
		shutdownunSet.addMouseListener(new MouseAdapter() { //���콺�̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ��������			
				shutdownunSet.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ŀ������
				Music buttonEnter = new Music("�÷�����.mp3");//�ѹ��� ����Ǵ� ��ư��
				buttonEnter.start();}//��ư�� ����
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� �ش� ��ư���� ��������	
				shutdownunSet.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//Ŀ������
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				Music buttonExit = new Music("open.mp3");//�ѹ��� �ݺ��Ѵ�.
				buttonExit.start(); //�뷡�� �����Ѵ�.
				first.setVisible(false);//������ �ʰ� �Ѵ�.
				second.setVisible(false);		//������ �ʰ� �Ѵ�.
				time=Integer.parseInt(shutdowntime.getText()); //������������ ��ȯ�ؼ� Ÿ�ӿ� �ִ´�.
				word=shutdownstring.getText(); //shutdownstring���� word�� ���� ���ڿ��� �ִ´�.
				computeron();}}); //�˴ٿ� ������ ���� �޼ҵ带 ȣ��
		//
		a1.addMouseListener(new MouseAdapter() { //	���콺�̺�Ʈ			
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				a1.setText("");	//���콺�� ������ ��ĭ���� ����
			}});
		a2.addMouseListener(new MouseAdapter() { //		���콺�̺�Ʈ		
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				a2.setText("");	//���콺�� ������ ��ĭ���� ����
			}});
		a3.addMouseListener(new MouseAdapter() { //	���콺�̺�Ʈ	
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				a3.setText("");	//���콺�� ������ ��ĭ���� ����
			}});
		timerm.addMouseListener(new MouseAdapter() { //	���콺�̺�Ʈ	
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				timerm.setText("");	//���콺�� ������ ��ĭ���� ����
			}});
		timers.addMouseListener(new MouseAdapter() { //	���콺�̺�Ʈ	
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				timers.setText("");	//���콺�� ������ ��ĭ���� ����
			}});
		timerh.addMouseListener(new MouseAdapter() { //	���콺�̺�Ʈ	
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				timerh.setText("");	//���콺�� ������ ��ĭ���� ����
			}});
		shutdowntime.addMouseListener(new MouseAdapter() { //���콺�̺�Ʈ		
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				shutdowntime.setText("");	//���콺�� ������ ��ĭ���� ����
			}});
		shutdownstring.addMouseListener(new MouseAdapter() { //���콺�̺�Ʈ	
			public void mousePressed(MouseEvent e) {//���콺�� ��������
				shutdownstring.setText("");	//���콺�� ������ ��ĭ���� ����
			}});
		}
	public void set() {
		setUndecorated(true);//������ �Ⱥ��̰� ����
		setTitle("Y_Clock"); // Ÿ��Ʋ
		setSize(Main.SCREENW, Main.SCREENH); // ���ο��� ���� ���� ũ�� ������
		setLocationRelativeTo(null);// ȭ�� ����� â�� ����
		setResizable(false);//������������� ����Ұ�
		setLayout(null);//���̾ƿ� ��������
		setBackground(new Color(0, 0, 0, 0));//��漳��
		setVisible(true); // ���̰�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���������� jframe�� ����ǰ� ����
		
	}
	public void computeroff() {//��ǻ�� ���Ḧ ���� ����
		try {//����ó������
			Runtime.getRuntime().exec("shutdown -s -t "+time+" -c \""+word+"\"");//shutdowns��ɾ ����
        } catch (Exception e) {}}
	public void computeron() {//��ǻ�� ���Ḧ �����ϱ� ���� ����
		try {//����ó��
			Runtime.getRuntime().exec("shutdown -a");//shutdowns��ɾ ���
        } catch (Exception e) {}}
	public void menu() { // ��ܸ޴�
		menuBar.setBounds(0, 0, 400, 20);//�޴� ��ġ,ũ������
		menuBar.addMouseListener(new MouseAdapter() {//���콺 �̺�Ʈ
			@Override
			public void mousePressed(MouseEvent e) {//���콺 ��������
				mouseX = e.getX(); //x��ǥ�� �޾� mousex�� �ִ´�.
				mouseY = e.getY();}});//y��ǥ�� �޾� mousey�� �ִ´�.
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {//���콺 �̺�Ʈ
			@Override
			public void mouseDragged(MouseEvent e) {//���콺�� �巡��������
				int x = e.getXOnScreen();//��ũ�� x��ǥ
				int y = e.getYOnScreen();//��ũ�� y��ǥ
				setLocation(x - mouseX, y - mouseY);}}); //��ġ ���
		add(menuBar);}//�޴��ٸ� �����ӿ� �߰�
	public void paint(Graphics g) {//�׸��� �Լ�(�����������)
		screenImage=createImage(Main.SCREENW, Main.SCREENH);//400,300�� ũ���� �̹�������
		screenGraphic=screenImage.getGraphics();//screenGraphic�� �־���
		screenDraw(screenGraphic);//screenDraw�θ�
		g.drawImage(screenImage, 0, 0, null);}//screenimage�� �׷���
	public void screenDraw(Graphics g) {//screendraw�Լ�
		g.drawImage(background, 0 ,0 ,null);//���׷���
		paintComponents(g);//add�� �߰����غκ��� �׷���
		this.repaint();}}//�ٽñ׷���
