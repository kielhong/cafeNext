package net.kiel.cafe.service;

import java.util.List;

import net.kiel.cafe.vo.CafeCategory;

public interface CafeCategoryService {
    List<CafeCategory> findAll();
}
