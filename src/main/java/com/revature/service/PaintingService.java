package com.revature.service;

import com.revature.dao.PaintingDAO;
import com.revature.model.Painting;

import java.sql.SQLException;

public class PaintingService {

    /*Service layer is for business logic!*/

    PaintingDAO paintingdao;

    public PaintingService(){
        paintingdao = new PaintingDAO();
    }
    public PaintingService(PaintingDAO dao){
        paintingdao = dao;
    }

    public boolean addPainting(int id, String name, String url, String genre, int year){
        if(id<0){
            return false;
        }
        try{
            Painting p = new Painting(id, name, url, genre, year);
            paintingdao.addPainting(p);
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public Painting getPainting(String userInput){
        if(userInput.length()<=0){
            return null;
        }
        try {
            return paintingdao.getPainting(userInput);
        }catch(SQLException e){
            return null;
        }
    }

}

