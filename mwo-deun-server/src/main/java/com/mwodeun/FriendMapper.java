package com.mwodeun;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FriendMapper {

	List<FriendVO> getFriends(int memberId);

	void insertFriend(FriendVO friend);

	void deleteFriend(int friendId);
}