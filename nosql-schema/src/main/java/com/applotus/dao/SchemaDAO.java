package com.applotus.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.applotus.entity.Schema;

@Repository
public interface SchemaDAO extends JpaDAO<Schema, Serializable> {
	List<Schema> findByIdentifier(String identifier);
	Schema findByIdentifierAndField(String identifier, String field);
}
