package com.ff.mapper;

import java.util.List;

import com.ff.po.Teacher;

public interface TeacherMapper {
	//����ֵ��ʾ�ɹ������˶�����
	public int insertTeacher(Teacher teacher);
	//��ѯ�����е���ʦ
	public List<Teacher> selectAllTeacher();
}
