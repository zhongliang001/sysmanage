package com.zl.syssequence.service.impl;

import com.zl.common.exception.ZlException;
import com.zl.syssequence.format.FormatEnum;
import com.zl.syssequence.format.FormatInterface;
import com.zl.syssequence.service.SequenceService;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author zhongliang
 * @version V1.0
 * @className AbstractSequenceService
 * @decription 用来实现根据模板生成流水号
 * @createTime 2022/03/05 16:17:00
 */
public abstract class AbstractSequenceService implements SequenceService {

    /**
     * 根据模板生成流水号
     * @param temp 模板
     * @return 流水号
     */
    @Override
    public String fomartSeqence(String temp){
        String seq = "";
        try {
            if (temp == null) {
                return null;
            }

            List<String> tps = new ArrayList<>();
            String[] split = temp.split("\\$\\{|}");
            for (String sp : split) {
                if (StringUtils.isEmpty(sp)) {
                    continue;
                }
                String regex = "[()]";
                Pattern p = Pattern.compile(regex);
                boolean b = p.matcher(sp).find();
                if (!b) {
                    seq += sp;
                }
                String[] split1 = sp.split(regex);
                Class<FormatInterface> format = get(split1[0]);
                if (format != null) {
                    try {
                        FormatInterface formatInterface = format.newInstance();
                        int x = split1.length;
                        if (x > 1) {
                            seq += formatInterface.format(split1[1], this);
                        } else {
                            seq += formatInterface.format(null, this);
                        }

                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ZlException(e.getMessage());
        }
        return seq;
    }

    private Class<FormatInterface> get(String name){
        for(FormatEnum fe : FormatEnum.values()){
            if (fe.name().equals(name)) {
                return fe.getFormat();
            }
        }
        return null;
    }
}
