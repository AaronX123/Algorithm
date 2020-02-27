package util;

import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-21
 */
public class ListUtil {
    public static <T> List<T> copy(List<T> src, List<T> des){
        if (src == null || des == null){
            return null;
        }
        if (des.size() < src.size()){
            throw new IllegalArgumentException("拷贝的空间不能小于原集合大小");
        }
        des.addAll(src);
        return des;
    }
}
