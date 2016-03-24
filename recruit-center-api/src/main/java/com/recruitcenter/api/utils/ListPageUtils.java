package com.recruitcenter.api.utils;

import java.util.ArrayList;
import java.util.List;

public class ListPageUtils {
	/**
	 * 内存分页公共方法
	 * @param begin
	 * @param end
	 * @param list
	 * @return
	 */
	public static List page(Integer begin, Integer end, List list) {
        List pageList = null;
        if (list != null && begin != null && end != null) {
            Integer dataSize = list.size();
            if (begin < dataSize && end < dataSize) {
                pageList = list.subList(begin, end);
            } else if(begin < dataSize) {
                pageList = list.subList(begin, list.size());
            }
        }
        return pageList == null ? new ArrayList() : pageList;
    }
}
