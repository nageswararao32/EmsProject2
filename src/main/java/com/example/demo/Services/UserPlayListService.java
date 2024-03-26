package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.UserPlayList;

public interface UserPlayListService {

	public void addPlayList(UserPlayList playlist);

	public List<UserPlayList> fetchALlPlayLists();

}
