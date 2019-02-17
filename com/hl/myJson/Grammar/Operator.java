package com.hl.myJson.Grammar;

import com.hl.myJson.Lexical.JsonLex;
import com.hl.myJson.Lexical.LeptType;
import com.hl.myJson.Lexical.Type;
import com.hl.myJson.Lexical.UnexpectedException;

import java.util.*;

public class Operator {

    private JsonLex lex = null;
    private Stack<Integer> statusStack = new Stack<Integer>();//保存所有状态值
    private Object curValue = null;//
    private Stack<Object> keyStack = new Stack<Object>();//保存对象建
    private Stack<Object> objStack = new Stack<Object>();//保存对象值
    private Object curObj = null;

    public Operator(JsonLex lex){
        this.lex=lex;
    }

    public Object getCurValue() {
        return curValue;
    }

    public Object getCurObj() {
        return curObj;
    }

    public Integer objs(Integer from, Integer to, LeptType input){
        if(from!=Status.BGN){
            statusStack.push(from);
        }
        curObj=new HashMap<Object,Object>();
        objStack.push(curObj);
        return to;
    }

    public Integer arrs(Integer from,Integer to,LeptType input){
        if(from!=Status.BGN){
            statusStack.push(from);
        }
        curObj=new ArrayList<Object>();
        objStack.push(curObj);
        return to;
    }
    private Object getRealValue(LeptType input){
        Object value = null;
        try {
            value = input.getRealValue();
        } catch (RuntimeException e) {
            System.out.println(lex.generateUnexpectedException("字符串转换错误", e).getMessage());
        }
        return value;
    }
    public Integer arrav(Integer from, Integer to, LeptType input) {
        curValue = getRealValue(input);
        ((List<Object>) curObj).add(curValue);
        return to;

    }
    public Integer objak(Integer from,Integer to,LeptType input){
       keyStack.push(getRealValue(input));
       return to;
    }

    public Integer objav(Integer from,Integer to,LeptType input){
        curValue = getRealValue(input);
        ((Map<Object, Object>) curObj).put(keyStack.pop(), curValue);
        return to;
    }

    public Integer val(Integer from,Integer to,LeptType input) {

        switch (input.getType()) {
            case Type.ARRE:
            case Type.OBJE:
                curObj = objStack.pop();
                curValue = curObj;
                break;
            case Type.TRUE:
            case Type.FALSE:
            case Type.NULL:
            case Type.STR:
            case Type.NUM:
                curValue = getRealValue(input);
                break;
        }
        if (statusStack.isEmpty()) {
            return Status.EOF;
        } else {
            Integer s = statusStack.pop();
            if (s == Status.ARRBV) {
                curObj = objStack.peek();
                ((List<Object>) curObj).add(curValue);
                s = Status.ARRAV;
            } else if (s == Status.OBJBV) {
                curObj = objStack.peek();
                ((Map<Object, Object>) curObj).put(keyStack.pop(), curValue);
                s = Status.OBJAV;
            }
            return s;
        }
    }
}
