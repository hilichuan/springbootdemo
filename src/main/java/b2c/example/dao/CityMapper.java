package b2c.example.dao;

import b2c.example.domain.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by 菜小川 on 2017/10/19.
 */
public interface CityMapper {
    public City findById(@Param("id") Long id, @Param("name") String name);
    public City findByName(Long id);
}
