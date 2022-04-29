package com.ysb.designPattern.principle.singleResponsibilityPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/29 - 11:33
 */
public class OrdinaryVideoUserServiceImpl implements IVideoUserService{
    @Override
    public void difinition() {
        System.out.println("普通会员，高清视频");
    }

    @Override
    public void ad() {
        System.out.println("普通会员，有广告");
    }
}
