package com.raise.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiangxiaolong
 * @create 2022-02-18 23:53
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyInfo {
    private int companyId;
    private String interDate;
    private String companyName;
    private String companyAddress;
    private String interUser;
    private int isDelete;
    private String createTime;
    private String updateTime;

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "companyId=" + companyId +
                ", interDate='" + interDate + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", interUser='" + interUser + '\'' +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
