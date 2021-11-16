package com.zl.syssequence.format;

import com.zl.common.error.TradeCodeDict;
import com.zl.common.exception.ZlException;
import com.zl.syssequence.service.SequenceService;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * @author zhongliang
 */
public class SequceFormat implements FormatInterface {

    /**
     * 序列的默认占位符
     */
    private static  final String DEFUALT_PLACEHOLDER = "0";

    /**
     * 格式化seq片段
     * @param format 片段模板
     * @return  seq片段
     */
    @Override
    public String format(String format,SequenceService sequenceService) {
        String seq;
        if(format == null){
            throw new ZlException(TradeCodeDict.SEQUENCE_NAME_NULL_CODE);
        }
        int i = format.indexOf("[");
        if (i == -1) {
            seq = sequenceService.getSeqence(format).toString();
            sequenceService.updateSeq(format);
            return seq;
        }
        String seqTemp = format.substring(0,i);

        String range = format.substring(i + 1, format.lastIndexOf("]"));
        if(StringUtils.isEmpty(range)){
            seq = sequenceService.getSeqence(format).toString();
            sequenceService.updateSeq(seqTemp);
            return seq;
        }
        String[] ranges = range.split(",");
        if (StringUtils.isEmpty(ranges[0])) {
            return sequenceService.getSeqence(seqTemp).toString();
        }else {
            String regex = "^[0-9]*[1-9][0-9]*$";
            Pattern pattern = Pattern.compile(regex);
            if (!pattern.matcher(ranges[0]).matches()) {
                throw new ZlException("序列长度必须是数字");
            }
            int length = Integer.parseInt(ranges[0]);
            seq = sequenceService.getSeqence(seqTemp).toString();
            sequenceService.updateSeq(seqTemp);
            if(seq.length() > length){
                sequenceService.resetSeq(seqTemp);
                seq = sequenceService.getSeqence(seqTemp).toString();
                sequenceService.updateSeq(seqTemp);
            }
            String placeholder = DEFUALT_PLACEHOLDER;
            int rl = 2;
            if(ranges.length == rl){
                placeholder = ranges[1];
            }
            while (seq.length() < length){
                seq = placeholder + seq;
            }
            return seq;
        }
    }
}
