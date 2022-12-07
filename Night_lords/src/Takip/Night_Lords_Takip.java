package Takip;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Helpers.DBConnection;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Night_Lords_Takip extends JFrame {

	private static final JLabel[] JLabel = null;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Night_Lords_Takip frame = new Night_Lords_Takip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JButton[] button = new JButton[50];
	int[] sayi=new int[50];
	int index=-1;
	int adet=1;
	private JTextField tftarih;
	public Night_Lords_Takip() {
		setTitle("Night Lords Masalar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1368, 768);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Yonetici = new JMenu("Yönetici");
		menuBar.add(Yonetici);
		
		JMenuItem mnıtmNewMenuItem = new JMenuItem("Geçmiş Siparişler");
		mnıtmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order f2=new order();
			    f2.setVisible(true);
			    dispose();
			}
		});
		Yonetici.add(mnıtmNewMenuItem);
		
		JMenuItem mnıtmNewMenuItem_1 = new JMenuItem("Stok Güncelle");
		mnıtmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guncelle f3=new guncelle();
				f3.setVisible(true);
				dispose();
			}
		});
		Yonetici.add(mnıtmNewMenuItem_1);
		
		JMenuItem mnıtmNewMenuItem_2 = new JMenuItem("Fiyat Güncelle");
		mnıtmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				price f=new price();
				f.setVisible(true);
				dispose();
			}
		});
		Yonetici.add(mnıtmNewMenuItem_2);
		
		JMenuItem mnıtmNewMenuItem_2_1 = new JMenuItem("Eklemeler");
		mnıtmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert ınsert=new insert();
				ınsert.setVisible(true);
				
			}
		});
		Yonetici.add(mnıtmNewMenuItem_2_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.MAGENTA);
		tabbedPane.setBounds(0, 0, 1368, 768);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setForeground(Color.BLACK);
		tabbedPane.addTab("Masalar", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		tftarih = new JTextField();
		tftarih.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tftarih.setText(" ");
			}
		});
		tftarih.setText("İşlem Tarihi");
		tftarih.setBounds(1082, 11, 189, 31);
		panel_1.add(tftarih);
		tftarih.setColumns(10);
		
		JButton btnonay = new JButton("onayla");
		btnonay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cevap=JOptionPane.showConfirmDialog(null,"Tarihi Güncellemek İstiyor Musun?","Kapat",JOptionPane.YES_NO_OPTION);
				if(cevap==0)
				{
                  try {
					
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();		        		     			        
			      	st.executeUpdate("Update tables SET   tarih='"+tftarih.getText()+"'");
			      	JOptionPane.showMessageDialog(btnonay,"Tarih Güncellenmiştir!");
			        
                  }
                  catch(SQLException e1) 
				    {

			            e1.printStackTrace();
			        }	
			Night_Lords_Takip f0=new Night_Lords_Takip();
					f0.setVisible(true);
					dispose();
				}
			}
		});
		btnonay.setBounds(1132, 53, 89, 23);
		panel_1.add(btnonay);
		
		
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();	
	         
	       ResultSet rs =st.executeQuery("select* from tables");
	       while(rs.next())
	       { 
	    	   index++;	    	 
	    	  sayi[index]=rs.getInt("table_id");
	    	  adet=index;
	    	  
	       }
	       st.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		int x=10,y=10;
		for(int i=0; i<=adet; i++)
		{
			    button[i] = new JButton("");
			    button[i].setText("Masa"+" "+sayi[i]);
			    button[i].setBounds(x, y, 150, 50);		    
			    panel_1.add(button[i]);	
			    button[i].setBackground(Color.CYAN);
			    x+=200;
			    if(x>900)
			    {
			    	x=10;
			    	y+=150;
			    		
			    }
			
		}
		
		
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_1_adisyon f1=new table_1_adisyon();
				f1.setVisible(true);
				dispose();
			}
		});
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_2_adisyon f2=new table_2_adisyon();
				f2.setVisible(true);
				dispose();
			}
		});
		
		button[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_3_adisyon f3=new table_3_adisyon();
				f3.setVisible(true);
				dispose();
			}
		});
		
		button[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_4_adisyon f4=new table_4_adisyon();
				f4.setVisible(true);
				dispose();
			}
		});
		button[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_5_adisyon f5=new table_5_adisyon();
				f5.setVisible(true);
				dispose();
			}
		});
		button[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_6_adisyon f6=new table_6_adisyon();
				f6.setVisible(true);
				dispose();
			}
		});
		button[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_7_adisyon f7=new table_7_adisyon();
				f7.setVisible(true);
				dispose();
			}
		});
		button[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_8_adisyon f8=new table_8_adisyon();
				f8.setVisible(true);
				dispose();
			}
		});
		button[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_9_adisyon f9=new table_9_adisyon();
				f9.setVisible(true);
				dispose();
			}
		});
		
		button[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_10_adisyon f10=new table_10_adisyon();
				f10.setVisible(true);
				dispose();
			}
		});
		button[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_11_adisyon f11=new table_11_adisyon();
				f11.setVisible(true);
				dispose();
			}
		});
		button[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_12_adisyon f12=new table_12_adisyon();
				f12.setVisible(true);
				dispose();
			}
		});
		button[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_13_adisyon f13=new table_13_adisyon();
				f13.setVisible(true);
				dispose();
			}
		});
		button[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_14_adisyon f14=new table_14_adisyon();
				f14.setVisible(true);
				dispose();
			}
		});
		button[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_15_adisyon f15=new table_15_adisyon();
				f15.setVisible(true);
				dispose();
			}
		});
		button[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_16_adisyon f16=new table_16_adisyon();
				f16.setVisible(true);
				dispose();
			}
		});
		button[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_17_adisyon f17=new table_17_adisyon();
				f17.setVisible(true);
				dispose();
			}
		});
		button[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_18_adisyon f18=new table_18_adisyon();
				f18.setVisible(true);
				dispose();
			}
		});
		button[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_19_adisyon f19=new table_19_adisyon();
				f19.setVisible(true);
				dispose();
			}
		});
		button[19].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_20_adisyon f20=new table_20_adisyon();
				f20.setVisible(true);
				dispose();
			}
		});
	}
}
