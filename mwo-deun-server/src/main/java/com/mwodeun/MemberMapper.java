package com.mwodeun;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	List<MemberVO> getMembers();

	void insertMember(MemberVO member);

	MemberVO loginMember(MemberVO member);

	void deleteMember(String userId);
}