package clock01;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Music extends Thread{//���α׷��ȿ� �ִ� ���� ���α׷�
	private Player player;//�ڹ��ܿ��ִ� ���̺귯�����ϳ�
	
	private File file; //I/o
	private FileInputStream f;//���Ͻ�Ʈ�� �غ�
	private BufferedInputStream b;//���� ��Ʈ���غ�
	
	public Music(String name) {//������
		try {//����ó��
			file=new File(Main.class.getResource("../music/"+name).toURI());//uri���ϰ��
			f=new FileInputStream(file); //FileInputStream f=new FileInputStream(file);
			b=new BufferedInputStream(f);//������ private�� ������
			player=new Player(b);//�ش������� ���� �� �ְ� ����
		}catch(Exception e) {//try������ ������ �߻��ϸ� catch��
			System.out.println(e.getMessage());//�������߻������� ���
		}
	}
	public void close() {//������ ���� ����Ǵ����� �׻� �����Ҽ� �ְ� ����
		player.close();	
		this.interrupt(); //���� �����ϴ� ���α׷��� ����
	}
	@Override
	public void run() { //Thread��� �Լ��� ��ӹ����� ������ ����ؾ� �Ѵٰ� �Ѵ�.
		try {//����ó��
				player.play();//���� ����
				f=new FileInputStream(file);//f=���ϰ�θ� �Է¹ް� 
				b=new BufferedInputStream(f);//����� ���� ��ü�� �����ϰ� ���� �Է� ��ü ����
				player=new Player(b);//player ���� 
		}catch(Exception e) {
			System.out.println(e.getMessage());//������ �߻��ϸ� ����
		}
	}
}
