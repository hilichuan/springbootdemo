package b2c.example.web;

import b2c.example.dao.CityMapper;
import b2c.example.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 菜小川 on 2017/10/19.
 */
@RestController
public class CityController {
    @Autowired
    private CityMapper cityMapper;

    @GetMapping(value="/city/{id}/{name}")
    public City findById(@PathVariable("id") Long id,@PathVariable("name") String name){
        return cityMapper.findById(id,name);
    }

    @GetMapping(value="/city")
    public City findByName(@RequestParam("id") Long id){
        return cityMapper.findByName(id);
    }


}
