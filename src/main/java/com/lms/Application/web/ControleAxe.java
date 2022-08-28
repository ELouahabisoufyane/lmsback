package com.lms.Application.web;
import com.lms.Application.entities.Axe;
import com.lms.Application.entities.AxeComponant;
import com.lms.Application.entities.Ressource;
import com.lms.Application.message.ResponseFile;
import com.lms.Application.message.ResponseMessage;
import com.lms.Application.service.AxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins ="*" )
@RequestMapping("/Axe")
public class ControleAxe {
    @Autowired
    AxeService As;
    @PostMapping("/addAxe/{idAxe}")
    public AxeComponant addAxe(@RequestBody Axe ac, @PathVariable("idAxe")Long idAxe){
        return As.addAxe(ac,idAxe);
    }
    @GetMapping("/getOne/{idAxe}")
    public AxeComponant getAxe(@PathVariable("idAxe")Long idAxe){
        return As.getAxe(idAxe);
    }
    @DeleteMapping ("/DeleteOne/{idAxe}")
    public void removeAxe(@PathVariable("idAxe")Long idAxe){
         As.removeAxe(idAxe);
    }
    @PutMapping ("/updateOne")
    public void updateAxe(@RequestBody AxeComponant ac){
        As.updateAxe(ac);
    }
    @GetMapping("/getAxes/{idAxe}")
    public List<Axe> getAxesById(@PathVariable("idAxe")Long idAxe){
        return As.getAxesById(idAxe);
    }
    @GetMapping("/getRessources/{idAxe}")
    public ResponseEntity<List<ResponseFile>> getRessourcesById(@PathVariable("idAxe")Long idAxe){
        List<ResponseFile> files = As.getRessourcesById(idAxe).map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();
            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    @PostMapping("/addRessource/{idAxe}")
    ResponseEntity<ResponseMessage> addRessource(@RequestParam("file") MultipartFile file , @PathVariable("idAxe")Long idAxe) throws IOException {
        String message = "";
        try {
            As.addRessource(file,idAxe);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @DeleteMapping ("/DeleteRessource/{idRessource}")
    public void removeAxe(@PathVariable("idRessource")String idRessource){
        As.removeRessource(idRessource);
    }

}
