package com.alibaba.service.impl;

import com.alibaba.dao.StudentDao;
import com.alibaba.model.Student;
import com.alibaba.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Resource
    //自动装配，默认按名称装配
//    @Autowired
    private StudentDao studentDao;

    public List<Student> list() {

        return studentDao.list();
    }

    public boolean updateByPrimaryKey(Student student) {
       return studentDao.updateByPrimaryKey(student);


    }

    public void deleteByPrimaryKey(Long id) {
       // Long begin = System.currentTimeMillis();
        studentDao.deleteByPrimaryKey(id);
       // Long after = System.currentTimeMillis();
        //System.out.println(after - begin + "ms");

    }

    public int insert(Student student) {

        return studentDao.insert(student);
    }


    public Student selectByPrimaryKey(Long id) {

        return studentDao.selectByPrimaryKey(id);
    }

    public Student selectById(Long id) {

        return studentDao.selectById(id);
    }

}





