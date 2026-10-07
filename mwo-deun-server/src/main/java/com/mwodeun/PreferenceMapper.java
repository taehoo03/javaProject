package com.mwodeun;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PreferenceMapper {

	PreferenceVO getPreference(int memberId);

	void insertPreference(PreferenceVO preference);

	void updatePreference(PreferenceVO preference);
}