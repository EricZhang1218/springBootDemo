package com.eric.demo.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.eric.demo.constant.ResultCodeConstant;
import com.eric.demo.controller.BaseController;
import com.eric.demo.db.search.UserSearch;
import com.eric.demo.service.user.UserService;
import com.eric.demo.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(value = "用户信息",tags={"用户接口-eric"})

@RestController
@RequestMapping({"/front/mapper/interface/user"})
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    public static Logger logger= LoggerFactory.getLogger(UserController.class);

    @ApiImplicitParam(name = "param", value = "查询条件", required = true, dataType = "String", paramType = "query")
    @PostMapping("list")
    public Map<String,Object> list(String param){
        try {
            UserSearch search = toObject(param, UserSearch.class);
            Page page = userService.pageQuery(search);
            return CommonUtil.resultMap(1, ResultCodeConstant.COMMON_SUCCESS, JSON.toJSONString(page, SerializerFeature.WriteMapNullValue));
        }catch (Exception e){
            logger.info("发生异常---》》》{}",e);
            return CommonUtil.resultMap(-1, ResultCodeConstant.COMMON_FAILED.getCode(), ResultCodeConstant.COMMON_FAILED.getMsg(), null);
        }
    }
}
