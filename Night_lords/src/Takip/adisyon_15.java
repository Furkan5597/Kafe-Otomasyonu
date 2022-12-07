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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adisyon_15 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adisyon_15 frame = new adisyon_15();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public float top,tut=0,kalan;
	int[] id=new int[100];
	DefaultTableModel modelim=new DefaultTableModel();
	DefaultTableModel modelim_1=new DefaultTableModel();
    Object[] kolonlar= {"Müşteri Numarası","Masa Numarası","Siparişler","Sayı","Fiyat","Tarih"};
	Object[] satirlar=new Object[6];
	Object[] satirlar_1=new Object[6];	
	int musteri_no,indexid,sid;
	String tarih;
	private JTable table_1;
	public adisyon_15() {
		setTitle("Masa 15 Adisyon");
	
		
		
		
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select musteri_no,tarih from tables where table_id='15' ");
	      
	        while(rs.next()) 
	        {	        	
	        musteri_no=rs.getInt("musteri_no");
	            tarih=rs.getString("tarih");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblödenecek = new JLabel("Ödenecek Tutar:");
		lblödenecek.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblödenecek.setBounds(20, 541, 168, 13);
		contentPane.add(lblödenecek);
		
		JLabel lblNewLabel = new JLabel("Ödenenler");
		lblNewLabel.setBounds(10, 259, 122, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ödenecekler");
		lblNewLabel_1.setBounds(10, 11, 132, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblödenen = new JLabel("Ödenen Tutar:");
		lblödenen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblödenen.setBounds(20, 516, 168, 14);
		contentPane.add(lblödenen);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 928, 211);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {														
			modelim.setRowCount(0);	
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();
	        		    
	     ResultSet rs =st.executeQuery("select * from siparis_detay where (masa_numarasi='15') AND (musteri_no='"+musteri_no+"') ");
	     modelim.setColumnIdentifiers(kolonlar);
	        while(rs.next())
	        {
	        	tut=rs.getInt("sayi")*rs.getFloat("product_price");
	        	satirlar[0]=rs.getInt("musteri_no");
	        	satirlar[1]=rs.getInt("masa_numarasi");
	        	satirlar[2]=rs.getString("siparisler");
	        	satirlar[3]=rs.getInt("sayi");
	        	satirlar[4]=tut;
	        	satirlar[5]=rs.getString("tarih");
	        	id[indexid]=rs.getInt("id");
	        	indexid++;
	        			top+=rs.getFloat("product_price");        
	        	modelim.addRow(satirlar);	
	        	lblödenecek.setText("Ödenecek Tutar:"+" "+top+"TL");
	        }
	       table.setModel(modelim);
	      
	       st.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		
		JButton btnNewButton = new JButton("Satış Yap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cevap=JOptionPane.showConfirmDialog(null,"Masanın Hesabını Kapatmak istiyor musunuz ?","Kapat",JOptionPane.YES_NO_OPTION);
				if(cevap==0)
				{
					if(table.getRowCount()==0)
		        	{
                  try {
					
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();		        		     			        
			        	
			        if(kalan>0)
			        {
			           st.executeUpdate("Update tables SET  price='0' where table_id='15' ");
			        	
			        	
			        	st.executeUpdate("INSERT INTO orders(tarih,fiyat,masa_numarasi,musteri_no)VALUES('"+tarih+"','"+kalan+"','15','"+musteri_no+"')");
			        	st.executeUpdate("Delete from siparis_detay where musteri_no='"+musteri_no+"' ");
			        	musteri_no++;
			        	st.executeUpdate("Update tables SET  musteri_no='"+musteri_no+"' where table_id='15' ");
			        	
			        }			        
			        	
                  }
                  
                
                  catch(SQLException e1) 
				    {

			            e1.printStackTrace();
			        }	
                  Night_Lords_Takip fm=new Night_Lords_Takip();
           		fm.setVisible(true);
				dispose();
                  }
                  else
                  {
                	  JOptionPane.showConfirmDialog(null,"Ödemesi Yapılmamış Ürünler Var ?","Kapat",JOptionPane.CLOSED_OPTION);
                	  adisyon_15 f=new adisyon_15();
                	  f.setVisible(true);
                	  dispose();
                  }
                 		
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(863, 550, 96, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXİT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Night_Lords_Takip fm=new Night_Lords_Takip();
         		fm.setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setBounds(863, 519, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
		JButton btnsil = new JButton("Sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sid=table.getSelectedRow();
				if(sid>-1)
				{
				
				   try {
					
						DBConnection conn=new DBConnection();
				        Connection con=conn.connDb();
				        Statement st=con.createStatement();		        		     			        				       
				        	
				        st.executeUpdate("Delete from siparis_detay where id='"+id[sid]+"' ");
				        	
				        adisyon_15 f1=new adisyon_15();
						f1.setVisible(true);
						dispose();
						}			        
				        	
	                  
	                  catch(SQLException e1) 
					    {

				            e1.printStackTrace();
				        }
				}
				else
				{
					JOptionPane.showConfirmDialog(null,"Lütfen İşlem Yapılacak Ürünü Seçin ?","Kapat",JOptionPane.YES_NO_OPTION);
				}
			   
				
			}
		});
		btnsil.setBounds(739, 519, 89, 23);
		contentPane.add(btnsil);
		
		JButton btnekle = new JButton("Öde");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sid=table.getSelectedRow();
				if(sid>-1)
				{
				 try {
					 sid=table.getSelectedRow();
						DBConnection conn=new DBConnection();
				        Connection con=conn.connDb();
				        Statement st=con.createStatement();		        		     			        
				        
				        	
				        		st.executeUpdate("INSERT INTO alinanlar(id,sayi,product_price,siparisler,tarih,masa_numarasi,musteri_no) SELECT id,sayi,product_price,siparisler,tarih,masa_numarasi,musteri_no FROM siparis_detay where id='"+id[sid]+"' ");
				        		st.executeUpdate("Delete from siparis_detay where id='"+id[sid]+"' ");
				        		 adisyon_15 f1=new adisyon_15();
								 f1.setVisible(true);
								 dispose();
				        				        
				        	
	                  }
	                  catch(SQLException e1) 
					    {

				            e1.printStackTrace();
				        }	
				}
				 else
					{
						JOptionPane.showConfirmDialog(null,"Lütfen İşlem Yapılacak Ürünü Seçin ?","Kapat",JOptionPane.YES_NO_OPTION);
					}

				
			}
		});
		btnekle.setBounds(739, 553, 89, 23);
		contentPane.add(btnekle);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 286, 928, 211);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		try {														
			modelim_1.setRowCount(0);	
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();
	        		    
	     ResultSet rs =st.executeQuery("select * from alinanlar where (masa_numarasi='15') AND (musteri_no='"+musteri_no+"') ");
	     modelim_1.setColumnIdentifiers(kolonlar);
	        while(rs.next())
	        {
	        	tut=rs.getInt("sayi")*rs.getFloat("product_price");
	        	satirlar_1[0]=rs.getInt("musteri_no");
	        	satirlar_1[1]=rs.getInt("masa_numarasi");
	        	satirlar_1[2]=rs.getString("siparisler");
	        	satirlar_1[3]=rs.getInt("sayi");
	        	satirlar_1[4]=tut;
	        	satirlar_1[5]=rs.getString("tarih");
	        	        kalan+=rs.getFloat("product_price");				        
	        	modelim_1.addRow(satirlar_1);	
	        	lblödenen.setText("Ödenen Tutar:"+" "+kalan);
	        }
	       table_1.setModel(modelim_1);
	       
	       JButton btnNewButton_2 = new JButton("Tümünü Öde");
	       btnNewButton_2.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		
	       	 try {
				 sid=table.getSelectedRow();
					DBConnection conn=new DBConnection();
			        Connection con=conn.connDb();
			        Statement st=con.createStatement();		        		     			        
			        	
			        
			        	
			        	
			        		st.executeUpdate("INSERT INTO alinanlar(id,sayi,product_price,siparisler,tarih,masa_numarasi,musteri_no) SELECT id,sayi,product_price,siparisler,tarih,masa_numarasi,musteri_no FROM siparis_detay where musteri_no='"+musteri_no+"' ");
			        		st.executeUpdate("Delete from siparis_detay where musteri_no='"+musteri_no+"' ");
			        		 adisyon_15 f1=new adisyon_15();
							 f1.setVisible(true);
							 dispose();
			        				        
			        	
                  }
                  catch(SQLException e1) 
				    {

			            e1.printStackTrace();
			        }	
	       	}
	       });
	       btnNewButton_2.setBounds(592, 553, 117, 23);
	       contentPane.add(btnNewButton_2);
	      
	       st.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		
	
		
	
		
		
		
	}
}
