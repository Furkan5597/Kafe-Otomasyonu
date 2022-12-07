package Takip;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import Helpers.DBConnection;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;

public class price extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					price frame = new price();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	JLabel[] label = new JLabel[15];
	JLabel[] label1 = new JLabel[15];
	JLabel[] label2 = new JLabel[15];
	JLabel[] label3 = new JLabel[15];
	JLabel[] label4 = new JLabel[15];
	JLabel[] label5 = new JLabel[15];
	JLabel[] label6 = new JLabel[15];
	JLabel[] label7 = new JLabel[15];
	JLabel[] label8 = new JLabel[15];
	JLabel[] label9 = new JLabel[15];
	JLabel[] label10 = new JLabel[15];
	JLabel[] label11 = new JLabel[15];
	JLabel[] label12 = new JLabel[15];
	JLabel[] label13 = new JLabel[15];
	JLabel[] label14 = new JLabel[15];
	JLabel[] label15 = new JLabel[15];
	JLabel[] label16 = new JLabel[20];
	JLabel[] label17 = new JLabel[15];
	JLabel[] label18 = new JLabel[15];
	JLabel[] label19 = new JLabel[15];
	JLabel[] label20 = new JLabel[15];
	JLabel[] label21 = new JLabel[15];
	JLabel[] label22 = new JLabel[20];
	JSpinner[] spinner = new JSpinner[15];
	JSpinner[] spinner1 = new JSpinner[15];
	JSpinner[] spinner2 = new JSpinner[15];
	JSpinner[] spinner3 = new JSpinner[15];
	JSpinner[] spinner4 = new JSpinner[15];
	JSpinner[] spinner5 = new JSpinner[15];
	JSpinner[] spinner6 = new JSpinner[15];
	JSpinner[] spinner7 = new JSpinner[15];
	JSpinner[] spinner8 = new JSpinner[15];
	JSpinner[] spinner9 = new JSpinner[15];
	JSpinner[] spinner10 = new JSpinner[15];
	JSpinner[] spinner11= new JSpinner[15];
	JSpinner[] spinner12= new JSpinner[15];
	JSpinner[] spinner13 = new JSpinner[15];
	JSpinner[] spinner14= new JSpinner[15];
	JSpinner[] spinner15= new JSpinner[15];
	JSpinner[] spinner16= new JSpinner[20];
	JSpinner[] spinner17= new JSpinner[15];
	JSpinner[] spinner18= new JSpinner[15];
	JSpinner[] spinner19= new JSpinner[15];
	JSpinner[] spinner20= new JSpinner[15];
	JSpinner[] spinner21= new JSpinner[15];
	
	
	String[] name=new String[15];
	String[] namet=new String[15];
	String[] nameay=new String[20];
	String[] nameat=new String[20];
	String[] namebc=new String[20];
	String[] namedi=new String[15];
	String[] namedk=new String[15];
	String[] namef=new String[15];
	String[] namefr=new String[15];
	String[] nameg=new String[15];
	String[] namek=new String[15];
	String[] namekk=new String[15];
	String[] namem=new String[15];
	String[] namems=new String[15];
	String[] namep=new String[15];
	String[] names=new String[15];
	String[] namesm=new String[15];
	String[] namesi=new String[20];
	String[] namesk=new String[15];
	String[] namehi=new String[15];
	String[] namesu=new String[15];
	String[] nametk=new String[15];
	String[] namew=new String[15];
	
	
	float[] price=new float[15];
	float[] pricet=new float[15];
	float[] priceat=new float[15];
	float[] pricebc=new float[20];
	float[] pricedi=new float[15];
	float[] pricedk=new float[15];
	float[] pricef=new float[15];
	float[] pricefr=new float[15];
	float[] priceg=new float[15];
	float[] pricek=new float[15];
	float[] pricekk=new float[15];
	float[] pricem=new float[15];
	float[] pricems=new float[15];
	float[] priceay=new float[20];
	float[] pricep=new float[15];
	float[] prices=new float[15];
	float[] pricesm=new float[15];
	float[] pricesi=new float[20];
	int[] stok=new int[20];
	int[] tut=new int[20];
	float[] pricesk=new float[15];
	float[] pricehi=new float[15];
	float[] pricesu=new float[15];
	float[] pricetk=new float[15];
	float[] pricew=new float[15];
	
	int index=0,indext=0,musteri_no,indexay=0,indexat,indexbc,indexdi,indexdk,indexf,indexfr,indexg,indexk,indexkk,indexm,indexms,indexp,indexs,indexsm,indexsi,indexsk,indexhi,indexsu,indextk,indexw;
		int ct=0;	
	float topt,topk,toplam,tutar,topan,topat,topb,topd,topdk,topf,topfr,topg,topkk,topm,topmi,topp,tops,topsm,topsi,topsk,tophi,topsu,toptk,topw;
    int[] fis=new int[1];
	String[] siparis=new String[1];
	String tarih;
	public price() {
		setTitle("Fiyat Güncelle");
		
		
		
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from waffle ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexw++;	
	            namew[indexw-1]=rs.getString("product_name");
	            pricew[indexw-1]=rs.getFloat("product_price");
	            
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from turk_kahveleri ");
	      
	        while(rs.next()) 
	        {	        	
	        	indextk++;	
	            nametk[indextk-1]=rs.getString("product_name");
	            pricetk[indextk-1]=rs.getFloat("product_price");
	            
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from sikma_sulari ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexsu++;	
	            namesu[indexsu-1]=rs.getString("product_name");
	            pricesu[indexsu-1]=rs.getFloat("product_price");
	            
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from sicak_icecekler ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexhi++;	
	            namehi[indexhi-1]=rs.getString("product_name");
	            pricehi[indexhi-1]=rs.getFloat("product_price");
	            
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from soguk_kahveler ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexsk++;	
	            namesk[indexsk-1]=rs.getString("product_name");
	            pricesk[indexsk-1]=rs.getFloat("product_price");
	            
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from soguk_icecekler ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexsi++;	
	            namesi[indexsi-1]=rs.getString("product_name");
	            pricesi[indexsi-1]=rs.getFloat("product_price");
	            stok[indexsi-1]=rs.getInt("number_of_pieces");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from smoothies ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexsm++;	
	            namesm[indexsm-1]=rs.getString("product_name");
	            pricesm[indexsm-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from salatalar ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexs++;	
	            names[indexs-1]=rs.getString("product_name");
	            prices[indexs-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from pastalar ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexp++;	
	            namep[indexp-1]=rs.getString("product_name");
	            pricep[indexp-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from milkshakes ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexms++;	
	            namems[indexms-1]=rs.getString("product_name");
	            pricems[indexms-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from makarnalar ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexm++;	
	            namem[indexm-1]=rs.getString("product_name");
	            pricem[indexm-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from karisik_kokteyl ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexkk++;	
	            namekk[indexkk-1]=rs.getString("product_name");
	            pricekk[indexkk-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		
		
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from gözlemeler ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexg++;	
	            nameg[indexg-1]=rs.getString("product_name");
	            priceg[indexg-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from frozens ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexfr++;	
	            namefr[indexfr-1]=rs.getString("product_name");
	            pricefr[indexfr-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from frappes ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexf++;	
	            namef[indexf-1]=rs.getString("product_name");
	            pricef[indexf-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from dunya_kahveleri ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexdk++;	
	            namedk[indexdk-1]=rs.getString("product_name");
	            pricedk[indexdk-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from dogal_icecekler ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexdi++;	
	            namedi[indexdi-1]=rs.getString("product_name");
	            pricedi[indexdi-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from bitki_caylari ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexbc++;	
	            namebc[indexbc-1]=rs.getString("product_name");
	            pricebc[indexbc-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from atistirmalik ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexat++;	
	            nameat[indexat-1]=rs.getString("product_name");
	            priceat[indexat-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from ana_yemekler ");
	      
	        while(rs.next()) 
	        {	        	
	        	indexay++;	
	            nameay[indexay-1]=rs.getString("product_name");
	            priceay[indexay-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-1, -1, 1368,768 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(-1, -1, 1368, 660);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		tabbedPane.addTab("Tost Çeşitleri", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		tabbedPane.addTab("Ana Yemekler", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		tabbedPane.addTab("Atıştırmalıklar", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.PINK);
		tabbedPane.addTab("Bitki Çayları", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.PINK);
		tabbedPane.addTab("Doğal İçecekler", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.PINK);
		tabbedPane.addTab("Dünya Kahveleri", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.PINK);
		tabbedPane.addTab("Frappes", null, panel_7, null);
		panel_7.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.PINK);
		tabbedPane.addTab("Frozens", null, panel_8, null);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.PINK);
		tabbedPane.addTab("Gözlemeler", null, panel_9, null);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.PINK);
		tabbedPane.addTab("Karışık Kokteyl", null, panel_10, null);
		panel_10.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.PINK);
		tabbedPane.addTab("Makarnalar", null, panel_11, null);
		panel_11.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.PINK);
		tabbedPane.addTab("Milkshakes", null, panel_12, null);
		panel_12.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		tabbedPane.addTab("Kahvaltılıklar", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.PINK);
		tabbedPane.addTab("Pastalar", null, panel_13, null);
		panel_13.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.PINK);
		tabbedPane.addTab("Salatalar", null, panel_14, null);
		panel_14.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.PINK);
		tabbedPane.addTab("Smoothıes", null, panel_15, null);
		panel_15.setLayout(null);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.PINK);
		tabbedPane.addTab("Soğuk İçecekler", null, panel_16, null);
		panel_16.setLayout(null);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.PINK);
		tabbedPane.addTab("Soğuk Kahveler", null, panel_17, null);
		panel_17.setLayout(null);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.PINK);
		tabbedPane.addTab("Sıcak İçecekler", null, panel_18, null);
		panel_18.setLayout(null);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.PINK);
		tabbedPane.addTab("Sıkma M.suları", null, panel_19, null);
		panel_19.setLayout(null);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.PINK);
		tabbedPane.addTab("Türk Kahveleri", null, panel_20, null);
		panel_20.setLayout(null);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.PINK);
		tabbedPane.addTab("Waffle", null, panel_21, null);
		panel_21.setLayout(null);
				
	
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from kahvaltiliklar ");
	      
	        while(rs.next()) 
	        {	        	index++;
	        	
	        	
	            name[index-1]=rs.getString("product_name");
	            price[index-1]=rs.getFloat("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		int x=10,y=109;
		int a=190,b=109;
		for (int i = 0; i <index ; i++) 
		{		
			
		    label[i] = new JLabel("");
		    label[i].setText(name[i]+"  "+"Fiyatı"+"  "+price[i]+" TL");
		    label[i].setBounds(x, y, 250, 24);		    
		    panel.add( label[i]);
		    spinner[i] = new JSpinner();
	    	spinner[i].setBounds(a, b, 55, 40);
	    	spinner[i].setValue(price[i]);
	    	panel.add(spinner[i]);
		    
		    x+=400;
		    if(x>700)
		    {
		    	x=10;
		    	y+=110;
		    		
		    }
		      		  	    	
		    	a+=400;		
		    	if(a>700)
		    	 {
		    	 a=190;
		    	 b+=110;
		    	    		    		
		    	 }   	       
		    	       
		    
		    
		}
		
		try {
			DBConnection conn=new DBConnection();
	        Connection con=conn.connDb();
	        Statement st=con.createStatement();			       	        
	        ResultSet rs =st.executeQuery("select*from tost_cesitleri ");
	      
	        while(rs.next()) 
	        {
	        	indext++;
	        	
	        	
	            namet[indext-1]=rs.getString("product_name");
	            pricet[indext-1]=rs.getInt("product_price");
	            
	        }
	        rs.close();
			}
			catch(SQLException e1) {

	            e1.printStackTrace();
	        }
		int r=10,t=109;
		int tx=190,ty=109;
		for (int i = 0; i <indext ; i++) 
		{		
			
		    label1[i] = new JLabel("");
		    label1[i].setText(namet[i]);
		    label1[i].setBounds(r, t, 250, 24);		    
		    panel_1.add( label1[i]);
		    spinner1[i] = new JSpinner();
	    	spinner1[i].setBounds(tx, ty, 55, 40);		    
	    	panel_1.add(spinner1[i]);
		    spinner1[i].setValue(pricet[i]);
		    r+=400;
		    if(r>700)
		    {
		    	r=10;
		    	t+=110;
		    		
		    }
		    
			tx+=400;		
	    	if(tx>700)
	    	 {
	    	 tx=190;
	    	 ty+=110;
	    	    		    		
	    	 }   
		    
		}
		
		int ayx=10,ayy=109;
		int asx=220,asy=109;
		for(int i=0; i<indexay; i++)
		{
			label2[i] = new JLabel("");
		    label2[i].setText(nameay[i]);
		    label2[i].setBounds(ayx,ayy , 250, 24);		    
		    panel_2.add( label2[i]);
		    spinner2[i] = new JSpinner();
	    	spinner2[i].setBounds(asx, asy, 55, 40);
	    	
	    	panel_2.add(spinner2[i]);
	    	 spinner2[i].setValue(priceay[i]);
		    ayx+=300;
		    if(ayx>900)
		    {
		    	ayx=10;
		    	ayy+=110;
		    		
		    }
		    asx+=300;		
	    	if(asx>900)
	    	 {
	    	 asx=220;
	    	 asy+=110;
	    	    		    		
	    	 }   
		    
		}
		
		int atx=10,aty=109;
		int atsx=250,atsy=109;
		for (int i = 0; i <indexat ; i++) 
		{		
			
		    label3[i] = new JLabel("");
		    label3[i].setText(nameat[i]);
		    label3[i].setBounds(atx, aty, 250, 24);		    
		    panel_3.add( label3[i]);
		    spinner3[i] = new JSpinner();
	    	spinner3[i].setBounds(atsx, atsy, 55, 40);
	    	
	    	panel_3.add(spinner3[i]);
	    	 spinner3[i].setValue(priceat[i]);
		    
		    atx+=400;
		    if(atx>700)
		    {
		    	atx=10;
		    	aty+=110;
		    		
		    }
		    
			atsx+=410;		
	    	if(atsx>700)
	    	 {
	    	 atsx=200;
	    	 atsy+=110;
	    	    		    		
	    	 }   
		    
		}
		
		int bcx=10,bcy=109;
		int bcsx=200,bcsy=109;
		for (int i = 0; i <indexbc ; i++) 
		{		
			
		    label4[i] = new JLabel("");
		    label4[i].setText(namebc[i]);
		    label4[i].setBounds(bcx, bcy, 250, 24);		    
		    panel_4.add( label4[i]);
		    spinner4[i] = new JSpinner();
	    	spinner4[i].setBounds(bcsx, bcsy, 55, 40);
	    	
	    	panel_4.add(spinner4[i]);
	    	 spinner4[i].setValue(pricebc[i]);
		    
		    bcx+=410;
		    if(bcx>900)
		    {
		    	bcx=10;
		    	bcy+=110;
		    		
		    }
		    
			bcsx+=400;		
	    	if(bcsx>1200)
	    	 {
	    	 bcsx=200;
	    	 bcsy+=110;
	    	    		    		
	    	 }   
		    
		}
		
		int dix=10,diy=109;
		int disx=200,disy=109;
		for (int i = 0; i <indexdi ; i++) 
		{		
			
		    label5[i] = new JLabel("");
		    label5[i].setText(namedi[i]);
		    label5[i].setBounds(dix, diy, 250, 24);		    
		    panel_5.add( label5[i]);
		    spinner5[i] = new JSpinner();
	    	spinner5[i].setBounds(disx, disy, 55, 40);
	    	
	    	panel_5.add(spinner5[i]);
	    	 spinner5[i].setValue(pricedi[i]);
		    
		    dix+=410;
		    if(dix>900)
		    {
		    	dix=10;
		    	diy+=110;
		    		
		    }
		    
			disx+=400;		
	    	if(disx>1200)
	    	 {
	    	 disx=200;
	    	 disy+=110;
	    	    		    		
	    	 }   
		    
		}
		
		int dkx=10,dky=109;
		int dksx=200,dksy=109;
		for (int i = 0; i <indexdk ; i++) 
		{		
			
		    label6[i] = new JLabel("");
		    label6[i].setText(namedk[i]);
		    label6[i].setBounds(dkx, dky, 250, 24);		    
		    panel_6.add( label6[i]);
		    spinner6[i] = new JSpinner();
	    	spinner6[i].setBounds(dksx, dksy, 55, 40);
	    	
	    	panel_6.add(spinner6[i]);
	    	 spinner6[i].setValue(pricedk[i]);
		    
		    dkx+=410;
		    if(dkx>900)
		    {
		    	dkx=10;
		    	dky+=110;
		    		
		    }
		    
			dksx+=470;		
	    	if(dksx>1200)
	    	 {
	    	 dksx=200;
	    	 dksy+=110;
	    	    		    		
	    	 }   
		    
		}
		
		int fx=10,fy=109;
		int fsx=150,fsy=105;
		for (int i = 0; i <indexf ; i++) 
		{		
			
		    label7[i] = new JLabel("");
		    label7[i].setText(namef[i]);
		    label7[i].setBounds(fx, fy, 250, 24);		    
		    panel_7.add( label7[i]);
		    spinner7[i] = new JSpinner();
	    	spinner7[i].setBounds(fsx, fsy, 55, 40);
	    	
	    	panel_7.add(spinner7[i]);
	    	 spinner7[i].setValue(pricef[i]);
		    
		    fx+=300;
		    if(fx>900)
		    {
		    	fx=10;
		    	fy+=110;
		    		
		    }
		    
			fsx+=300;		
	    	if(fsx>900)
	    	 {
	    	 fsx=150;
	    	 fsy+=109;
	    	    		    		
	    	 }   
		    
		}
		
		int frx=10,fry=109;
		int frsx=140,frsy=105;
		for (int i = 0; i <indexfr ; i++) 
		{		
			
		    label8[i] = new JLabel("");
		    label8[i].setText(namefr[i]);
		    label8[i].setBounds(frx, fry, 250, 24);		    
		    panel_8.add( label8[i]);
		    spinner8[i] = new JSpinner();
	    	spinner8[i].setBounds(frsx, frsy, 55, 40);
	    	
	    	panel_8.add(spinner8[i]);
	    	 spinner8[i].setValue(pricefr[i]);
	    	
		    frx+=410;
		    if(frx>900)
		    {
		    	frx=10;
		    	fry+=110;
		    		
		    }
		    
			frsx+=400;		
	    	if(frsx>1200)
	    	 {
	    	 frsx=140;
	    	 frsy+=110;
	    	    		    		
	    	 }   
		    
		}
		
		
		int gx=10,gy=109;
		int gsx=250,gsy=105;
		for (int i = 0; i <indexg ; i++) 
		{		
			
		    label9[i] = new JLabel("");
		    label9[i].setText(nameg[i]);
		    label9[i].setBounds(gx, gy, 250, 24);		    
		    panel_9.add( label9[i]);
		    spinner9[i] = new JSpinner();
	    	spinner9[i].setBounds(gsx, gsy, 55, 40);
	    	
	    	panel_9.add(spinner9[i]);
	    	 spinner9[i].setValue(priceg[i]);
	    	 
		    gx+=410;
		    if(gx>900)
		    {
		    	gx=10;
		    	gy+=110;
		    		
		    }
		    
			gsx+=410;		
	    	if(gsx>1200)
	    	 {
	    	 gsx=250;
	    	 gsy+=110;
	    	    		    		
	    	 }   
		    
		}
		
		int kkx=10,kky=109;
		int kksx=160,kksy=105;
		for (int i = 0; i <indexkk ; i++) 
		{		
			
		    label10[i] = new JLabel("");
		    label10[i].setText(namekk[i]);
		    label10[i].setBounds(kkx, kky, 250, 24);		    
		    panel_10.add( label10[i]);
		    spinner10[i] = new JSpinner();
	    	spinner10[i].setBounds(kksx, kksy, 55, 40);
	    	
	    	panel_10.add(spinner10[i]);
	    	 spinner10[i].setValue(pricekk[i]);
	    	 
		    kkx+=310;
		    if(kkx>900)
		    {
		    	kkx=10;
		    	kky+=110;
		    		
		    }
		    
			kksx+=330;		
	    	if(kksx>900)
	    	 {
	    	 kksx=180;
	    	 kksy+=110;
	    	    		    		
	    	 }   
		    
		}
		
		int mx=10,my=109;
		int msx=200,msy=105;
		for (int i = 0; i <indexm ; i++) 
		{		
			
		    label11[i] = new JLabel("");
		    label11[i].setText(namem[i]);
		    label11[i].setBounds(mx, my, 250, 24);		    
		    panel_11.add( label11[i]);
		    spinner11[i] = new JSpinner();
	    	spinner11[i].setBounds(msx, msy, 55, 40);
	    	
	    	panel_11.add(spinner11[i]);
	    	 spinner11[i].setValue(pricem[i]);
	    	 
		    mx+=330;
		    if(mx>900)
		    {
		    	mx=10;
		    	my+=110;
		    		
		    }
		    
			msx+=350;		
	    	if(msx>900)
	    	 {
	    	 msx=200;
	    	 msy+=110;
	    	    		    		
	    	 }   
		    
		}
		
		int msxx=10,msyy=109;
		int mssx=150,mssy=105;
		for (int i = 0; i <indexms ; i++) 
		{		
			
		    label12[i] = new JLabel("");
		    label12[i].setText(namems[i]);
		    label12[i].setBounds(msxx, msyy, 250, 24);		    
		    panel_12.add( label12[i]);
		    spinner12[i] = new JSpinner();
	    	spinner12[i].setBounds(mssx, mssy, 55, 40);
	    	
	    	panel_12.add(spinner12[i]);
	    	 spinner12[i].setValue(pricems[i]);
	    	 
		    msxx+=400;
		    if(msxx>700)
		    {
		    	msxx=10;
		    	msyy+=110;
		    		
		    }
		    
			mssx+=400;		
	    	if(mssx>700)
	    	 {
	    	 mssx=150;
	    	 mssy+=105;
	    	    		    		
	    	 }   
		    
		}
		
		int px=10,py=109;
		int psx=215,psy=109;
		for (int i = 0; i <indexp ; i++) 
		{		
			
		    label13[i] = new JLabel("");
		    label13[i].setText(namep[i]);
		    label13[i].setBounds(px, py, 250, 24);		    
		    panel_13.add( label13[i]);
		    spinner13[i] = new JSpinner();
	    	spinner13[i].setBounds(psx, psy, 55, 40);
	    
	    	panel_13.add(spinner13[i]);
	    	 spinner13[i].setValue(pricep[i]);
	    	 
		    px+=400;
		    if(px>900)
		    {
		    	px=10;
		    	py+=110;
		    		
		    }
		    
		    psx+=400;		
	    	if(psx>1200)
	    	 {
	    	 psx=215;
	    	 psy+=105;
	    	    		    		
	    	 }   
		    
		}
		
		int sx=10,sy=109;
		int ssx=170,ssy=105;
		for (int i = 0; i <indexs ; i++) 
		{		
			
		    label14[i] = new JLabel("");
		    label14[i].setText(names[i]);
		    label14[i].setBounds(sx, sy, 250, 24);		    
		    panel_14.add( label14[i]);
		    spinner14[i] = new JSpinner();
	    	spinner14[i].setBounds(ssx, ssy, 55, 40);
	    	
	    	panel_14.add(spinner14[i]);
	    	 spinner14[i].setValue(prices[i]);
	    	 
		    sx+=400;
		    if(sx>700)
		    {
		    	sx=10;
		    	sy+=110;
		    		
		    }
		    
			ssx+=420;		
	    	if(ssx>700)
	    	 {
	    	 ssx=170;
	    	 ssy+=105;
	    	    		    		
	    	 }   
		    
		}
		int smx=10,smy=109;
		int smsx=150,smsy=105;
		for (int i = 0; i <indexsm ; i++) 
		{		
			
		    label15[i] = new JLabel("");
		    label15[i].setText(namesm[i]);
		    label15[i].setBounds(smx, smy, 250, 24);		    
		    panel_15.add( label15[i]);
		    spinner15[i] = new JSpinner();
	    	spinner15[i].setBounds(smsx, smsy, 55, 40);
	    	
	    	panel_15.add(spinner15[i]);
	    	 spinner15[i].setValue(pricesm[i]);
	    	 
		    smx+=400;
		    if(smx>700)
		    {
		    	smx=10;
		    	smy+=110;
		    		
		    }
		    
			smsx+=400;		
	    	if(smsx>700)
	    	 {
	    	 smsx=150;
	    	 smsy+=105;
	    	    		    		
	    	 }   
		    
		}
		
		int six=10,siy=10;
		int sisx=200,sisy=10;
		int stokx=260,stoky=10;
		for (int i = 0; i <indexsi ; i++) 
		{		
			
		    label16[i] = new JLabel("");
		    label16[i].setText(namesi[i]);
		    label16[i].setBounds(six, siy, 250, 24);		    
		    panel_16.add( label16[i]);
		    spinner16[i] = new JSpinner();
	    	spinner16[i].setBounds(sisx, sisy, 55, 40);
	    	
	    	panel_16.add(spinner16[i]);
	    	label22[i] = new JLabel("");
		    label22[i].setText("Stokta "+" "+stok[i]);
		    label22[i].setBounds(stokx, stoky, 250, 24);		    
		    panel_16.add( label22[i]);
		    spinner16[i].setValue(pricesi[i]);
		    
		    six+=420;
		    if(six>1200)
		    {
		    	six=10;
		    	siy+=80;
		    		
		    }
		    stokx+=450;
		    if(stokx>1200)
		    {
		    	stokx=260;
		    	stoky+=80;
		    		
		    }
		    
			sisx+=420;		
	    	if(sisx>1200)
	    	 {
	    	 sisx=200;
	    	 sisy+=80;
	    	    		    		
	    	 }   
		    
		}
		
		int skx=10,sky=109;
		int sksx=180,sksy=105;
		for (int i = 0; i <indexsk ; i++) 
		{		
			
		    label17[i] = new JLabel("");
		    label17[i].setText(namesk[i]);
		    label17[i].setBounds(skx, sky, 250, 24);		    
		    panel_17.add( label17[i]);
		    spinner17[i] = new JSpinner();
	    	spinner17[i].setBounds(sksx, sksy, 55, 40);
	    	
	    	panel_17.add(spinner17[i]);
	        spinner17[i].setValue(pricesk[i]);
	    	 
		    skx+=400;
		    if(skx>700)
		    {
		    	skx=10;
		    	sky+=110;
		    		
		    }
		    
			sksx+=420;		
	    	if(sksx>700)
	    	 {
	    	 sksx=180;
	    	 sksy+=105;
	    	    		    		
	    	 }   
		    
		}
		
		int hix=10,hiy=109;
		int hisx=250,hisy=105;
		for (int i = 0; i <indexhi ; i++) 
		{		
			
		    label18[i] = new JLabel("");
		    label18[i].setText(namehi[i]);
		    label18[i].setBounds(hix, hiy, 250, 24);		    
		    panel_18.add( label18[i]);
		    spinner18[i] = new JSpinner();
	    	spinner18[i].setBounds(hisx, hisy, 55, 40);
	    	
	    	panel_18.add(spinner18[i]);
	    	 spinner18[i].setValue(pricehi[i]);
	    	 
		    hix+=400;
		    if(hix>700)
		    {
		    	hix=10;
		    	hiy+=110;
		    		
		    }
		    
			hisx+=420;		
	    	if(hisx>700)
	    	 {
	    	 hisx=250;
	    	 hisy+=109;
	    	    		    		
	    	 }   
		    
		}
		
		int sux=10,suy=109;
		int susx=220,susy=105;
		for (int i = 0; i <indexsu ; i++) 
		{		
			
		    label19[i] = new JLabel("");
		    label19[i].setText(namesu[i]);
		    label19[i].setBounds(sux, suy, 250, 24);		    
		    panel_19.add( label19[i]);
		    spinner19[i] = new JSpinner();
	    	spinner19[i].setBounds(susx, susy, 55, 40);	    	
	    	panel_19.add(spinner19[i]);
	    	 spinner19[i].setValue(pricesu[i]);
	    	 
		    sux+=400;
		    if(sux>700)
		    {
		    	sux=10;
		    	suy+=110;
		    		
		    }
		    
			susx+=380;		
	    	if(susx>700)
	    	 {
	    	 susx=220;
	    	 susy+=105;
	    	    		    		
	    	 }   
		    
		}
		
		int tkx=10,tky=109;
		int tksx=250,tksy=105;
		for (int i = 0; i <indextk ; i++) 
		{		
			
		    label20[i] = new JLabel("");
		    label20[i].setText(nametk[i]);
		    label20[i].setBounds(tkx, tky, 250, 24);		    
		    panel_20.add( label20[i]);
		    spinner20[i] = new JSpinner();
	    	spinner20[i].setBounds(tksx, tksy, 55, 40);
	    	
	    	panel_20.add(spinner20[i]);
	    	 spinner20[i].setValue(pricetk[i]);
		    
		    tkx+=400;
		    if(tkx>700)
		    {
		    	tkx=10;
		    	tky+=110;
		    		
		    }
		    
			tksx+=400;		
	    	if(tksx>700)
	    	 {
	    	 tksx=250;
	    	 tksy+=109;
	    	    		    		
	    	 }   
		    
		}
		int wx=10,wy=109;
		int wsx=200,wsy=105;
		for (int i = 0; i <indexw ; i++) 
		{		
			
		    label21[i] = new JLabel("");
		    label21[i].setText(namew[i]);
		    label21[i].setBounds(wx, wy, 250, 24);		    
		    panel_21.add( label21[i]);
		    spinner21[i] = new JSpinner();
	    	spinner21[i].setBounds(wsx, wsy, 55, 40);
	    	panel_21.add(spinner21[i]);
	    	 spinner21[i].setValue(pricew[i]);
	    	 
		    wx+=400;
		    if(wx>700)
		    {
		    	wx=10;
		    	wy+=110;
		    		
		    }
		    
			wsx+=400;		
	    	if(wsx>700)
	    	 {
	    	 wsx=200;
	    	 wsy+=105;
	    	    		    		
	    	 }   
		    
		}
		
		JButton btnNewButton_3 = new JButton("Masalar");
		btnNewButton_3.setBounds(722, 663, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnguncel = new JButton("Güncelle");
		btnguncel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					DBConnection conn=new DBConnection();
	                 Connection con=conn.connDb();
	                 Statement st=con.createStatement();
	                 for(int i=0; i<index; i++)
	                 {

	                     st.executeUpdate("UPDATE kahvaltiliklar SET product_price="+spinner[i].getValue()+" where product_name='"+name[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indext; i++)
	                 {
	                	 st.executeUpdate("UPDATE tost_cesitleri SET product_price="+spinner1[i].getValue()+" where product_name='"+namet[i]+"'");
	                 }
	                 for(int i=0; i<indexay; i++)
	                 {
	                	 st.executeUpdate("UPDATE ana_yemekler SET product_price="+spinner2[i].getValue()+" where product_name='"+nameay[i]+"'");
	                 }
	                 for(int i=0; i<indexat; i++)
	                 {

	                     st.executeUpdate("UPDATE atistirmalik SET product_price="+spinner3[i].getValue()+" where product_name='"+nameat[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexbc; i++)
	                 {

	                     st.executeUpdate("UPDATE bitki_caylari SET product_price="+spinner4[i].getValue()+" where product_name='"+namebc[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexdi; i++)
	                 {

	                     st.executeUpdate("UPDATE dogal_icecekler SET product_price="+spinner5[i].getValue()+" where product_name='"+namedi[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexdk; i++)
	                 {

	                     st.executeUpdate("UPDATE dunya_kahveleri SET product_price="+spinner6[i].getValue()+" where product_name='"+namedk[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexf; i++)
	                 {

	                     st.executeUpdate("UPDATE frappes SET product_price="+spinner7[i].getValue()+" where product_name='"+namef[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexfr; i++)
	                 {

	                     st.executeUpdate("UPDATE frozens SET product_price="+spinner8[i].getValue()+" where product_name='"+namefr[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexg; i++)
	                 {

	                     st.executeUpdate("UPDATE gözlemeler SET product_price="+spinner9[i].getValue()+" where product_name='"+nameg[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexkk; i++)
	                 {

	                     st.executeUpdate("UPDATE karisik_kokteyl SET product_price="+spinner10[i].getValue()+" where product_name='"+namekk[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexm; i++)
	                 {

	                     st.executeUpdate("UPDATE makarnalar SET product_price="+spinner11[i].getValue()+" where product_name='"+namem[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexms; i++)
	                 {

	                     st.executeUpdate("UPDATE milkshakes SET product_price="+spinner12[i].getValue()+" where product_name='"+namems[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexp; i++)
	                 {

	                     st.executeUpdate("UPDATE pastalar SET product_price="+spinner13[i].getValue()+" where product_name='"+namep[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexs; i++)
	                 {

	                     st.executeUpdate("UPDATE salatalar SET product_price="+spinner14[i].getValue()+" where product_name='"+names[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexsm; i++)
	                 {

	                     st.executeUpdate("UPDATE smoothies SET product_price="+spinner15[i].getValue()+" where product_name='"+namesm[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexsi; i++)
	                 {

	                     st.executeUpdate("UPDATE soguk_icecekler SET product_price="+spinner16[i].getValue()+" where product_name='"+namesi[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexsk; i++)
	                 {

	                     st.executeUpdate("UPDATE soguk_kahveler SET product_price="+spinner17[i].getValue()+" where product_name='"+namesk[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexhi; i++)
	                 {

	                     st.executeUpdate("UPDATE sicak_icecekler SET product_price="+spinner18[i].getValue()+" where product_name='"+namehi[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexsu; i++)
	                 {

	                     st.executeUpdate("UPDATE sikma_sulari SET product_price="+spinner19[i].getValue()+" where product_name='"+namesu[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indextk; i++)
	                 {

	                     st.executeUpdate("UPDATE turk_kahveleri SET product_price="+spinner20[i].getValue()+" where product_name='"+nametk[i]+"'");
	                    	                      
	                 }
	                 for(int i=0; i<indexw; i++)
	                 {

	                     st.executeUpdate("UPDATE waffle SET product_price="+spinner21[i].getValue()+" where product_name='"+namew[i]+"'");
	                    	                      
	                 }
	                 
	                 JOptionPane.showMessageDialog(null, "Değişiklikler Uygulandı!");
	               price f=new price();
	               f.setVisible(true);
	               dispose();                          
	                 }
					
					catch(SQLException e1) {

	                    e1.printStackTrace();
	                }
			}
		});
		btnguncel.setBounds(1093, 663, 89, 23);
		contentPane.add(btnguncel);
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Night_Lords_Takip f0=new Night_Lords_Takip();
				f0.setVisible(true);
				dispose();
			}
		});
	}
}

