package com.raise.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiangxiaolong
 * @create 2022-02-22 16:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterDetail {
    private int id;
    private int companyId;
    //第几轮
    private int rank;
    private String question;
    private String answer;
    //难度系数
    private int star;
    private String interUser;
    private int isDelete;
    private String createTime;
    private String updateTime;

    @Override
    public String toString() {
        return "InterDetail{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", rank=" + rank +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", star=" + star +
                ", interUser='" + interUser + '\'' +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
