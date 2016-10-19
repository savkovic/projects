/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dusan Savkovic
 */
public class Library {
    Connection conn;
     private static Library instance;
   
    
    public static Library getInstance() throws SQLException{
        if(instance==null){
            instance=new Library();
        }
        return instance;
    
    }
    
    public Library() throws SQLException{
        conn=DriverManager.getConnection("jdbc:mysql://localhost/biblioteka","root","tastatura");
    }
    
    
    public void addBook(Book b) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("insert into book values(null,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1,b.naziv);
        ps.setString(2,b.autor);
        ps.execute();
    }
    
}
