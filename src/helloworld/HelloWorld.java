
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
    
int side;
void sideEffect(int y){
    println(y);
}
void testInts(){
    assert Integer.MAX_VALUE == Math.pow(2,31)-1;
    assert Integer.MAX_VALUE == 2_147_483_647;
    assert Integer.MAX_VALUE == 0b0111_1111_1111_1111_1111_1111_1111_1111;
    println(Integer.MAX_VALUE);
    assert Integer.MIN_VALUE == -Math.pow(2,31);
    println (Integer.MIN_VALUE);
    assert Integer.MIN_VALUE == -2_147_483_648;
    assert Integer.MIN_VALUE == 0b1000_0000_0000_0000_0000_0000_0000_0000;
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
    
    int a = 1;
    ++a;
    try (Close out = outExpect("2")){println(a);}
    
    try (Close out = outExpect("3")){println(++a);}
    try (Close out = outExpect("3")){println(a);}
    
    try (Close out = outExpect("3")){println(a++);}
    try (Close out = outExpect("4")){println(a);}
    
    //bitwise operators 
    
    assert   ~0b0000_0000_0000_0000_0000_0000_1111_0000
           == 0b1111_1111_1111_1111_1111_1111_0000_1111;
    
    assert                                  ~0b1111_0000
            == 0b1111_1111_1111_1111_1111_1111_0000_1111;
    
    //logical and two integers...
    assert (0b1111_0000 
         &  0b1010_1010) == 
            0b1010_0000;
    
    //bitwise or
    assert (0b1111_0000 
         |  0b1010_1010) == 
            0b1111_1010;
    
    //bit-shift operator
    assert (0b1010_1111_0000 >> 4) ==
                0b1010_1111;
    
    assert (0b1010_1111_0000 << 4) ==
            0b1010_1111_0000_0000;
    
    seed();//will give you a new random number each time.  take out for tests, 
    //you want a random number for tests.
    int b = random(0,1_000_000);
    println(b);
    
    //Help from this point down!!!!
    assert ((b >> 1) == b/2 );
    assert ((-b >> 1) == -b/2 );
    
    assert ((b << 1) == 2*b );
    assert (((-b) << 1) == 2*(-b));
    
    //two's compliment
    int c = random(-1_000_000, 1_000_000);
    assert ((~c)+1) == -c;
    
    assert -2 == 0b1111_1111_1111_1111_1111_1111_1111_1110;
    
    assert (-2 >> 1) == 0b1111_1111_1111_1111_1111_1111_1111_1111;
    
    //right shifts shift the sign bit in (highest order bit)
    assert (-2 >> 1) == 0b1111_1111_1111_1111_1111_1111_1111_1111;
    }

    void testConvert(){
        byte x = -1;
        assert x == (byte) 0b1111_1111;
        int y = x;
        assert y == -1;
        assert 0b1111_1111_1111_1111_1111_1111_1111_1111 ==
                                (int) (byte) 0b1111_1111;
        
    }
}
    
