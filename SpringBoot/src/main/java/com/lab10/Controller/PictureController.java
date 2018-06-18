package com.lab10.Controller;

import com.lab10.Entity.Picture;
import com.lab10.Entity.Results;
import com.lab10.Service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;

@RestController
public class PictureController {

    @Autowired
    PictureService ps;

    @RequestMapping("/gallery/pictures")
    public HashMap<Integer,Picture> getGallery()
    {
        return ps.getGallery();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/gallery/pictures/{index}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Results deleteImage(@PathVariable int index) {
        return ps.deletePicture(index);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/gallery/pictures/{index}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> showImage(@PathVariable int index) throws FileNotFoundException{
        File file = new File(ps.paths.get(index).toString());
        InputStream inputStream = new FileInputStream(file);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(inputStream));
    }
    @GetMapping(value = "/gallery")
    public String index1(ModelMap modelMap) {
        modelMap.put("pictureList", ps.getGallery());

        return "index";
    }
}
