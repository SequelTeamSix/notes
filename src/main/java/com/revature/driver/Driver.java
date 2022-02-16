package com.revature.driver;

import com.revature.dao.artistDAO;
import com.revature.dao.paintingDAO;
import com.revature.model.Artist;
import com.revature.model.Painting;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.List;

public final class Driver {
    public static Connection conn = ConnectionUtil.getConnection();
    public static void main(String[] args) throws SQLException {
        artistDAO artistdao = new artistDAO();
        paintingDAO paintingdao = new paintingDAO();

        String[] b = {"a", "b", "c"};


        conn.setAutoCommit(true);
        /*
        conn.setAutoCommit(false);
        conn.commit();

        why not autocommit?
        let's say we're inserting an artist followed by all their paintings
        to the DB -
        but for some reason our program / computer crashes halfway through inserting the
        paintings:
        it becomes difficult for us to know how information we're missing or has been lost

        this is a case where we need atomicity:
        either all transactions are completed, or all transactions fail



         */
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
