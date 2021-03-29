package org.example.mybatis.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(autoResultMap = true)
public class Child {

    private Long id;

    private String name;

    private Long laoHanId;

    private Long laoMaId;

    @TableField(exist = false)
    private Man laoHan;

    @TableField(exist = false)
    private Woman laoMa;
}