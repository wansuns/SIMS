package com.lwy.sims.dao;

import com.lwy.sims.entity.StudentInfo;
import com.lwy.sims.entity.StudentScore;
import com.lwy.sims.entity.UserInfo;

/**
 * 存储 程序 运行需要的暂时保存的 数据
 *
 */
public class ComData {
   public static UserInfo utem=null;//登陆成功的用户信息
   static public StudentInfo item=null;//存储在学生信息维护中 点击列表 显示的信息
   static public StudentScore stem=null;//存储在学生成绩维护中 点击列表 显示的信息
}
