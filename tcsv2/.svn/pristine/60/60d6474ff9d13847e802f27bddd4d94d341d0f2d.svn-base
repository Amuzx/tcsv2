package com.meession.communication2.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.meession.communication2.dao.INewPlanDao;
import com.meession.communication2.dao.INewStudentDao;
import com.meession.communication2.dao.INewUserDao;
import com.meession.communication2.entity.NewModel;
import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;
import com.meession.communication2.service.INewUserService;

@SuppressWarnings("serial")
@Service
public class NewUserServiceImpl implements INewUserService,Serializable {

	@Resource(name="newUserDao")
	private INewUserDao newUserDao;
	
	@Resource(name="newPlanDaoImpl")
	private INewPlanDao newPlanDao;
	
	@Resource(name="newStudentDaoImpl")
	private INewStudentDao newStudentDao;

	public void setNewUserDao(INewUserDao newUserDao) {
		this.newUserDao = newUserDao;
	}

	/**
	 * 添加学生
	 */
	@Override
	public NewUser addStudentUser(NewUser newuser) {
		this.newUserDao.addStudentUser(newuser);
		return newuser;
	}
	
	/**
	 * 根据ID删除学生
	 */
	@Override
	public String deleteStudentUserById(int id,String stuNo){
		List<NewPlan> planList = this.newStudentDao.findPlanByStudentNo(stuNo);
		if(planList.size() > 0){
			return "delete failure";
		}else{
			this.newUserDao.deleteStudentUserById(id);
			return "delete succeed";
		}
	}

	/**
	 * 查询所有的学生
	 */
	@Override
	public List<NewUser> listStudentUser() {
		List<NewUser> listStudent = this.newUserDao.listStudentUser();
		return listStudent;
	}

	/**
	 * 解析Excel，将每行数据封装成一个NewUser对象
	 */
	public static List<NewUser> changeExcelToObject(InputStream inputStream) {
		List<NewUser> listStudent = new ArrayList<NewUser>();
		NewUser student = null;
		
		ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int count;
		try {
			while ((count = inputStream.read(buffer)) != -1){
				byteOS.write(buffer, 0, count);
			}
			byteOS.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		byte[] allBytes = byteOS.toByteArray();
		InputStream byteIS = new ByteArrayInputStream(allBytes);
		
		try{
			//创建Excel工作簿
			XSSFWorkbook hwb = new XSSFWorkbook(byteIS);
			//得到一个工作表
			XSSFSheet sheet = hwb.getSheetAt(0);
			XSSFRow row = null;
			//日期格式化
			DateFormat df = new SimpleDateFormat("yyyy");
			//遍历该表格中所有的工作表，i表示工作表的数量，getNumberOfSheets表示工作表的总数
			for(int i=0;  i<hwb.getNumberOfSheets(); i++){
				sheet = hwb.getSheetAt(i);
				//遍历所有的行，j表示行数，getPhysicalNumberOfRows行的总数
				for(int j=0; j<sheet.getPhysicalNumberOfRows(); j++){
					row = sheet.getRow(j);
					student = new NewUser();
					
					//=====================将每行数据转成一个NewUser的对象
					//学生学号
					student.setStuNumber(NewUserServiceImpl.getCellValue(row.getCell(0)));
					//学生姓名
					student.setStuName(NewUserServiceImpl.getCellValue(row.getCell(1)));
					//学生性别
					String sex = NewUserServiceImpl.getCellValue(row.getCell(2));
					student.setStuSex(Integer.valueOf(sex));
					//学生专业
					student.setStuMajor(NewUserServiceImpl.getCellValue(row.getCell(3)));
					//学生QQ
					student.setStuQQ(NewUserServiceImpl.getCellValue(row.getCell(4)));
					//入学年份
					Date year = df.parse(NewUserServiceImpl.getCellValue(row.getCell(5)));
					student.setStuYear(year);
					//班级
					student.setStuClass(NewUserServiceImpl.getCellValue(row.getCell(6)));
					//电话
					student.setStuTel(NewUserServiceImpl.getCellValue(row.getCell(7)));
					//==========================================
					
					listStudent.add(student);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listStudent;
	}
	
	/**
	 * 插入学生列表
	 */
	@Override
	public String addStudent(InputStream is){
		List<NewUser> listStudent = NewUserServiceImpl.changeExcelToObject(is);
		if(listStudent.size() > 0){
				for(NewUser newuser : listStudent){
					newuser.setType(2);
					System.out.println(newuser.getStuNumber()+"："+newuser.getStuName()+"："+newuser.getStuSex()+"："+newuser.getStuMajor()+"："+newuser.getStuTel());
					this.newUserDao.addStudentUser(newuser);
				}
		}else{
			System.out.println("表格没有数据！");
			return "failure";
		}
		return "successful";
	}
	
    //判断从Excel文件中解析出来数据的格式  
    private static String getCellValue(XSSFCell cell){  
        String value = null;  
        //简单的查检列类型  
        switch(cell.getCellType())  
        {  
            case XSSFCell.CELL_TYPE_STRING://字符串  
                value = cell.getRichStringCellValue().getString();  
                break;  
            case XSSFCell.CELL_TYPE_NUMERIC://数字  
                long dd = (long)cell.getNumericCellValue();  
                value = dd+"";  
                break;  
            case XSSFCell.CELL_TYPE_BLANK:  
                value = "";  
                break;     
            case XSSFCell.CELL_TYPE_FORMULA:  
                value = String.valueOf(cell.getCellFormula());  
                break;  
            case XSSFCell.CELL_TYPE_BOOLEAN://boolean型值  
                value = String.valueOf(cell.getBooleanCellValue());  
                break;  
            case XSSFCell.CELL_TYPE_ERROR:  
                value = String.valueOf(cell.getErrorCellValue());  
                break;  
            default:  
                break;  
        }  
        return value;  
    }

	@Override
	public NewUser findByUsername(String username) {
		return newUserDao.findByUsername(username);
    }

	@Override
	public void addStudent(NewUser student) {
		newUserDao.addstudent(student);
	}

	@Override
	public String insertPlanToStudent(List<NewUser> selectedStudentList,NewPlan newPlan) {
		newPlan.setScore(0);
		newPlan.setStatus(0);
		newPlan.setStustatus(0);
		for(int i=0; i<selectedStudentList.size(); i++){
			NewUser user = this.newStudentDao.findStudent(selectedStudentList.get(i).getId());
			newPlan.setStudentname(user.getStuName());
			newPlan.setStudentnum(user.getStuNumber());
			newPlan.setNewuser(user);
			this.newPlanDao.save(newPlan);
		}
		return "successful";
	}

	@Override
	public List<NewModel> listModel() {
		List<NewModel> listModel = this.newPlanDao.listModel();
		return listModel;
	}

	@Override
	public List<NewPlan> listuserplan(String username) {
		
		return newUserDao.listuserplan(username);
	}  
	
}
