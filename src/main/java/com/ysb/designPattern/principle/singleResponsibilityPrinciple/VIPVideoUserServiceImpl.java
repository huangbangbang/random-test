package com.ysb.designPattern.principle.singleResponsibilityPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/29 - 11:35
 */
public class VIPVideoUserServiceImpl implements IVideoUserService{
    @Override
    public void difinition() {
        System.out.println("VIP用户，超清视频");
    }

    @Override
    public void ad() {
        System.out.println("VIP用户，无广告");
    }
}
