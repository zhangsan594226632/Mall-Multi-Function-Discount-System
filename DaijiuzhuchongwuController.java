package com.spboot.tx.controller;

import cn.hutool.core.bean.BeanUtil;
import com.jntoo.db.DB;
import com.jntoo.db.utils.StringUtil;
import com.spboot.tx.config.Configure;
import com.spboot.tx.mapper.*;
import com.spboot.tx.pojo.*;
import com.spboot.tx.service.*;
import com.spboot.tx.utils.*;
import io.swagger.annotations.*;
import java.io.*;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = { "待救助宠物控制器" })
@RestController
@RequestMapping("/api/daijiuzhuchongwu")
public class DaijiuzhuchongwuController {

    @Autowired
    public DaijiuzhuchongwuService daijiuzhuchongwuService;

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @ApiOperation(value = "获取全部待救助宠物", httpMethod = "GET")
    @RequestMapping("/selectAll")
    public ResponseData<List<Daijiuzhuchongwu>> selectAll() {
        return daijiuzhuchongwuService.selectAll();
    }

    @ApiOperation(value = "根据条件筛选获取待救助宠物列表，并分页", httpMethod = "POST")
    @RequestMapping("/selectPages")
    public ResponseData selectPages(@RequestBody Map<String, Object> req) {
        return daijiuzhuchongwuService.selectPages(req);
    }

    @ApiOperation(value = "根据条件筛选获取待救助宠物列表，并分页，且只出现某用户列表信息", httpMethod = "POST")
    @RequestMapping("/selectPagesFaburen")
    public ResponseData selectPagesFaburen(@RequestBody Map<String, Object> req) {
        req.put("session_name", "faburen");
        return daijiuzhuchongwuService.selectPages(req);
    }

    @ApiOperation(value = "根据过滤信息获取相关数据", httpMethod = "POST")
    @RequestMapping("/filter")
    public ResponseData<List<Daijiuzhuchongwu>> filter(@RequestBody Map<String, Object> req) {
        return daijiuzhuchongwuService.filter(req);
    }

    @ApiOperation(value = "根据id获取信息", httpMethod = "GET")
    @RequestMapping("/findById")
    @ApiImplicitParam(name = "id", value = "待救助宠物对应的id", dataType = "Integer")
    public ResponseData findById(@RequestParam Integer id) {
        return daijiuzhuchongwuService.findById(id);
    }

    @ApiOperation(value = "根据id更新数据", httpMethod = "POST")
    @RequestMapping("/update")
    @ApiImplicitParam(name = "data", value = "使用json数据提交", type = "json", dataTypeClass = Daijiuzhuchongwu.class, paramType = "body")
    public ResponseData update(@RequestBody Map data) {
        Daijiuzhuchongwu post = BeanUtil.mapToBean(data, Daijiuzhuchongwu.class, true);
        return daijiuzhuchongwuService.update(post, data);
    }

    @ApiOperation(value = "插入一行数据，返回插入后的待救助宠物", httpMethod = "POST")
    @RequestMapping("/insert")
    @ApiImplicitParam(name = "data", value = "使用json数据提交", type = "json", dataTypeClass = Daijiuzhuchongwu.class, paramType = "body")
    public ResponseData insert(@RequestBody Map data) {
        Daijiuzhuchongwu post = BeanUtil.mapToBean(data, Daijiuzhuchongwu.class, true);
        return daijiuzhuchongwuService.insert(post, data);
    }

    @ApiOperation(value = "根据id列表删除数据", httpMethod = "POST")
    @RequestMapping("/delete")
    @ApiImplicitParam(name = "id", value = "待救助宠物对应的id", type = "json", dataTypeClass = List.class)
    public ResponseData delete(@RequestBody List<Integer> id) {
        return daijiuzhuchongwuService.delete(id);
    }


    @ApiOperation(value = "根据图片识别宠物", httpMethod = "POST")
    @RequestMapping("/aishibie")
    @ApiImplicitParam(name = "id", value = "待救助宠物对应的图片url", type = "json", dataTypeClass = List.class)
    public ResponseData aishibie(@RequestBody List<String> url) {


//        //发送post请求
//        String aiurl="https://qianfan.baidubce.com/v2/chat/completions";
//        //构建请求体
//       List<Map> meslist= new ArrayList<>();
//        meslist.add(
//            new HashMap<String,String>(){{
//                put("role","user");
//                put("text","识别图片中的宠物");
//            }}
//        );
//        //加入图片url
//        meslist.add(
//            new HashMap<String,String>(){{
//                put("role","user");
//                put("content","图片url:"+url);
//            }}
//        );
//
//
//        Map<String,Object> req=new HashMap<>();
//        req.put("model","deepseek-vl2");
//        req.put("messages",);






        return JsonResult.success("ok");
    }





}
