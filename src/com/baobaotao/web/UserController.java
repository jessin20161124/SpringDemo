package com.baobaotao.web;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by gzx on 16-11-19.
 */
//处理器或者控制器，在过滤.html的基础上，完成要处理的URL，只处理/user
@Controller
@RequestMapping("/user")
public class UserController {
    //自动注入父容器（业务层）中的bean
    @Autowired
    private UserService userService;
    //处理/user/register.html请求，返回视图逻辑名，会被进一步处理
    //被解析器映射为WEB-INF/views/user/register.jsp
    //并将该页面的内容返回给客户端
    @RequestMapping("/register")
    public String register(){
        return "user/register";
    }
    //处理/user.html请求，且是表单，POST请求
    //参数user的成员将与表单的返回参数字段匹配，自动注入
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createUser(User user){
        userService.createUser(user);
        ModelAndView mav = new ModelAndView();
        //视图逻辑名，被解析器映射为WEB-INF/views/user/createSuccess.jsp
        //并将该页面的内容返回给客户端
        mav.setViewName("user/createSuccess");
        //model，将user的值一并传递给上述jsp视图页面
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/showUserList")
    public String showUserList(ModelMap mm){
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("Tom");
        user1.setRealName("汤姆");
        user1.setPassword("201314");
        userList.add(user1);

        User user2 = new User();
        user2.setUserName("Amy");
        user2.setRealName("艾米");
        user2.setPassword("longlongAgo");
        userList.add(user2);
        mm.addAttribute("userList", userList);
        return "user/userList";
    }

    @RequestMapping("/showUserListByXls")
    public String showUserListInExcel(ModelMap mm){
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("Tom");
        user1.setRealName("汤姆");
        user1.setPassword("201314");
        userList.add(user1);

        User user2 = new User();
        user2.setUserName("Amy");
        user2.setRealName("艾米");
        user2.setPassword("longlongAgo");
        userList.add(user2);
        mm.addAttribute("userList", userList);
        return "userListExcel";
    }

    @RequestMapping("/showUserListByPdf")
    public String showUserListInPdf(ModelMap mm){
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("Tom");
        user1.setRealName("汤姆");
        user1.setPassword("201314");
        userList.add(user1);

        User user2 = new User();
        user2.setUserName("Amy");
        user2.setRealName("艾米");
        user2.setPassword("longlongAgo");
        userList.add(user2);
        mm.addAttribute("userList", userList);
        return "userListPdf";
    }

    @RequestMapping("/showUserListByXml")
    public String showUserListInXml(ModelMap mm){
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("Tom");
        user1.setRealName("汤姆");
        user1.setPassword("201314");
        userList.add(user1);

        User user2 = new User();
        user2.setUserName("Amy");
        user2.setRealName("艾米");
        user2.setPassword("longlongAgo");
        userList.add(user2);
        mm.addAttribute("userList", userList);
        return "userListXml";
    }

    @RequestMapping("/showUserListByJson")
    public String showUserListInJson(ModelMap mm){
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("Tom");
        user1.setRealName("汤姆");
        user1.setPassword("201314");
        userList.add(user1);

        User user2 = new User();
        user2.setUserName("Amy");
        user2.setRealName("艾米");
        user2.setPassword("longlongAgo");
        userList.add(user2);
        mm.addAttribute("userList", userList);
        return "userListJson";
    }

    @RequestMapping("/uploadPage")
    public String uploadPage(){
        return "user/uploadPage";
    }
    @RequestMapping("/upload")
    public String updateThumb(@RequestParam("name")String name, @RequestParam("file") MultipartFile file, HttpServletRequest req){
        String root = req.getServletContext().getRealPath("/");
        System.out.println(root);
        System.out.println(file.getOriginalFilename());
        try {
            System.out.println(new String(file.getBytes(), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!file.isEmpty()){
            try {
                root = root + "/" + file.getOriginalFilename();
                file.transferTo(new File(root));
                return "redirect:success.jsp";
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "redirect:fail.jsp";
        }
        else{
            return "redirect:fail.jsp";
        }
    }
}
