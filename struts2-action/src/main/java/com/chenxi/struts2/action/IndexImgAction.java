package com.chenxi.struts2.action;

import com.chenxi.struts2.bean.IndexImg;
import com.chenxi.struts2.dao.IndexImgDao;
import com.chenxi.struts2.util.MyTool;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

public class IndexImgAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private IndexImg indexImg;

    public IndexImg getIndexImg() {
        return indexImg;
    }

    public void setIndexImg(IndexImg indexImg) {
        this.indexImg = indexImg;
    }

    public String Upload() throws IOException {

        //基于myFile创建一个文件输入流
        InputStream is = new FileInputStream(indexImg.getImgFile());
        // 设置上传文件目录
        String uploadPath = ServletActionContext.getServletContext()
                .getRealPath("background/IndexImg");
        // 设置目标文件
        File toFile = new File(uploadPath, this.indexImg.getImgFileFileName());
        // 创建一个输出流
        OutputStream os = new FileOutputStream(toFile);
        //设置缓存
        byte[] buffer = new byte[1024];
        int length = 0;

        //读取File文件输出到toFile文件中
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        indexImg.setFilePath(uploadPath + "\\" + indexImg.getImgFileFileName());
        System.out.println(indexImg.getFilePath());
        System.out.println("上传用户" + indexImg.getName());
        System.out.println("上传文件名" + indexImg.getImgFileFileName());
        System.out.println("上传文件类型" + indexImg.getImgFileContentType());
        //关闭输入流
        is.close();
        //关闭输出流
        os.close();


        HttpServletRequest request = ServletActionContext.getRequest();
        boolean isAdd = new IndexImgDao().addBlog(indexImg);

        if (isAdd) {
            System.out.println("---------------------------");
            request.getSession().setAttribute("sthAdd", "yes");
            request.getSession().setAttribute("dealMsg", "图片上传成功");
            FrontStaticMethod.getIndexImg();
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String DelImg() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String path = request.getParameter("path");

        boolean isDBDel = new IndexImgDao().delImg(path);

        boolean isDiskDel = MyTool.deleteFile(path);

        if (isDBDel && isDiskDel) {
            System.out.println("---------------------------");
            request.getSession().setAttribute("isDel", "yes");
            request.getSession().setAttribute("dealMsg", "IndexImg删除成功");
            FrontStaticMethod.getIndexImg();
            return SUCCESS;
        }

        return SUCCESS;
    }

}

