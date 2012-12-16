package dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import entity.PolicyRecord;

@Repository
public interface PolicyDAO extends JpaDAO<PolicyRecord, Serializable>{

}
