package org.example.mybatis.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(autoResultMap = true)
public class Woman {

    private Long id;

    private String name;

    private Long laoGongId;

    @TableField(exist = false)
    private Man laoGong;

    @TableField(exist = false)
    private List<Child> waWa;
}