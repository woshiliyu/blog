package com.ly.provider.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

@Controller
public class TestThymeleafcontroller {

    @GetMapping("/test")
     public String test(ModelMap mmap){
        return "/article/addarticle";
     }

    @GetMapping("/head")
    public String head(ModelMap mmap){
        return "head";
    }
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public JSONObject upload(@RequestParam("fileName") MultipartFile[] fileName, HttpServletRequest request) {

        JSONObject obj = new JSONObject();

        ArrayList<String> list = new ArrayList<String>();

        try {

            for (MultipartFile multipartFile : fileName) {
                String newFileName = multipartFile.getOriginalFilename();
                String filePath = "D:\\" + newFileName;
                multipartFile.transferTo(new File(filePath));

                String viewImagePath = "/view/" + newFileName;
                list.add(viewImagePath);
            }

            String[] str = new String[list.size()];
            String[] img = list.toArray(str);
            obj.put("errno", 0);
            obj.put("data", img);

        } catch (Exception e) {

            obj.put("errno", -1);
            obj.put("data", "上传失败!");

            e.printStackTrace();
        }

        return obj;
    }


    @RequestMapping(value = "/view/{fileName}", method = RequestMethod.GET)
    public void visitImg(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        FileInputStream fis = null;
        StringBuffer sb = new StringBuffer(20);
        try {
            sb.append("D:\\");

            String imgPath = sb.toString() + fileName;

            ServletOutputStream os = response.getOutputStream();
            fis = new FileInputStream(imgPath);
            byte[] bs = new byte[fis.available()];
            fis.read(bs);
            os.write(bs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    //上传缩率图照片
    @RequestMapping(value = "/updateThumbImg",method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {



        String str="";
        String url=request.getRequestURI();
        System.out.println("URL:"+url);

        try {
            if(null!=file){
                //获得当前项目所在路径
                String pathRoot=request.getSession().getServletContext().getRealPath("");
                System.out.println("当前项目所在路径："+pathRoot);
                //生成uuid作为文件名称
                String uuid=UUID.randomUUID().toString().replaceAll("-","");
                System.out.println("文件名称："+uuid);
                //获得文件类型（判断如果不是图片文件类型，则禁止上传）
                String contentType=file.getContentType();
                System.out.println("文件类型："+contentType);
                //获得文件后缀名称
                String imageName=contentType.substring(contentType.indexOf("/")+1);
                System.out.println("文件后缀名称："+imageName);

                String filePath="D:\\"+"/updateThumb/images/";
                //根据日期来创建对应的文件夹
                String datePath=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
                System.out.println("日期："+datePath);
                //根据id分类来创建对应的文件夹
               // String leagueIdPath=league_id+"/";

                //日期
                /*String path=filePath+datePath;*/
                //联赛id
                String path=filePath+datePath;

                //如果不存在，则创建新文件夹
                File f=new File(path);
                if(!f.exists()){
                    f.mkdirs();
                }

                //新生成的文件名称
                String fileName=uuid+"."+imageName;
                System.out.println("新生成的文件名称："+fileName);
                //session.setAttribute("fileName",fileName);

                //图片保存的完整路径
                String pathName=path+fileName;
                System.out.println(pathName);

                //获取所属联赛ID
                //int leagueID=Integer.parseInt(league_id);

                //图片的静态资源路径
                String staticPath="/upload/images/"+fileName;
                System.out.println("静态资源路径："+staticPath);

                //复制操作
                //将图片从源位置复制到目标位置
                file.transferTo(new File(pathName));

                str = "{\"code\": 0,\"msg\": \"\",\"data\": {\"src\":\"" +pathName+ "\"}}";

//                photo.setStaticPath(staticPath);    //将图片保存的静态资源路径插入数据库
//                photo.setLeagueID(leagueID);        //将所属联赛ID插入数据库
//                photo.setUploadDate(datePath);      //将上传日期插入数据库
//                photo.setDestFile(pathName);        //将完整路径插入数据库
//                photo.setFileName(fileName);        //将最后保存的完整文件名插入数据库
//                photoRepository.save(photo);
            }
            else{
                System.out.println("文件为空");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            return str;
        }

    }

}
