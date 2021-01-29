package com.zl.sysadminservice.smenu.service;

import com.zl.domain.SMenu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SMenuService {

    List<SMenu> selectSMenu(String parentId);
}
