package com.baobaotao.aspectj.anno;

/**
 * Created by gzx on 16-11-16.
 */
public class ForumService {
    @NeedTest(value=true)
    public void deleteForum(int forumId){
        System.out.println("delete forum module : " + forumId);
    }
    @NeedTest(value=false)
    public void deleteTopic(int topicId){
        System.out.println("delete topic module : " + topicId);
    }
}
