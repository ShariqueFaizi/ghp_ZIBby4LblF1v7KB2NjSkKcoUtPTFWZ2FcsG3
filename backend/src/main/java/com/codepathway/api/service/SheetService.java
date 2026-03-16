package com.codepathway.api.service;

import com.codepathway.api.dto.SheetDto;
import com.codepathway.api.entity.Sheet;
import com.codepathway.api.repository.SheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SheetService {
    private final SheetRepository sheetRepository;
    public SheetService(SheetRepository sheetRepository) {this.sheetRepository = sheetRepository;}
    public List<SheetDto> listSheets() {
        return sheetRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }
    public SheetDto getById(Long id) {
        Sheet sheet = sheetRepository.findById(id).orElseThrow(() -> new RuntimeException("Sheet not found"));
        return toDto(sheet);
    }
    private SheetDto toDto(Sheet sheet) {
        SheetDto dto = new SheetDto();
        dto.setId(sheet.getId());
        dto.setTitle(sheet.getTitle());
        dto.setSlug(sheet.getSlug());
        dto.setDescription(sheet.getDescription());
        dto.setDifficulty(sheet.getDifficulty());
        dto.setPremium(sheet.isPremium());
        return dto;
    }
}
