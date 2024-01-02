package com.example.storeutils.givechange;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiveChangeController {

    private final IGiveChangeService giveChangeService;

    public GiveChangeController(IGiveChangeService giveChangeService) {
        this.giveChangeService = giveChangeService;
    }

    @PostMapping("/getchange")
    public ResponseEntity<String> getChange(@RequestBody GiveChangeDto giveChangeDto){
        return ResponseEntity.ok(giveChangeService.getChange(giveChangeDto));
    }

}
