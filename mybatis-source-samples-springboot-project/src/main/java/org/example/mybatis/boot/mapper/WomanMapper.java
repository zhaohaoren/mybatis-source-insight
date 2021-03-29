package org.example.mybatis.boot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.mybatis.boot.entity.Woman;

/**
 * @author miemie
 * @since 2019-11-27
 */
public interface WomanMapper extends BaseMapper<Woman> {

    Woman selectLinkById(Long id);
}