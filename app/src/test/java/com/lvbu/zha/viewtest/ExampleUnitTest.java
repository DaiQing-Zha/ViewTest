package com.lvbu.zha.viewtest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    class A{}
    class B extends A{

    }

    @Test
    public void test(){

        B b = new B();
        A a = new A();
        if (b instanceof A){
            System.out.print("--------------");
        }
        if (a instanceof B){
            System.out.print("+++++++++");
        }
    }

    @Test
    public void getBluetoothAddress(){
        //5065838bbe47
        String address = "5065838bbe47";
        if (address.length() >= 2){
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < address.length() - 1; i ++){
                if (i == 0) {
                    stringBuffer = stringBuffer.append(address.substring(i,i + 2));
                }else{
                    stringBuffer = stringBuffer.append(":" + address.substring(i,i + 2));
                }
                i++;
            }
            System.out.print(stringBuffer.toString());
        }
    }
}