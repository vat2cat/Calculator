package whw;

import java.awt.*;
import java.awt.event.*;

public class win3 extends Frame implements ActionListener
{	
	 private static Frame f=new Frame("計算機");
	 private static Panel pn1=new Panel(new GridLayout(4,3));
	 private static Panel pn2=new Panel(new GridLayout(4,1));
	 private static Label lab=new Label("0",Label.RIGHT);
	 private static Button cn,ad,sub,amo; //clear、+、-、=
	 private static Button dig[]=new Button[10]; //0~9
	 private static long num; //存放結果
	 private static byte op; //代表運算子
	
	public static void main(String[] a)
	{
		 f.setLayout(null);
		 f.setBounds(450,250,160,180);
		 f.setResizable(false);

		 lab.setBounds(20,30,120,20);
		 lab.setBackground(new Color(240,220,190));
		 
		 pn1.setBounds(20,60,90,105);
		 pn2.setBounds(110,60,30,105);
		 
		 for(int i=0;i<=9;i++)//數字0~9
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
				long result;//存放由字串轉成的數值
				Button btn=(Button) e.getSource();
				try{//處理1~9
					for(int i=0;i<=9;i++)
					{
						if(btn==dig[i])
	            	 	{ od(dig[i]); break; }
					}
					if(btn==cn)
					{
						result=0L;//把儲存的結果歸0 
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
						result=0L; //輸出運算後的結果到顯示器
						lab.setText(Long.toString(num));
					}
					}catch(ArithmeticException ae)
				    { 
						//捕捉被除數是零的例外 
					}
			}catch(NumberFormatException ne) 
			{
				//捕捉例外 
			}
		}
	      private void od(Button btn)//輸出數值到顯示器
	      {
	    	  lab.setText(Long.toString(Long.parseLong(lab.getText()+btn.getLabel())));
	      }
	      private void sn(Button oper) //把第一組的植存起來
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



