package com.band.dao;

import com.band.entity.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MemberDAO {

    //@PersistenceContext

}
