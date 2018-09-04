package com.example.demo.mapper;

import com.example.demo.model.App;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by mahongbin on 2018/9/4.
 */
@Component
public interface TestMapper {
    List<App> getActivityData();
}
