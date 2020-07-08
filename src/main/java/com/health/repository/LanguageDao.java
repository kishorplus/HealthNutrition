package com.health.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.User;
import com.health.model.Language;

public interface LanguageDao extends JpaRepository<Language,Integer> {

	Language findBylanguageName(String name);

	@Query("from Language u where u.languageName = ?1") 
	ArrayList<Language> findByExcludeLanguages(String language);

	/*
	 * @Query("from language u where u.languageName =?1") ArrayList<language>
	 * findBylanName(Category category);
	 * 
	 */
	
	/* @Query("from language where languageName") */
	
	
}
