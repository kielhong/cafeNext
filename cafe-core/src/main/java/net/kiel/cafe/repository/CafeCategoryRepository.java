package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.CafeCategoryEntity;

public interface CafeCategoryRepository {
    List<CafeCategoryEntity> selectAll();
}
