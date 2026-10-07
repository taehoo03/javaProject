package com.mwodeun;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PreferenceController {

	private final PreferenceMapper preferenceMapper;

	public PreferenceController(PreferenceMapper preferenceMapper) {
		this.preferenceMapper = preferenceMapper;
	}

	@GetMapping("/api/preferences")
	public PreferenceVO getPreference(
			@RequestParam int memberId) {
		return preferenceMapper.getPreference(memberId);
	}

	@PostMapping("/api/preferences")
	public PreferenceVO insertPreference(
			@RequestBody PreferenceVO preference) {
		preferenceMapper.insertPreference(preference);
		return preference;
	}

	@PutMapping("/api/preferences")
	public PreferenceVO updatePreference(
			@RequestBody PreferenceVO preference) {
		preferenceMapper.updatePreference(preference);
		return preference;
	}
}