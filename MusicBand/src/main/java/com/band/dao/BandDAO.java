package com.band.dao;

import com.band.entity.Band;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

@Repository
@Transactional
public class BandDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Band band) throws DuplicateKeyException
    {
        try{
            entityManager.persist(band);
        } catch (DataIntegrityViolationException e)
        {
            throw new DuplicateKeyException("Band exists");
        }
    }
    public void update(Band band, String name)
    {
        band.setBand_name(name);
        entityManager.merge(band);
    }
    public void delete(Band band)
    {

        entityManager.remove(band);
        //entityManager.createQuery("DELETE FROM Band b WHERE b.band_id = b.band_id=:bandId").setParameter("bandId", id);
    }
    public Band getBandById(int id)
    {
       // Object o = entityManager.createQuery("SElECT b FROM Band b", Band.class).getResultList();

        return (Band) entityManager.createQuery("SElECT b FROM Band b WHERE b.band_id=:bandId")
            .setParameter("bandId", id)
            .getSingleResult();
    }
}
