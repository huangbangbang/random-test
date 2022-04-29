package com.ysb.designPattern.principle.singleResponsibilityPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/29 - 11:30
 */
public class GuestVideoUserServiceImpl implements IVideoUserService{

    @Override
    public void difinition() {
        System.out.println("访客用户,标清视频");
    }

    @Override
    public void ad() {
        System.out.println("访客用户,有广告");
    }
}
