// IMyAidlInterface.aidl
package com.demo.aidl;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
//    /**
//     * Demonstrates some basic types that you can use as parameters
//     * and return values in AIDL.
//     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);

    //新加接口后，需要点击 Build -> make project 构建下当前项目后， 有类实现接口时候，默认实现的方法也是新加的接口
    String getName();
}
