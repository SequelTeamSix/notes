package com.revature.dao;
import com.revature.model.Artist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.revature.driver.Driver.conn;

public class artistDAO {

    public List<Artist> getAllArtists() throws SQLException {
        List<Artist> allArtists = new ArrayList<Artist>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("Select * From Artist");
        while(rs.next()){
            Artist nextArtist = new Artist(rs.getString("name"),rs.getInt("artist_id"));
            allArtists.add(nextArtist);
        }
        rs.close();
        return allArtists;
    }

}
