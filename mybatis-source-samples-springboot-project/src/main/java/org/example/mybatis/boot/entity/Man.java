package org.example.mybatis.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(resultMap = "m_b")
public class Man {

    private Long id;

    private String name;

    private Long laoPoId;

    @TableField(exist = false)
    private Woman laoPo;

    @TableField(exist = false)
    private List<Child> waWa;
}