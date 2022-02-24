package com.revature.driver;

import com.revature.service.ArtistService;
import com.revature.service.PaintingService;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public final class Driver {
    public static Connection conn = ConnectionUtil.getConnection();
    public static void main(String[] args) throws SQLException {

        PaintingService paintingService = new PaintingService();
        ArtistService artistService = new ArtistService();

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

        System.out.println(paintingService.getPainting("Composition IX"));
        //paintingService.addPainting(0, "Gentle Ascent", null, "Abstract", 1950);

    }
}
