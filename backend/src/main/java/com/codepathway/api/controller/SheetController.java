package com.codepathway.api.controller;

import com.codepathway.api.dto.SheetDto;
import com.codepathway.api.service.SheetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sheets")
public class SheetController {
    private final SheetService sheetService;
    public SheetController(SheetService sheetService) {this.sheetService = sheetService;}

    @GetMapping
    public ResponseEntity<List<SheetDto>> getSheets() {
        return ResponseEntity.ok(sheetService.listSheets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SheetDto> getSheet(@PathVariable Long id) {
        return ResponseEntity.ok(sheetService.getById(id));
    }
}
