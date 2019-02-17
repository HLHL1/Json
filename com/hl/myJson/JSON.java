package com.hl.myJson;

import com.hl.myJson.Grammar.StatusMachine;

public class JSON {
    /**
     * 解析json字符串返回List/Map的嵌套结构或值（true、false、number、null）
     * @param str 要解析的json字符串
     * @return 解析的结果对象
     */

    public static Object parse(String str) {
        if (str == null || "".equals(str.trim()))//trim() 方法用于删除字符串的头尾空白符
            return null;
        else {
          return (new StatusMachine(str)).parse();
        }
    }
}
