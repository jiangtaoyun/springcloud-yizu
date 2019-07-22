package com.jk.mapper;

import com.jk.model.SouWork;

import java.util.List;

public interface SouMapper {
    int queryCount(SouWork souWork);

    List<SouWork> queryWork(SouWork souWork);
}
