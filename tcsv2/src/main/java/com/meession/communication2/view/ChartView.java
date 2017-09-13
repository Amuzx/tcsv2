package com.meession.communication2.view;

import javax.annotation.PostConstruct;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;

import com.meession.communication2.service.INewStudentService;
 
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ChartView implements Serializable {
 
	@ManagedProperty("#{newStudentServiceImpl}")
	private INewStudentService newStudentService;
	
    private PieChartModel pieModel1;
    
    private HorizontalBarChartModel horizontalBarModel;
    
    @PostConstruct
    public void init() {
        createPieModels();
        createBarModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
    
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
     
    public INewStudentService getNewStudentService() {
		return newStudentService;
	}

	public void setNewStudentService(INewStudentService newStudentService) {
		this.newStudentService = newStudentService;
	}

	//=================================================学生评价饼图 start
	private void createPieModels() {
        createPieModel1();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        int star0 = findStarsAccount(0);
        int star1 = findStarsAccount(1);
        int star2 = findStarsAccount(2);
        int star3 = findStarsAccount(3);
        int star4 = findStarsAccount(4);
        int star5 = findStarsAccount(5);
        int star6 = findStarsAccount(6);
        System.out.println(star0+"=="+star1+"=="+star2+"=="+star3+"=="+star4+"=="+star5+"=="+star6);
        pieModel1.set("还未评价", star0);
        pieModel1.set("一星评价", star1);
        pieModel1.set("二星评价", star2);
        pieModel1.set("三星评价", star3);
        pieModel1.set("四星评价", star4);
        pieModel1.set("五星评价", star5);
        pieModel1.set("六星评价", star6);
         
        pieModel1.setTitle("学生评价情况统计图");
        pieModel1.setShowDataLabels(true);
        pieModel1.setLegendPosition("w");
    }
    
    /**
     * 查找每种星星数评价的人数
     * @param starAccount 星星数
     * @return
     */
    private int findStarsAccount(int starAccount){
    	int stars = this.newStudentService.findStarsAccount(starAccount);
    	return stars;
    }
    //====================================================学生评价饼图 end
    
    //====================================================沟通情况确认柱状图 start
    private void createBarModels() {
        createHorizontalBarModel();
    }
    
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
        
        int[] array = findAffirmedUser();
        ChartSeries affirmAccount = new ChartSeries();
        affirmAccount.setLabel("已确认的人数");
        affirmAccount.set("已完成,双方未确认", array[3]);
        affirmAccount.set("已完成,学生已确认", array[2]);
        affirmAccount.set("已完成,双方已确认", array[1]);
        affirmAccount.set("尚未完成", array[0]);
 
        horizontalBarModel.addSeries(affirmAccount);
         
        horizontalBarModel.setTitle("沟通情况确认图");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setAnimate(true);
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("人数");
        xAxis.setMin(0);
        xAxis.setTickCount(11);
        xAxis.setMax(30);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
//        yAxis.setTickFormat("%H:%#M:%S");
        yAxis.setLabel("沟通确认情况");
    }

    /**
     * 查询各个情况的确认人数
     * @return
     */
    private int[] findAffirmedUser(){
    	int[] array = this.newStudentService.findAffirmedUser();
    	return array;
    }
    //===========================================================沟通确认情况柱状图 end
}