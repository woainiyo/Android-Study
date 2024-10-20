package com.example.wsc_test;

import java.util.ArrayList;

public class LandScapeDataCenter {
    private ArrayList<ArrayList<Landscape>>allLandscapelist;
    private ArrayList<Landscape> currentLandscapeList;
    private ArrayList<String> cityList;
    private int currentCityPosition;
    private String currentCityName;
    public LandScapeDataCenter(){
        iniData();
    }
    private void iniData(){
        allLandscapelist=new ArrayList<>();
        cityList=new ArrayList<>();
        ArrayList<Landscape> wenzhou=new ArrayList<>();
        wenzhou.add(new Landscape("Daluo Mountain",R.drawable.da_luo_shan));
        wenzhou.add(new Landscape("Nanxi River",R.drawable.nan_xi_river));
        wenzhou.add(new Landscape("Yandang Mountain",R.drawable.yan_dang_shan));
        insertLandscapeList("Wenzhou",wenzhou);
        ArrayList<Landscape> hangzhou=new ArrayList<>();
        hangzhou.add(new Landscape("West Lake",R.drawable.west_lake));
        hangzhou.add(new Landscape("Qianjiang CBD",R.drawable.qian_jiang_cbd));
        hangzhou.add(new Landscape("Lingyin Temple",R.drawable.ling_yin_temple));
        insertLandscapeList("Hangzhou",hangzhou);
        ArrayList<Landscape> beijing=new ArrayList<>();
        beijing.add(new Landscape("The Imperial Palace",R.drawable.the_imperial_palace));
        beijing.add(new Landscape("Great Wall",R.drawable.great_wall));
        beijing.add(new Landscape("Olympic Sports Center",R.drawable.olympic_sports_center));
        insertLandscapeList("Beijing",beijing);
    }
    private void insertLandscapeList(String cityName,ArrayList<Landscape> landscapeList){
        cityList.add(cityName);
        allLandscapelist.add(landscapeList);
    }
    public ArrayList<Landscape>updateLandscapeList(int position){
        currentCityPosition=position;
        currentLandscapeList=allLandscapelist.get(currentCityPosition);
        currentCityName=cityList.get(currentCityPosition);
        return currentLandscapeList;
    }
    public String getCurrentCityName(){
        return currentCityName;
    }
    public int getCurrentCityPosition(){
        return currentCityPosition;
    }
    public ArrayList<Landscape>getCurrentLandscapeList(){
        return currentLandscapeList;
    }
    public ArrayList<String>getCityList(){
        return cityList;
    }
}
