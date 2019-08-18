
public class Hello {

	public static void main(String []args){
		System.out.println("hello,world");
		String name = "cgj";
		System.out.println("name:"+name);
		int age = 20;
		System.out.println("age:"+age);
		double height = 1.8;
		System.out.println("height:"+height);
		int a = 5;
		//byte e=300;越界，超出byte和short的范围，就是int类型的值
		//数据类型的转换问题
		//4.1赋值时的转换(默认转换，强制转换)
		long b = a;//int类型转long类型-底类型转高类型--默认转换
		int c = (int)b; //long类型转int类型需要强制转换
		System.out.println(c);

		float f = b;
		long bb = (long)2.5;//高类型转底类型强转

		//float类型的赋值
		float f1 = 1;
		float f2 = (float)1.0;//1.0默认为double类型
		float f3 = 1.0f;
		//sDouble.toString(d)
	}
}
