package com.revature.dao;
import com.revature.model.Artist;
import com.revature.model.Painting;
import com.revature.util.ConnectionUtil;
/*whats list?
list is an interface that arraylist and linkedlist implement
 */
import java.sql.*;
import java.util.List;

public class paintingDAO {
    /*
    what is a DAO?
    DAO stands for Data Access Object
    the DAO is intended to contain methods that return POJO (plain old java objects)
    or collections of POJO from the database
    are DAOs necessary?
    not really - but they are considered best practice
     */
    Connection conn;

    public paintingDAO(){

        conn = ConnectionUtil.getConnection();
    }
    public List<Painting> getAllPaintings() {
        return null;
    }

    public Painting getPainting(String title) throws SQLException {
        Painting myPainting = null;
        PreparedStatement statement = conn.prepareStatement("Select * From Painting Where title = ?");
        int parameterIndex = 0;
        statement.setString(++parameterIndex, title);
        /* ++var vs var++?
        the iteration happens before vs after the line executes
         */
        ResultSet rs = statement.executeQuery();
        /*
        if(rs.next()) {
            rs.beforeFirst();
        }else*/
        while(rs.next()){
            myPainting = new Painting(rs.getInt("artist_id"),
                    rs.getString("title"),
                    rs.getString("url"),
                    rs.getString("genre"),
                    rs.getInt("year_made"));
        }
        rs.close();
        return myPainting;
    }

    public void addPainting(Painting P) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
                "Insert into Painting (artist_id, title, url, genre, year_made)" +
                "Values" +
                "(?,?,?,?,?)");
        int parameterIndex = 0;
        statement.setInt(++parameterIndex, P.getArtist_id());
        statement.setString(++parameterIndex, P.getTitle());
        statement.setString(++parameterIndex, P.getUrl());
        statement.setString(++parameterIndex, P.getGenre());
        statement.setInt(++parameterIndex, P.getYear());
        statement.executeUpdate();
    }
}
