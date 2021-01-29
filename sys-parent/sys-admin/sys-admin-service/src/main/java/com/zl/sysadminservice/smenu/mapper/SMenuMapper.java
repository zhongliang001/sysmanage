package com.zl.sysadminservice.smenu.mapper;

import com.zl.domain.SMenu;

import java.util.List;

public interface SMenuMapper {

    List<SMenu> selectSMenu(String parentId);
}
