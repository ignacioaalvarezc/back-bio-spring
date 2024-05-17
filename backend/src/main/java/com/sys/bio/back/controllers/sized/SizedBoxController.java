package com.sys.bio.back.controllers.sized;

import com.sys.bio.back.controllers.user.AuthenticationController;
import com.sys.bio.back.models.cutting.CutBox;
import com.sys.bio.back.models.sized.SizedBox;
import com.sys.bio.back.services.cutting.CutBoxCriteriaService;
import com.sys.bio.back.services.cutting.CutBoxService;
import com.sys.bio.back.services.cutting.CutTypeService;
import com.sys.bio.back.services.sized.SizedBoxService;
import com.sys.bio.back.services.sized.StrawTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sizedBoxes")
@CrossOrigin("*")
public class SizedBoxController {


    @Autowired
    private SizedBoxService boxService;

    @Autowired
    private StrawTypeService typeService;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);


    @PostMapping("/")
    public ResponseEntity<SizedBox> saveSizedBox(@RequestBody SizedBox sizedBox) {
        return ResponseEntity.ok(boxService.addSizedBox(sizedBox));
    }

    @PutMapping("/update/{sizedBoxId}")
    public ResponseEntity<SizedBox> updateSizedBox(@PathVariable("sizedBoxId") Long sizedBoxId,
                                               @Valid @RequestBody SizedBox sizedBox) {
        try {
            sizedBox.setSizedBoxId(sizedBoxId);
            SizedBox updatedSizedBox = boxService.updateSizedBox(sizedBox);
            return ResponseEntity.ok(updatedSizedBox);
        } catch (Exception e) {
            log.error("Error al actualizar la caja de corte con ID: " + sizedBoxId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> listSizedBoxes() {
        return ResponseEntity.ok(boxService.getSizedBoxes());
    }

    @GetMapping("/id/{sizedBoxId}")
    public SizedBox listSizedBox(@PathVariable("sizedBoxId") Long sizedBoxId) {
        return boxService.getSizedBox(sizedBoxId);
    }


    @DeleteMapping("/{sizedBoxId}")
    public void deleteSizedBox(@PathVariable("sizedBoxId") Long sizedBoxId) {
        boxService.deleteSizedBox(sizedBoxId);
    }


    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAllSizedBoxes(@RequestBody List<SizedBox> sizedBoxes) {
        try {
            boxService.saveAll(sizedBoxes);
            return ResponseEntity.ok("Sized boxes has saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving sized boxes: " + e.getMessage());
        }
    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(org.springframework.http.converter.HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid JSON format: " + ex.getMessage());
    }




}
