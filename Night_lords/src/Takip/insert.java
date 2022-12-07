package Takip;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helpers.DBConnection;

import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class insert extends JFrame {

	private JPanel contentPane;
	private JTextField urunadi;
	private JTextField urunfiyati;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert frame = new insert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int[] id=new int[100];
	DefaultTableModel modelim=new DefaultTableModel();
    Object[] kolonlar= {"Ürün Adı","Fiyatı"};
	Object[] satirlar=new Object[3];
	int sid,indexid=0;
	public insert() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ana_yemekler", "atistirmalik", "bitki_caylari", "dogal_icecekler", "dunya_kahveleri", "frappes", "frozens", "gözlemeler", "kahvaltiliklar", "karisik_kokteyl", "makarnalar", "milkshakes", "pastalar", "salatalar", "sikma_sulari", "sicak_icecekler", "smoothies", "soguk_icecekler", "soguk_kahveler", "tost_cesitleri", "turk_kahveleri", "waffle"}));
		comboBox.setBounds(10, 72, 194, 33);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("KATEGORİ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 47, 184, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFiyat = new JLabel("FİYAT");
		lblFiyat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFiyat.setBounds(537, 47, 184, 14);
		contentPane.add(lblFiyat);
		
		JLabel lblrnAd = new JLabel("ÜRÜN ADI");
		lblrnAd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblrnAd.setBounds(251, 49, 184, 14);
		contentPane.add(lblrnAd);
		
		urunadi = new JTextField();
		urunadi.setBounds(251, 72, 210, 33);
		contentPane.add(urunadi);
		urunadi.setColumns(10);
		
		JButton btnNewButton = new JButton("ÜRÜN EKLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				 try {
						
						DBConnection conn=new DBConnection();
				        Connection con=conn.connDb();
				        Statement st=con.createStatement();		        		     			        		
				        	
				        	st.executeUpdate("INSERT INTO "+comboBox.getSelectedItem()+"(product_name,product_price)VALUES('"+urunadi.getText()+"','"+Integer.parseInt(urunfiyati.getText())+"')");
				        	JOptionPane.showConfirmDialog(null,"Yeni Ürün Başarıyla Eklendi","Kapat",JOptionPane.CLOSED_OPTION);
	                  }
	                  
	                
	                  catch(SQLException e1) 
					    {
	                	  JOptionPane.showConfirmDialog(null,"Beklenmeyen Bi Hata Oluştu","Kapat",JOptionPane.CLOSED_OPTION);
				            e1.printStackTrace();
				        }	
			}
		});
		btnNewButton.setBounds(10, 116, 161, 33);
		contentPane.add(btnNewButton);
		
		urunfiyati = new JTextField();
		urunfiyati.setColumns(10);
		urunfiyati.setBounds(484, 72, 145, 33);
		contentPane.add(urunfiyati);
		
		JButton btnNewButton_1 = new JButton("Geri Dön");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton_1.setBounds(779, 338, 105, 30);
		contentPane.add(btnNewButton_1);
	     
	      
	}
}
