package top.zhaohaoren.mybatis.sample;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * TbBlogDAO继承基类
 *
 * @author zhaohaoren
 */
public interface BlogMapper {

    @Select("SELECT * FROM tb_blog WHERE id = #{id}")
    Blog selectByPrimaryKey(@Param("id") Integer id);
}