package com.mycode.dynamicproxy;


/**
 * 真实角色(被代理的角色)
 * @author herdyouth
 *
 */
public class RealityRole implements CommonInterface {

	@Override
	public void action() {
		System.out.println("真实角色!");
	}
	
}
