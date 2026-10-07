package com.mwodeun;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class FriendController {

	private final FriendMapper friendMapper;

	public FriendController(FriendMapper friendMapper) {
		this.friendMapper = friendMapper;
	}

	@GetMapping("/api/friends")
	public List<FriendVO> getFriends(
			@RequestParam int memberId) {
		return friendMapper.getFriends(memberId);
	}

	@PostMapping("/api/friends")
	public FriendVO insertFriend(
			@RequestBody FriendVO friend) {
		friendMapper.insertFriend(friend);
		return friend;
	}

	@DeleteMapping("/api/friends")
	public void deleteFriend(
			@RequestParam int friendId) {
		friendMapper.deleteFriend(friendId);
	}
}