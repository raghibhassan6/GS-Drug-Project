package Databases;



import java.sql.*;
import javax.swing.JOptionPane;
import GUI.Registration;


public class dbconnect {

    public static Statement st;
    public static Connection c;
    public static PreparedStatement information,ps2,Ptransaction,maxcid,updateclient,psviewclient,checkProName,addproduct,updateproduct,newproduct,psviewtable,finalproduct,productlist;

    static {


        try {
             Class.forName("oracle.jdbc.driver.OracleDriver");
             c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gsdrugs","gss123");
            st = c.createStatement();
            information=c.prepareStatement("insert into clientinfor(name,gender,dob,mob,email,address)values(?,?,?,?,?,?)");
            ps2=c.prepareStatement("select * from clientinfor where name like ?");
            Ptransaction=c.prepareStatement("update Ptransaction "+" set pname=?,numbers=? "+" where ");
            maxcid=c.prepareStatement("select max(cid) from clientinfor");
            psviewclient =c.prepareStatement("select * from TRANSACTION where cid=?");
            addproduct=c.prepareStatement("insert into TRANSACTION(cid,dates,PRODUCT_NAME,pnumbers)values(?,?,?,?)");
            checkProName=c.prepareStatement("select * from PRODUCT_LIST where PRODUCT_NAME=?");
            psviewtable =c.prepareStatement("select * from TRANSACTION where cid=?");
             productlist=c.prepareStatement("select * from " + "PRODUCT_LIST where PRODUCT_NAME like ?");
             finalproduct=c.prepareStatement("select * from TRANSACTION where cid=? and dates=?");
             newproduct=c.prepareStatement("insert into PRODUCT_LIST(PRODUCT_NAME,NUMBERS)values(?,?)");
             updateproduct=c.prepareStatement("update PRODUCT_LIST  set NUMBERS=? where PRODUCT_NAME=?" );
             updateclient=c.prepareStatement("update clientinfor  "
 + "set name=?,gender=?,dob=?,mob=?,email=?,address=?  "
                    + "where cid=? ");
//          String s2="CREATE table "+s1+" (   ID  NUMBER(10),    NAME  VARCHAR2(30))";

                    
                    
//            "update emp_info2  "+ "set name=?,gender=?,dob=?,country=?,address=?,language=?  "
//                    + "where cid=?");
            
//            c.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        
    }

}
