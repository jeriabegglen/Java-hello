/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import static kiss.API.*;

/**
 *
 * @author jeriabegglen
 */
public class Clock {
    //instance variable (one for each object/instance) if you need access outside
    // of the class make a setter and a getter
    private double hours = 0;
    private double minutes = 0;
    private double seconds = 0;
    private boolean started = false;
    private double t0;
    
    void start() {
        started = true;
        t0 = time();
    }
    
    void setHours(double _hours){
        hours = _hours;
        minutes = (hours-Math.floor(hours))*60.0;
        seconds = (minutes-Math.floor(minutes))*60.0;
    }
    double getHours() {
        // you can do an if statement here, or a triany statement (short-handed if statment)
        return started ? (hours + (time()-t0)/3600.0) : hours;
    }
    double getMinutes() {
        double _hours = getHours();
        return (_hours-Math.floor(_hours))*60.0;
    }
    double getSeconds() {
        double _minutes = getMinutes();
        return (_minutes-Math.floor(_minutes))*60.0;
    }
    void testGetTime() {
        Clock clock = new Clock();
        double hours = clock.getHours();
        double minutes = clock.getMinutes();
        double seconds = clock.getSeconds();
    }
    void testGetCorrectTime() {
        Clock clock = new Clock();
        clock.setHours(6.50);
        assert clock.getHours() == 6.50;
        assert clock.getMinutes() == 30.0;
        assert clock.getSeconds() == 0.0;
    }
    
    void testGetFlowingTime() {
        Clock clock = new Clock();
        clock.setHours(1.00);
        clock.start();
        pause(1.0);
        double now = clock.getHours();
        double shouldBe = 1.00 + 1.0/3600.0;
        assert abs(now-shouldBe) < 0.1/3600.0;
        
        
    }
    
}
