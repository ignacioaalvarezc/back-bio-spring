package com.sys.bio.back.controllers.sized;

import com.sys.bio.back.controllers.user.AuthenticationController;
import com.sys.bio.back.models.cutting.Cutting;
import com.sys.bio.back.models.sized.Sizing;
import com.sys.bio.back.services.sized.SizingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sizings")
@CrossOrigin("*")
public class SizingController {

    @Autowired
    private SizingService sizingService;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);


    @PostMapping("/")
    public ResponseEntity<Sizing> saveSizing(@RequestBody Sizing sizing) {
        return ResponseEntity.ok(sizingService.addSizing(sizing));
    }

    @PutMapping("/update/{sizingId}")
    public ResponseEntity<Sizing> updateSizing(@PathVariable("sizingId") Long sizingId,
                                                 @Valid @RequestBody Sizing sizing) {
        try {
            sizing.setSizingId(sizingId);
            Sizing updatedSizing = sizingService.updateSizing(sizing);
            return ResponseEntity.ok(updatedSizing);
        } catch (Exception e) {
            log.error("Error al actualizar el proceso de dimensionado con ID: " + sizingId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getSizings() {
        return ResponseEntity.ok(sizingService.getSizings());
    }

    @GetMapping("/id/{sizingId}")
    public Sizing getSizing(@PathVariable("sizingId") Long sizingId) {
        return sizingService.getSizing(sizingId);
    }

    @DeleteMapping("/{sizingId}")
    public void deleteSizing(@PathVariable("sizingId") Long sizingId) { sizingService.deleteSizing(sizingId); }

}
