package com.ff.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ff.mapper.TeacherMapper;
import com.ff.po.Teacher;
import com.ff.util.DBUtil;

public class TeacherMapperTest {
	
	
	public void insertTeacherTest1() {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession(); 
		Teacher teacher = new Teacher("����", "��", 23, "123");
		session.insert("com.ff.mapper.TeacherMapper.insertTeacher", teacher);
		session.commit();//�ύ
		session.close();
	}
	public void insertTeacherTest2() {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession(); 
		Teacher teacher = new Teacher("����", "��", 23, "123");
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		teacherMapper.insertTeacher(teacher);
		session.commit();//�ύ
		session.close();
	}
	//������
	public void insertTeacherTest3() {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession(); 
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		try {
			teacherMapper.insertTeacher(new Teacher("����","Ů",20, "123"));
			teacherMapper.insertTeacher(new Teacher("�Ϲ�", "��", 23, "123"));
			session.commit();//�ύ
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();//�ع�
		}finally {
			session.close();//�ر�
		}
	}
	
	
	public void selectAllTeacherTest() {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession(); 
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		System.out.println(">"+teacherMapper);
		System.out.println(session.getMapper(TeacherMapper.class));
		System.out.println(session.getMapper(TeacherMapper.class));
        List<Teacher> list = teacherMapper.selectAllTeacher();
		session.commit();//�ύ
		session.close();
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
	}
	
	public static void main(String[] args) {
		TeacherMapperTest test = new TeacherMapperTest();
		test.insertTeacherTest1();
		test.insertTeacherTest2();
		test.selectAllTeacherTest();
	}
}







