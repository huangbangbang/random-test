package com.ysb.annotation;

/**
 * @author Huang Bangbang
 * @date 2022/3/3 - 09:39
 */
@MyAnnotation(value = 100)
public class AnnotationTest {

    public static void main(String[] args) {
        boolean annotationPresent = AnnotationTest.class.isAnnotationPresent(MyAnnotation.class);
        AnnotationTest annotationTest = new AnnotationTest();
        boolean present = annotationTest.getClass().isAnnotationPresent(MyAnnotation.class);
        System.out.println(annotationPresent);
        System.out.println(present);
        System.out.println("==================================================================");
        System.out.println(AnnotationTest.class);
        System.out.println(annotationTest.getClass());
        System.out.println("==================================================================");
        MyAnnotation annotation = annotationTest.getClass().getAnnotation(MyAnnotation.class);
        System.out.println(annotation);
        System.out.println(annotationTest.getClass());
    }
}
