package com.actions;
import com.beans.User;
import com.service.CommentService;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.Comment;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ProductService;
@Controller
@Scope("prototype")
public class commentAction extends ActionSupport {
    @Autowired
    private CommentService cs;
    @Autowired
    UserServiceImpl us;
    private Comment c;
    private int pid;
    HttpSession session=ServletActionContext.getRequest().getSession();
    public int getPid(){return pid}
    public void setPid(int id){this.pid=id;}
    public String execute()throws Exception{
        c.setProductId(pid);
        User user=us.getUserByName((String)session.getAttribute("userName"));
        c.setUserId(user.getId());
        cs.add(c);
        return SUCCESS;
    }
    public Comment getProduct() {
        return c;
    }

    public void setProduct(Comment c) {
        this.c = c;
    }
}
