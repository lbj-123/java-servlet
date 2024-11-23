package com.example.news.beans;

import java.util.ArrayList;

public interface CommentDAO {
	public boolean insert(Comment comment) ;
	public ArrayList<Comment> getByNewsID(int newsid) ;
	public ArrayList<Comment> getByUsername(String username) 	;
	public ArrayList<Comment> getAll()	;
	public boolean deleteById(String id) ;
	public ArrayList<Comment> getTop5() ;
}
