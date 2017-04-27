package PwnAnalysis;

/**
 * Created by Ayettey on 26/04/2017.
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class PwnAnalysisDiagram extends JPanel {
    private String title;
    private int attackMinute;
    private int attackHours;

    public void setAttackHours(int attackHours) {
        this.attackHours = attackHours;
    }

    public void setAttackMinute(int attackMinute) {
        this.attackMinute = attackMinute;
    }

    public int getAttackHours() {
        return attackHours;
    }

    public int getAttackMinute() {
        return attackMinute;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public PwnAnalysisDiagram(){


    }
    public PwnAnalysisDiagram(String title,String chartTitle) {

        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Attack Minutes","Attack Hours",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 300 , 200 ) );
        add( chartPanel );
    }
    public void createLineDiagram(int attackMinute,int attackHours){


    }

    public DefaultCategoryDataset createDataset(){

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        dataset.addValue( 1 , " Attack Analysis" , "1" );
        dataset.addValue( 2 , "Attack Analysis" , "30" );
        dataset.addValue( 3 , "Attack Analysis" ,  "10" );
        dataset.addValue(  4 , "Attack Analysis" , "21" );
        dataset.addValue( 4 , "Attack Analysis" , "50" );
        dataset.addValue( 6 , "Attack Analysis" , "20" );
        return dataset;

    }



}
