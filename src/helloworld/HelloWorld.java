
package helloworld;

import static kiss.API.*;

public class HelloWorld {
    void testrun(){
        try (Close out = outExpect("Hello World!")) {
            run(); 
        }
    }
    
    
    void run(){
        println("Hello World!");
    } 
    
    void testBooleans() {
        assert true != false;
        assert true == true;
        assert false == false;
        try (Close out = outExpect ("true")){println(true);}
        try (Close out = outExpect ("false")){println(false);}
        
        // not operator
        
        assert !true == false;
        assert !false == true;
        
        // and operator
        
        assert (true && true) == true;
        assert (true && false) == false;
        assert (false && true) == false;
        assert (false && false) == false;
        
        assert (false && (random(0,1) == 1)) == false;
    
        assert (false && (1/0 == 3)) == false;
        
        // or operator
        
        assert (true || true) == true;
        assert (true || false) == true;
        assert (false || true) == true;
        assert (false || false) == false;
        
        assert (true || (random(0, 1) == 1)) == true;
    }
    
void testInts(){
    assert Integer.MAX_VALUE == Math.pow(2,31)-1;
    assert Integer.MIN_VALUE == -Math.pow(2,31);
    assert Integer.MIN_VALUE - 1 == Integer.MAX_VALUE;
    assert Integer.MAX_VALUE + 1 == Integer.MIN_VALUE;
    
    int x = 3;
    int y = 0xff_ff;
    int z = 0b10_01;
    
    assert x == 3;
    assert y == 65_535;
    assert z == 9;
    
    assert Integer.toString(x, 10).equals("3");
    assert Integer.toString(y, 16).equals("ffff");
    assert Integer.toString(z, 2).equals("1001");
    
    assert 17/5 == 3;
    assert ((double) 17)/((double) 5) == 3.4;
    assert ((double) (17/5)) == 3.0;
    
    assert 17 % 5 == 2;
    assert -7 % 5 == -2;
    assert -7 % -5 == -2;
            
    }

}
    
