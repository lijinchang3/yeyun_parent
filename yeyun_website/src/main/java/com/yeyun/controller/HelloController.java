package  com.yeyun.controller;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(value = "检查模板操作", description = "检查模板操作")
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) {
        log.info("测试环境");
        String aa="1255555553";
        return "hello world, " +name+aa;
    }
    @GetMapping("/hello1")
    public String hello1(String name) {
        log.info("测试环境");
        String aa="1255555553";
        return "hello world, " +name+aa;
    }
    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "content", value = "文章内容", required = true, dataType = "String"),
            @ApiImplicitParam(name = "author", value = "文章作者", required = true, dataType = "String")
    })

    @PostMapping("/article")
    public @ResponseBody
    String saveArticle(@RequestParam(value="title") String title,  //参数1
                        @RequestParam(value="content") String content,//参数2
            @RequestParam(value="author") String author //参数3
    ) {
        return  "";
    }
}
