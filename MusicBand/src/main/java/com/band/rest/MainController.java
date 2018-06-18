package com.band.rest;

import com.band.dao.BandDAO;
import com.band.entity.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private BandDAO bandDAO;

    @Autowired
    public MainController(BandDAO bandDAO) {
        this.bandDAO = bandDAO;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addBand(@RequestParam(value = "name") String name){
        bandDAO.create(new Band(name));
    }
    @RequestMapping(value = "/update/", method = RequestMethod.POST)
    public void updateName(@RequestParam(value = "new_name") String new_name, @RequestParam(value = "id") int id){
        bandDAO.update(bandDAO.getBandById(id), new_name);
    }
    @RequestMapping(value = "/show/{id}/", method = RequestMethod.GET)
    public Band showBand(@PathVariable(value = "id") int id){
        return bandDAO.getBandById(id);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delBand(@PathVariable(value = "id") int id){
        Band band = bandDAO.getBandById(id);
        bandDAO.delete(band);
    }
}
