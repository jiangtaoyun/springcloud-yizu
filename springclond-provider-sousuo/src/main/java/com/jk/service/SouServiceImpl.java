package com.jk.service;

import com.jk.mapper.SouMapper;
import com.jk.model.SouWork;
import com.jk.util.Easyuipage;
import com.jk.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SouServiceImpl implements SouService {
 @Autowired
 private SouMapper souMapper;

 @Override
 public List<SouWork> queryWork(SouWork souWork) {
  List<SouWork> workList = souMapper.queryWork(souWork);
  System.out.println(workList);
  return workList;
 }

 @Override
 public List<SouWork> query() {
  return null;
 }

 /*@Override
 public String toTest() {
  String ard="请求成功";
  return ard;
 }*/
}
