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
public class MemberController {

	private final MemberMapper memberMapper;

	public MemberController(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	@GetMapping("/api/members")
	public List<MemberVO> getMembers() {
		return memberMapper.getMembers();
	}

	@PostMapping("/api/members")
	public MemberVO insertMember(@RequestBody MemberVO member) {
		memberMapper.insertMember(member);
		return member;
	}

	@PostMapping("/api/login")
	public MemberVO login(@RequestBody MemberVO member) {
		return memberMapper.loginMember(member);
	}

	@DeleteMapping("/api/members")
	public void deleteMember(@RequestParam String userId) {
		memberMapper.deleteMember(userId);
	}
}