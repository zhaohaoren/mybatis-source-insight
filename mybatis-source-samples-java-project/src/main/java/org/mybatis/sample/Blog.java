package org.mybatis.sample;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_blog
 * @author 
 */
@Data
public class Blog {
    private Integer id;

    private String title;

    private String author;

    private Date createTime;

    private Date updateTime;

    private String content;
}