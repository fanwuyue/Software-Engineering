package top.womoe.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.womoe.model.HR;
import top.womoe.model.HRExample;

public interface HRMapper {
    long countByExample(HRExample example);

    int deleteByExample(HRExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HR record);

    int insertSelective(HR record);

    List<HR> selectByExample(HRExample example);

    HR selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HR record, @Param("example") HRExample example);

    int updateByExample(@Param("record") HR record, @Param("example") HRExample example);

    int updateByPrimaryKeySelective(HR record);

    int updateByPrimaryKey(HR record);
}