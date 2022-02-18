package com.revature.service;

import com.revature.dao.ArtistDAO;
import com.revature.model.Artist;

import java.sql.SQLException;
import java.util.List;

public class ArtistService {
    ArtistDAO artistdao;

    public ArtistService() {
        artistdao = new ArtistDAO();
    }
    public ArtistService(ArtistDAO dao) {
        artistdao = dao;
    }

    public List<Artist> getAllArtists(){
        try{
            return artistdao.getAllArtists();
        }catch(SQLException e){
            return null;
        }
    }

}
