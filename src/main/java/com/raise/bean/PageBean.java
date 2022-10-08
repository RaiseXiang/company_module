package com.raise.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xiangxiaolong
 * @create 2022-02-19 18:56
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageBean<T> {
    private List<T> dataDetail;
    private int totalPage;
}
