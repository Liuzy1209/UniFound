package com.camwang.unifound.controller;

import com.camwang.unifound.util.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class ImageController {
    @RequestMapping(value = "/image/{id}/{suffix}", method = RequestMethod.GET)
    public ResponseEntity getImage(
            @PathVariable("id") String id,
            @PathVariable("suffix") String suffix,
            HttpServletResponse response
    ) {
        String filePath = Constants.IMG_PATH + id + "." + suffix;
        // response.setHeader("Content-Disposition", "attachment;fileName=" + id + "." + suffix);
        File imageFile = new File(filePath);
        try(InputStream is = new FileInputStream(imageFile);
            OutputStream os = response.getOutputStream();){
            byte [] buffer = new byte[1024];
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return ResponseEntity.ok(200);
    }
}
