package whw;

import java.awt.*;
import java.awt.event.*;

public class win3 extends Frame implements ActionListener
{	
	 private static Frame f=new Frame("�p���");
	 private static Panel pn1=new Panel(new GridLayout(4,3));
	 private static Panel pn2=new Panel(new GridLayout(4,1));
	 private static Label lab=new Label("0",Label.RIGHT);
	 private static Button cn,ad,sub,amo; //clear�B+�B-�B=
	 private static Button dig[]=new Button[10]; //0~9
	 private static long num; //�s�񵲪G
	 private static byte op; //�N��B��l
	
	public static void main(String[] a)
	{
		 f.setLayout(null);
		 f.setBounds(450,250,160,180);
		 f.setResizable(false);

		 lab.setBounds(20,30,120,20);
		 lab.setBackground(new Color(240,220,190));
		 
		 pn1.setBounds(20,60,90,105);
		 pn2.setBounds(110,60,30,105);
		 
		 for(int i=0;i<=9;i++)//�Ʀr0~9
		 {
		   dig[i]=new Button(Integer.toString(i));
		   pn1.add(dig[i]);
		   dig[i].addActionListener(new ActLis());
		 }
		
		    cn=new Button("C"); //clear
		    pn1.add(cn);
		    cn.addActionListener(new ActLis());
		    
		    amo=new Button("=");
		    pn1.add(amo);
		    amo.addActionListener(new ActLis());
		    
		    ad=new Button("+");
		    pn2.add(ad);
		    ad.addActionListener(new ActLis());
		   
		    sub=new Button("-");
		    pn2.add(sub);
		    sub.addActionListener(new ActLis());
		    		    
		    f.addWindowListener(new WindowAdapter()
		    { public void windowClosing(WindowEvent e){System.exit(0); }});  
		    f.add(lab); f.add(pn1); f.add(pn2); f.setVisible(true);
	}
	
	public static class ActLis implements  ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				long result;//�s��Ѧr���ন���ƭ�
				Button btn=(Button) e.getSource();
				try{//�B�z1~9
					for(int i=0;i<=9;i++)
					{
						if(btn==dig[i])
	            	 	{ od(dig[i]); break; }
					}
					if(btn==cn)
					{
						result=0L;//���x�s�����G�k0 
						num=0L; op=0;
						lab.setText(Long.toString(num));
					}
					else if(btn==ad) { sn(ad);op=1; }
					else if(btn==sub) { sn(sub);op=2; }
					else if(btn==amo)
					{
						result=Long.parseLong(lab.getText());
						switch(op)
						{
	            	 		case 1: num+=result; break;
	            	 		case 2: num-=result; break;
	            	 		default:
						}
						result=0L; //��X�B��᪺���G����ܾ�
						lab.setText(Long.toString(num));
					}
					}catch(ArithmeticException ae)
				    { 
						//�����Q���ƬO�s���ҥ~ 
					}
			}catch(NumberFormatException ne) 
			{
				//�����ҥ~ 
			}
		}
	      private void od(Button btn)//��X�ƭȨ���ܾ�
	      {
	    	  lab.setText(Long.toString(Long.parseLong(lab.getText()+btn.getLabel())));
	      }
	      private void sn(Button oper) //��Ĥ@�ժ��Ӧs�_��
	      {
	          num=Long.parseLong(lab.getText());
	          lab.setText(Long.toString(0L));
	      }
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}



