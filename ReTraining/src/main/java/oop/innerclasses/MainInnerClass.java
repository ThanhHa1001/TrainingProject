package oop.innerclasses;

public class MainInnerClass {
	public static void main(String[] args) {
		OuterClass myOuterClass = new OuterClass();
		System.out.println("OuterClass x: " + myOuterClass.x);
		
		OuterClass.InnerClass myInnerClass = myOuterClass.new InnerClass();
		System.out.println("InnerClass y: " + myInnerClass.y);
		
		System.out.println(myOuterClass.x + myInnerClass.y);

		OuterClass.InnerClassStatic myInnerStatic = new OuterClass.InnerClassStatic();
		System.out.println("InnerClassStatic: " + myInnerStatic.w);
	}
}
