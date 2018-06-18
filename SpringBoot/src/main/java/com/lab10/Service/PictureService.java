package com.lab10.Service;

import com.lab10.Entity.Picture;
import com.lab10.Entity.Results;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class PictureService {

    public HashMap<Integer,Picture> gallery = new HashMap<Integer, Picture>();
    public HashMap<Integer,String> paths = new HashMap<Integer, String>();

    public PictureService() throws IOException {
        Picture p = new Picture("C:\\Users\\Admin\\IdeaProjects\\SpringBoot\\Gallery\\garniak.jpg", 1);
        gallery.put(1,p);
        paths.put(1,"C:\\Users\\Admin\\IdeaProjects\\SpringBoot\\Gallery\\garniak.jpg");
        p = new Picture("C:\\Users\\Admin\\IdeaProjects\\SpringBoot\\Gallery\\janush.jpg", 2);
        gallery.put(2,p);
        paths.put(2,"C:\\Users\\Admin\\IdeaProjects\\SpringBoot\\Gallery\\janush.jpg");
    }

    public HashMap<Integer,Picture> getGallery() {
        return gallery;
    }

    public HashMap<Integer, String> getPaths() {
        return paths;
    }

    public Results deletePicture(int index)
    {
        Results res = new Results();
        if(gallery.containsKey(index))
        {
            gallery.remove(index);
            paths.remove(index);
            res.setReslut(true);
        }
        else
            res.setReslut(false);
        return res;
    }
    public List<Picture> getAll2() {
        return new ArrayList<Picture>(gallery.values());
    }
}
