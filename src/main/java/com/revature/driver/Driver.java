package com.revature.driver;

import com.revature.dao.artistDAO;
import com.revature.dao.paintingDAO;
import com.revature.model.Artist;
import com.revature.model.Painting;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Driver {
    public static Connection conn = ConnectionUtil.getConnection();
    public static void main(String[] args){
        artistDAO artistdao = new artistDAO();
        paintingDAO paintingdao = new paintingDAO();

        try {
            List<Artist> allArtists = artistdao.getAllArtists();
            for(Artist A : allArtists){
                System.out.println(A);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        try {
            Painting p = paintingdao.getPainting("Composition IX");
            System.out.println(p);
        }catch(SQLException e){
            e.printStackTrace();
        }

        try {
            Painting P = new Painting(0, "Gentle Ascent", null, "Abstract", 1950);
            paintingdao.addPainting(P);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
