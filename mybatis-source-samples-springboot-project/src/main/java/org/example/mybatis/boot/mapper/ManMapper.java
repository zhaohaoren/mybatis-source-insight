package org.example.mybatis.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.mybatis.boot.entity.Man;

public interface ManMapper extends BaseMapper<Man> {

    Man selectLinkById(Long id);
}