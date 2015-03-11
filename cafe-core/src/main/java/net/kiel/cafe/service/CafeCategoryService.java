package net.kiel.cafe.service;

import java.util.List;

import net.kiel.cafe.dto.CafeCategoryDto;

public interface CafeCategoryService {
    List<CafeCategoryDto> findAll();
}
