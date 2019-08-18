package chapter2;

import java.math.BigDecimal;
import java.util.*;

public class Redpackage {
	public static List<Integer> divideRedPackage(Integer totalAmount,Integer totalPeople) {
		List<Integer> amountlist =new ArrayList<Integer>();
		Integer restAmount =totalAmount;
		Integer restPeopleNum= totalPeople;
		Random random =new Random();
		for(int i=0;i<totalPeople;i++) {
			//随机范围：[1,剩余人均金额的两倍),左闭右开
			int amount = random.nextInt(restAmount/restPeopleNum);
			restAmount-=amount;
			restPeopleNum --;
			amountlist.add(amount);
		}
		amountlist.add(restAmount);
		return amountlist;
	}
	public static void main(String[] args) {
		List<Integer> amountList = divideRedPackage(5000, 30);
		for(Integer amount : amountList) {
			System.out.println("抢到的金额:"+new BigDecimal(amount).divide(new BigDecimal(100)));
		}
	}
}
