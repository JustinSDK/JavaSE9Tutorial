/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.openhome.reflect;

/**
 *
 * @author Justin
 */
public class Some {
    private String some;
    public Some(String some) {
        this.some = some;
    }
    public void doSome() {
        System.out.println(some);
    }
}
