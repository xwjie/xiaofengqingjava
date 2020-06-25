package cn.xiaowenjie.feigndemo.beans;

import lombok.Data;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultBean<?> that = (ResultBean<?>) o;
        return code == that.code &&
                Objects.equals(msg, that.msg) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg, data);
    }
}
