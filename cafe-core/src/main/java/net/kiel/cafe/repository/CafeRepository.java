package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.domain.Cafe;

public interface CafeRepository {
    public List<Cafe> selectAll();
}
