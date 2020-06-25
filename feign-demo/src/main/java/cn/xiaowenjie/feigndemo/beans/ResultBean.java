package cn.xiaowenjie.feigndemo.beans;

import lombok.Data;

/**
 * 返回结果包装类
 *
 * @author 晓风轻
 *
 * @param <T>
 */
@Data
public class ResultBean<T> {

    private int code;

    private String msg;

    private T data;

    public ResultBean(){

    }

    public ResultBean(T data){
        this.data = data;
    }
}
