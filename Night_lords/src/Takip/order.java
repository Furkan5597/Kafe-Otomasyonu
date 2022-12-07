package Takip;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Helpers.DBConnection;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class order extends JFrame {

	private JPanel contentPane;
	private JTextField tfsource;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					order frame = new order();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public float top;
	int sayi;
	DefaultTableModel modelim=new DefaultTableModel();
    Object[] kolonlar= {"TARİH","ÖDENEN ÜCRET","Masa Numarası"};
	Object[] satirlar=new Object[6];
	Object[] urun=new Object[2];

	Object[] grup= {"TARİH","SİPARİŞ SAYISI"};
	Object[] urungrup= {"ÜRÜN ADI","SATILAN ADET"};
	Object[] detay= {"MÜŞTERİ NUMARASI","MASA NUMARASI","SAYI","SİPARİŞLER","TARİH"};
	private JTextField tfdetay;
	
	public order() {
		setTitle("Ge\u00E7mi\u015F Sipari\u015Fler");
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbtop = new JLabel("0");
		lbtop.setHorizontalAlignment(SwingConstants.CENTER);
		lbtop.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbtop.setBounds(188, 454, 45, 13);
		contentPane.add(lbtop);
		
		JLabel lbl = new JLabel("Yap\u0131lan Toplam Sat\u0131\u015F Tutar\u0131:");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl.setBounds(20, 454, 168, 13);
		contentPane.add(lbl);
		
	
		
		tfsource = new JTextField();
		tfsource.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			  
				try {
					top=0;
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
			        modelim.setRowCount(0);
			        String liste="select * from orders where  tarih LIKE '%"+tfsource.getText()+"%' ";
			        ResultSet rs =st.executeQuery(liste);
			        modelim.setColumnIdentifiers(kolonlar);
			        while(rs.next())
			        {		        
			        	satirlar[0]=rs.getString("tarih");
			        	satirlar[1]=rs.getString("fiyat");
			        	satirlar[2]=rs.getString("masa_numarasi");			        				        	
			        	modelim.addRow(satirlar);	
			        	top+=rs.getFloat("fiyat");
			        	
			        }
			       table.setModel(modelim);
			       lbtop.setText(""+top);
			       st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
				
			}
		});
		tfsource.setBounds(25, 34, 192, 19);
		contentPane.add(tfsource);
		tfsource.setColumns(10);
		 
		tfsource.setVisible(false);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 746, 370);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Night_Lords_Takip f1=new Night_Lords_Takip();
				f1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(664, 451, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton order = new JButton("Siparişler");
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					top=0;
					lbl.setText("Yapılan Toplam Satış Tutarı:");
					tfsource.setText("");
					tfdetay.setVisible(false);
					tfsource.setVisible(true);
					modelim.setRowCount(0);	
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
			        		    
			     ResultSet rs =st.executeQuery("select * from orders  ");
			     modelim.setColumnIdentifiers(kolonlar);
			        while(rs.next())
			        {
			        	
			        	satirlar[0]=rs.getString("tarih");
			        	satirlar[1]=rs.getFloat("fiyat");
			        	satirlar[2]=rs.getInt("masa_numarasi");
			        				        
			        	modelim.addRow(satirlar);	
			        	top+=rs.getFloat("fiyat");
			        }
			       table.setModel(modelim);
			       lbtop.setText(""+top);
			       st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
				
			}
		});
		order.setFont(new Font("Tahoma", Font.PLAIN, 13));
		order.setBounds(764, 262, 117, 21);
		contentPane.add(order);
		
		JButton btnGrupla = new JButton("Grupla");
		btnGrupla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					sayi=0;
					lbl.setText("Toplam Sipariş Sayısı");
					tfsource.setText("");					
					tfsource.setVisible(true);
					tfdetay.setVisible(false);
					modelim.setRowCount(0);	
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
			        		    
			     ResultSet rs =st.executeQuery("select tarih,count(fiyat) as \"fiyat\" from orders group by tarih \r\n"
			     		+ "order by  tarih ASC");
			     modelim.setColumnIdentifiers(grup);
			        while(rs.next())
			        {
			        		satirlar[0]=rs.getString("tarih");
			        		satirlar[1]=rs.getInt("fiyat");
			        		
			        		sayi+=rs.getInt("fiyat");
			        	modelim.addRow(satirlar);	
			        	
			        }
			       table.setModel(modelim);
			       lbtop.setText(""+sayi);
			       
			       st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
			}
		});
		btnGrupla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGrupla.setBounds(764, 312, 117, 21);
		contentPane.add(btnGrupla);
		
		JButton btndetay = new JButton("Detaylandır");
		btndetay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {					
					sayi=0;
					lbl.setText("Toplam Sipariş Sayısı");
					tfsource.setText("");					
					tfsource.setVisible(false);
					tfdetay.setVisible(true);
					modelim.setRowCount(0);	
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
			        		    
			     ResultSet rs =st.executeQuery("select*from alinanlar order by  tarih ASC");
			     		
			     modelim.setColumnIdentifiers(detay);
			        while(rs.next())
			        {
			        		satirlar[0]=rs.getString("musteri_no");
			        		satirlar[1]=rs.getInt("masa_numarasi");
			        		satirlar[2]=rs.getInt("sayi");
			        		satirlar[3]=rs.getString("siparisler");
			        		satirlar[4]=rs.getString("tarih");
			        		
			        		
			        	modelim.addRow(satirlar);
			        	sayi++;
			        	
			        }
			       table.setModel(modelim);
			       lbtop.setText(""+sayi);
			       
			       st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
			}
		});
		btndetay.setBounds(766, 351, 115, 23);
		contentPane.add(btndetay);
		
		tfdetay = new JTextField();
		tfdetay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 
					try {
						sayi=0;
						DBConnection conn=new DBConnection();
				        Connection con=conn.connDb();
				        Statement st=con.createStatement();
				    modelim.setRowCount(0);
				     String liste="select * from alinanlar where  tarih LIKE '%"+tfdetay.getText()+"%' ";
				     ResultSet rs =st.executeQuery(liste);
				     modelim.setColumnIdentifiers(detay);
				        while(rs.next())
				        {		        
				        	satirlar[0]=rs.getString("musteri_no");
			        		satirlar[1]=rs.getInt("masa_numarasi");
			        		satirlar[2]=rs.getInt("sayi");
			        		satirlar[3]=rs.getString("siparisler");
			        		satirlar[4]=rs.getString("tarih");			        				        	
				        	modelim.addRow(satirlar);	
				        	sayi+=rs.getInt("sayi");
				        	
				        }
				       table.setModel(modelim);
				       lbtop.setText(""+sayi);
				       st.close();
						}
						catch(SQLException e1) {

				            e1.printStackTrace();
				        }
					
				
			}
		});
		
		tfdetay.setBounds(10, 34, 192, 19);
		contentPane.add(tfdetay);
		tfdetay.setColumns(10);
		
		JButton btnurun = new JButton("Ürün satışları");
		btnurun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {												
					modelim.setRowCount(0);	
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();
			        		    
			     ResultSet rs =st.executeQuery("select siparisler,count(sayi) as 's' from alinanlar group by siparisler order by  tarih ASC");
			     		
			     modelim.setColumnIdentifiers(urungrup);
			        while(rs.next())
			        {
			        		urun[0]=rs.getString("siparisler");
			        		urun[1]=rs.getInt("s");
			        		
			        		
			        		
			        	modelim.addRow(urun);
			        	lbl.setText("");
			        	lbtop.setText("");
			        	
			        }
			       table.setModel(modelim);
			       
			       
			       st.close();
					}
					catch(SQLException e1) {

			            e1.printStackTrace();
			        }
				
			
			}
		});
		btnurun.setBounds(766, 385, 115, 23);
		contentPane.add(btnurun);
		tfdetay.setVisible(false);
		
		
		
	}
}
