package com.github.dy.zero.dao;

import com.github.dy.zero.domain.Info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InfoMapper {
	@Insert("INSERT INTO info(uid, tid) VALUES(#{uid}, #{tid})")
	int insertInfo(Info info);

	@Select("SELECT * FROM info WHERE uid = #{uid}")
    List<Info> selectInfos(Long uid);
}
